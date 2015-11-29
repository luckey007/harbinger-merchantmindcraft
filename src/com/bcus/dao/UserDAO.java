package com.bcus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bcus.UserDetails;
import com.bcus.util.SQLiteConnection;

public class UserDAO {
	
	public UserDetails getCardDetails(String userEmail) throws SQLException
	{
		SQLiteConnection connection = new SQLiteConnection();
		String query = "select * from user_details where email_id = \"" + userEmail + "\"";
		ResultSet rs = connection.executeQuery(query);
		UserDetails userDetails = new UserDetails();
		while(rs.next())
		{
			userDetails.setCardNo(rs.getString("card_no"));
			userDetails.setExpDate(rs.getString("expiry_date"));
			userDetails.setFullName(rs.getString("full_name"));
		}
		rs.close();
		connection.close();
		return userDetails;
	}
}
