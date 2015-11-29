package com.bcus.service;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bcus.UserDetails;
import com.bcus.dao.UserDAO;

@Path("/user")
public class UserService {

	UserDAO dao = new UserDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails getUserCardDetails(@QueryParam("email_id") String userEmail) throws SQLException
	{
		return dao.getCardDetails(userEmail);
	}
}