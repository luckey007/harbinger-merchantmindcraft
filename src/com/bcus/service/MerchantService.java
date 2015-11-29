package com.bcus.service;

import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.bcus.dao.MerchantDAO;

@Path("/merchant")
public class MerchantService {
	
	MerchantDAO dao = new MerchantDAO();
	
	@Path("/login")
	@POST
	public Response validateLoginCredentials(@QueryParam("user_id") String username, @QueryParam("pwd") String password) throws SQLException, URISyntaxException
	{
		boolean validCredentials = dao.validateCredentials(username, password);
		
		if(validCredentials)
			return Response.
			status(200).build();
		
		return Response.status(401).build();
	}
}
