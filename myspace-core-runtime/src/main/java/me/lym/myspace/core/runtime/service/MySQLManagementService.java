package me.lym.myspace.core.runtime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class MySQLManagementService {

    @Autowired
    private DataSource dataSource;

    public void createUser(String username, String password) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("drop user if exists '" + username + "'");
        statement.execute("create user " + username + " @'localhost' identified by '" + password + "'");
        statement.close();
        connection.close();
    }

    public void createDatabase(String database,String admin) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("create database if not exists " + database);
        if (admin != null) {
            statement.execute("grant all privileges on "+database+".* to "+admin+"@localhost");
            statement.execute("flush privileges");
        }

        statement.close();
        connection.close();
    }

    public void cleanDatabasePrivileges(String database) {

    }



    public void deleteUser(String username) {

    }

    public void deleteDatabase(String database) {

    }
}
