package com.bcus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.bcus.util.SQLiteConnection;

public class PaymentDAO {
	
	public List<String> listPaymentOptions(String merchantId) throws SQLException
	{
		SQLiteConnection connection = new SQLiteConnection();
		String query = "select * from payment_option";;
		if(merchantId!=null)
			query = "select * from merchant_payment_option where merchant_id = \""+merchantId + "\"";
		ResultSet rs = connection.executeQuery(query);
		List<String> list = new LinkedList<String>();
		while(rs.next())
		{
			list.add(rs.getString(1));
		}
		rs.close();
		connection.close();
		return list;
	}

	public boolean updatePaymentOptionForMerchant(String paymentOption,
			String merchantId) throws SQLException {
		SQLiteConnection connection = new SQLiteConnection();
		String query = "insert into merchant_payment_option values(\""+paymentOption + "\",\""+merchantId + "\",\"20151010\")";
		System.out.println(query);
		boolean returnValue = connection.updateQuery(query);
		connection.close();
		return returnValue;
	
	}

}
