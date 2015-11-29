package com.bcus.util;

import java.sql.*;

public class SQLiteConnection {

    private Connection connection = null;
    {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ashish\\Desktop\\sqlite.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
    
    public boolean updateQuery(String query) throws SQLException
    {
    	Statement statement = connection.createStatement();
    	return statement.executeUpdate(query) == 1; 
    }
    
    public void close() throws SQLException
    {
    	connection.close();
    }
}
