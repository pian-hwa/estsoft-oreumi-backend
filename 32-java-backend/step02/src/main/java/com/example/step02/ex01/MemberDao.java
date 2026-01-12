package com.example.step02.ex01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * members 테이블의 모든 레코드를 조회
     *
     * @return 조회한 레코드의 목록
     */
    public List<MemberVo> getMemberList() {
        List<MemberVo> memberVoList = new ArrayList<>();

        try {
            connectDatabase();

            String query = "SELECT * FROM members";
            System.out.println("QUERY: " + query);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date createdAt = resultSet.getDate("created_at");

                MemberVo memberVo = new MemberVo(id, username, password, name, email, createdAt);
                memberVoList.add(memberVo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (Exception ignore) { }
            if (statement != null) try { statement.close(); } catch (Exception ignore) { }
            if (connection != null) try { connection.close(); } catch (Exception ignore) { }

            System.out.println("SUCCESS: Close the Statement and Connection");
        }

        return memberVoList;
    }

    private void connectDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        System.out.println("SUCCESS: Load the JDBC driver.");

        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("SUCCESS: Connect to the database successfully.");

        statement = connection.createStatement();
        System.out.println("SUCCESS: Create the database successfully.");
    }
}
