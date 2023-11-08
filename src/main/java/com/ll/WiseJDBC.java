package com.ll;

import java.sql.*;

public class WiseJDBC {
    Connection connection;
    void execute() {
        try {
            // JDBC 설정
            String url = "jdbc:mysql://localhost:3306/WiseDB";
            String username = "root";
            String password = "lldj123414";
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("USE WISE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    void saveWise() throws Exception {
//        // sql 실행
//        String sql = "SELECT empno, ename, sal from emp";
//        //sql 문을 실행해줄 객체의 참조값 얻어오기
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        //query문 수행하고 결과셋 객체 얻어오기
//        ResultSet rs = pstmt.executeQuery();
//
//        while (rs.next()) {
//            //empno라는 칼럼을 정수로 얻어내기
//            int empno = rs.getInt("empno");
//            String ename = rs.getString("ename");
//            int sal = rs.getInt("sal");
//
//            System.out.println(+empno + "  |  " + ename + "  |  " + sal);
//        }
//
//    } catch(
//    Exception e)
//
//    {
//        e.printStackTrace();
//    }
//}
}
