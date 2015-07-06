package com.admas.ngemp.sms.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.ngemp.sms.dto.SmsDto;
import com.admas.ngemp.sms.dto.SmsTemplateDto;
import com.admas.ngemp.sms.exception.ExceptionHandler;
import com.admas.ngemp.sms.logic.ISmsLogic;

@Path("/smsServices")
public class SmsService {

	static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(SmsService.class);
	Logger logger = LoggerFactory.getLogger(SmsService.class);
	private static ISmsLogic smsLogicImpl;
	
	/*@GET
	@Path("/sendSms/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getCustomer(@PathParam("id") long id) {
		Customer customer = new Customer();
		 try {
			 customer = smsLogicImpl.getCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(customer).build();

	}*/
	
	/*@GET
	@Path("/getCustomer/{uName}/{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Boolean getCustomer(@PathParam("uName") String uName,@PathParam("password")String password) {
		 try {
			 return smsLogicImpl.getCustomer(uName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	@GET
	@Path("/getCustomerList")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCustomerList(){
		RestResponse response =new RestResponse();
		 try {
			 response.setCustomersList(smsLogicImpl.getCustomerList());
			 response.setStatus(smsLogicImpl.getCustomerList().size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		 return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/addCustomer")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Boolean addCustomer(Customer customer) throws Exception{
		//System.out.println("customer "+customer.toString());
		
		return smsLogicImpl.addCustomer(customer);
		
	}

	@POST
	@Path("/addCustomerDetails")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Boolean addCustomerDetail(CustomerDetail customer) throws Exception{
		
		return smsLogicImpl.addCustomerDetail(customer);
		
	}

	public static ISmsLogic getSmsLogicImpl() {
		return smsLogicImpl;
	}

	public static void setSmsLogicImpl(ISmsLogic smsLogicImpl) {
		SmsService.smsLogicImpl = smsLogicImpl;
	}*/

	@GET
	@Path("/sendSms/{mobile}/{message}/{route}")
	//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response sendSms(@PathParam("mobile") String mobile , @PathParam("message") String message , @PathParam("route") String route) {		
		String result = "";
		try {
			 LOG.info("started ");
			 result = smsLogicImpl.sendSms(mobile , message , route);
			 /*if(mobile.length()!=10){
				 throw new ExceptionHandler(CommServiceErrors.INVALID_MOBILE);
			 }
			 System.out.println("Mobile : "+mobile);*/
			// customer = smsLogicImpl.getCustomer(id);
			 
			// res=smsLogicImpl.sendSms();
		} catch (ExceptionHandler e) {
			//e.printStackTrace();
		}catch(Exception e){
			
		}
		return Response.status(200).entity(result).build();

	}
	
	@POST
	@Path("/sendSmsToMany")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response addCustomer(SmsDto smsDto) throws Exception{
		//System.out.println("customer "+customer.toString());
		
		String result =  smsLogicImpl.sendSms(smsDto);
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/getSmsList")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCustomerList(){
		//RestResponse response =new RestResponse();
		List<SmsTemplateDto> lSmsTemplates = new ArrayList<SmsTemplateDto>();
		 try {
			 lSmsTemplates.addAll(smsLogicImpl.getSmsTempltes());
			// response.setCustomersList(smsLogicImpl.getCustomerList());
			// response.setStatus(smsLogicImpl.getCustomerList().size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		 return Response.status(200).entity(lSmsTemplates).build();
	}

	
	@GET
	@Path("/getDeleveryReport/{orgCode}/{messageId}")
	/*@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})*/
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getDeleveryReport(@PathParam("orgCode") String orgCode, @PathParam("messageId") String messageId) throws Exception{
		//System.out.println("customer "+customer.toString());
		String result="";
		try {
			
			result=  smsLogicImpl.getDeleveryReport(orgCode, messageId);
//			boolean res=smsLogicImpl.getBalance(4);
			logger.info("res=^^=="+result);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return Response.status(200).entity(result).build();
	}
	
	
	
	
	
	@GET
	@Path("/getBalance/{route}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getBalance(@PathParam("route") String route)
			throws Exception {

		String result = "";
		try {

			result = smsLogicImpl.getBalance(Integer.parseInt(route));
			logger.info("res=^****^==" + result);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return Response.status(200).entity(result).build();
	}
	
	/**
	 * @return the smsLogicImpl
	 */
	public static ISmsLogic getSmsLogicImpl() {
		return smsLogicImpl;
	}

	/**
	 * @param smsLogicImpl the smsLogicImpl to set
	 */
	public static void setSmsLogicImpl(ISmsLogic smsLogicImpl) {
		SmsService.smsLogicImpl = smsLogicImpl;
	}

	
	
	
}
