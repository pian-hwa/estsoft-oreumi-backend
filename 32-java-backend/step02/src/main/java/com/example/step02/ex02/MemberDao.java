package com.example.step02.ex02;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private DataSource dataSource;
    private Connection connection;
    private Statement statement;
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
     * members 테이블의 모든 레코드를 조회
     *
     * @return 조회한 레코드의 목록
     */
    public List<MemberVo> getMemberList() {
        List<MemberVo> memberVoList = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            System.out.println("SUCCESS: Get the Connection object.");

            statement = connection.createStatement();
            System.out.println("SUCCESS: Get the Statement object.");

            String query = "SELECT * FROM members";
            System.out.println("QUERY: " + query);

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                MemberVo memberVo = new MemberVo(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getDate("created_at")
                );

                memberVoList.add(memberVo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) { }
            if (statement != null) try { statement.close(); } catch (SQLException ignore) { }
            if (connection != null) try { connection.close(); } catch (SQLException ignore) { }

            System.out.println("SUCCESS: Close the Statement and Connection");
        }

        return memberVoList;
    }
}
