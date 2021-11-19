package jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JdbcTest {

    Connection connection;

    private String jdbc_url = "jdbc:mysql://localhost:3306/myspace?characterEncoding=UTF-8&useUnicode=true&serverTimezone=UTC";

    @Before
    public void before() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbc_url,"root","zxc654321");
    }

    @After
    public void after() throws SQLException {
        connection.close();
    }

    @Test
    public void t1() throws SQLException {
        String sql = "create user 'username'@'localhost' identified by 'pass'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select user from mysql.user");
        while (resultSet.next()) {
            String string = resultSet.getString(1);
            System.out.println("user:"+string);
        }
        resultSet.close();
        statement.close();
    }
}
