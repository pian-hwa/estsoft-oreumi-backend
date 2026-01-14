package com.example.step05.ex02;

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

        checkRowsColsInResultSet(resultSet);
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
     * PreparedStatement 인스턴스로 SQL 문을 실행하고, 실행 결과를 ResultSet 인스턴스에 저장
     */
    private void executeQuery() throws SQLException {
        if (preparedStatement == null || preparedStatement.isClosed())
            throw new RuntimeException("THE PreparedStatement object is closed.");

        resultSet = preparedStatement.executeQuery();

        checkRowsColsInResultSet(resultSet);
    }

    private void checkRowsColsInResultSet(ResultSet resultSet) throws SQLException {
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
     * ResultSet 인스턴스에서 회원 목록을 생성
     * 
     * @return 회원 목록
     */
    private List<MemberVo> getMemberListFromResultSet() throws SQLException {
        List<MemberVo> memberList = new ArrayList<>();

        resultSet.beforeFirst();

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

        return memberList;
    }

    /**
     * members 테이블의 모든 레코드를 조회
     *
     * @return 조회한 레코드의 목록
     */
    public List<MemberVo> getMemberList() {
        List<MemberVo> memberList = null;

        try {
            String query = "SELECT * FROM members ORDER BY id DESC";
            executeQuery(query);

            memberList = getMemberListFromResultSet();
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

    /**
     * 주어진 로그인 정보가 올바른 정보인지 확인
     *
     * @param memberVo 로그인 정보
     * @return 올바른 로그인 정보인지 여부
     */
    public boolean isValidLogin(MemberVo memberVo) {
        boolean result = false;

        try {
            String query = """
                    SELECT DECODE(COUNT(*), 1, 'true', 'false') AS result
                    FROM members
                    WHERE username = ? AND password = ?
                    """;

            prepareStatement(query);

            preparedStatement.setString(1, memberVo.getUsername());
            preparedStatement.setString(2, memberVo.getPassword());

            executeQuery();

            if (resultSet.first()) {
                result = Boolean.parseBoolean(resultSet.getString("result"));
                System.out.println("RESULT: " + result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }

        return result;
    }

    /**
     * 주어진 username 정보로 회원 정보를 조회
     * @param username 조회하고자 하는 회원의 username 정보
     * @return 조회한 회원 정보
     */
    public MemberVo getMember(String username) {
        MemberVo memberVo = new MemberVo();

        try {
            String query = "SELECT * FROM members WHERE username = ?";

            prepareStatement(query);
            preparedStatement.setString(1, username);

            executeQuery();

            if (resultSet.first()) {
                memberVo.setId(resultSet.getInt("id"));
                memberVo.setUsername(resultSet.getString("username"));
                memberVo.setPassword(resultSet.getString("password"));
                memberVo.setName(resultSet.getString("name"));
                memberVo.setEmail(resultSet.getString("email"));
                memberVo.setCreatedAt(resultSet.getDate("created_at"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }

        return memberVo;
    }

    /**
     * name 컬럼으로 members 테이블을 조회해서 회원 목록을 생성
     *
     * @param name 조회하고자 하는 회원의 이름
     * @return 회원 목록
     */
    public List<MemberVo> getMemberListByName(String name) {
        List<MemberVo> memberList = null;

        try {
            String query = String.format("SELECT * FROM members WHERE LOWER(name) LIKE '%%%s%%'", name.toLowerCase());
            executeQuery(query);

            memberList = getMemberListFromResultSet();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }

        return memberList;
    }
}
