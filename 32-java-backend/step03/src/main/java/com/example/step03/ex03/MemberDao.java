package com.example.step03.ex03;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private final DataSource dataSource;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MemberDao() {
        try {
            Context initContext = new InitialContext();

            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/h2");
            System.out.println("SUCCESS: Get the Database object.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Database 인스턴스로 데이터베이스에 연결
     */
    private void getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
            System.out.println("SUCCESS: Get the Connection object.");
        }
    }

    /**
     * SQL 문을 실행할 Statement 생성
     */
    private void createStatement() throws SQLException {
        if (connection == null || connection.isClosed()) getConnection();

        if (statement == null || statement.isClosed()) {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("SUCCESS: Create the Statement object.");
        }
    }

    /**
     * Statement 인스턴스로 SQL 문을 실행
     *
     * @param query 실행할 SQL 문
     */
    private void executeQuery(String query) throws SQLException {
        if (statement == null || statement.isClosed()) createStatement();

        resultSet = statement.executeQuery(query);
        System.out.println("QUERY: " + query);

        // 레코드의 개수를 확인
        resultSet.last();
        int numRows = resultSet.getRow();
        resultSet.beforeFirst();

        System.out.println("ROWS: " + numRows);

        // 각 레코드의 컬럼의 개수를 확인
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numColumns = metaData.getColumnCount();

        System.out.println("COLUMNS: " + numColumns);
    }

    /**
     * SQL 문을 실행하는 PreparedStatement 인스턴스를 생성
     * 
     * @param query 실행할 SQL 문
     */
    private void prepareStatement(String query) throws SQLException {
        if (connection == null || connection.isClosed()) getConnection();

        if (preparedStatement == null || preparedStatement.isClosed()) {
            preparedStatement = connection.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            System.out.println("SUCCESS: Create the PreparedStatement object.");
            System.out.println("QUERY: " + query);
        }
    }

    /**
     * PreparedStatement 인스턴스로 SQL 문을 실행
     *
     * @return SQL 문이 적용된 레코드의 개수
     */
    private int executeUpdate() throws SQLException {
        if (preparedStatement == null || preparedStatement.isClosed())
            throw new RuntimeException("THE PreparedStatement object is closed.");

        int numRows = preparedStatement.executeUpdate();
        System.out.println("ROWS: " + numRows);

        return numRows;
    }

    /**
     * 데이터베이스 연결을 해제
     */
    private void closeConnection() {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) { }
        if (statement != null) try { statement.close(); } catch (SQLException ignore) { }
        if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) { }
        if (connection != null) try { connection.close(); } catch (SQLException ignore) { }

        resultSet = null;
        statement = null;
        preparedStatement = null;
        connection = null;

        System.out.println("SUCCESS: Close the Statement and Connection objects.");
    }

    /**
     * members 테이블의 모든 레코드를 조회
     *
     * @return 조회한 레코드의 목록
     */
    public List<MemberVo> getMemberList() {
        List<MemberVo> memberList = new ArrayList<>();

        try {
            String query = "SELECT * FROM members ORDER BY id DESC";
            executeQuery(query);

            while (resultSet.next()) {
                MemberVo memberVo = new MemberVo(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getDate("created_at")
                );

                memberList.add(memberVo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }

        return memberList;
    }

    /**
     * members 테이블에 새로운 레코드를 추가
     *
     * @param memberVo 추가할 회원 정보
     */
    public void insertMember(MemberVo memberVo) {
        try {
            String query = "INSERT INTO members (id, username, password, name, email) " +
                    "VALUES (NEXTVAL('SEQ_MEMBER_ID'), ?, ?, ?, ?)";

            prepareStatement(query);

            preparedStatement.setString(1, memberVo.getUsername());
            preparedStatement.setString(2, memberVo.getPassword());
            preparedStatement.setString(3, memberVo.getName());
            preparedStatement.setString(4, memberVo.getEmail());

            executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    /**
     * members 테이블에서 레코드 삭제
     *
     * @param id 삭제하고자 하는 레코드의 id
     */
    public void deleteMember(String id) {
        int intId = 0;

        try {
            intId = Integer.parseInt(id);

            String query = "DELETE FROM members WHERE id = ?";

            prepareStatement(query);

            preparedStatement.setInt(1, intId);

            executeUpdate();
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid id for deleting a member.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }
}
