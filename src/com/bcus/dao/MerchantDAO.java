package com.bcus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcus.util.SQLiteConnection;

public class MerchantDAO {
	
	
	public boolean validateCredentials(String username, String password) throws SQLException
	{
		SQLiteConnection connection = new SQLiteConnection();
		String query = "select 1 from merchant where merchant_id = \"" + username + "\" and salt_password = \"" + password + "\"";
		ResultSet rs = connection.executeQuery(query);
		while(rs.next())
		{
			if(rs.getInt(1)==1)
				return true;
		}
		rs.close();
		connection.close();
		return false;
	}

}
