package com.bcus.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bcus.dao.PaymentDAO;


@Path("/paymentOption")
public class PaymentService {

	PaymentDAO dao = new PaymentDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getPaymentOptions(@QueryParam("merchant_id") String merchantId) throws SQLException
	{
		return dao.listPaymentOptions(merchantId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updatePaymentOptionForMerchant(@QueryParam("payment_option") String paymentOption, @QueryParam("merchant_id") String merchantId) throws SQLException
	{
		return dao.updatePaymentOptionForMerchant(paymentOption, merchantId);
	}
}
