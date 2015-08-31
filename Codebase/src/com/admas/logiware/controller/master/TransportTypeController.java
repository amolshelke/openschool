/**
 * 
 */
package com.admas.logiware.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

/**
 * @author Admas Technologies
 * 
 */
public class TransportTypeController extends BaseController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(TransportTypeController.class);

	/** The controller service. */
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllTransportTypes.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportTypes(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportTypeController: getAllTransportTypes() Method Start.");
		FlowData flowData = null;
		/*
		 * super.handleRequestInternal(request, response); FlowData flowData =
		 * null; if (request.getSession().getAttribute(WebAppConstants.FLOWDATA)
		 * != null) { flowData = (FlowData) request.getSession().getAttribute(
		 * WebAppConstants.FLOWDATA); } if (!flowData.isLoggedIn()) return
		 * super.loginPage(flowData, request);
		 */
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData,
					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects
					.get("lTransports");
			mv.addObject("lTransports", lTransports);

			/*
			 * } catch (LogiwareBaseException _be) {
			 * logger.error("Exception in PaymentController: viewPaymentEntries"
			 * , _be); mv.addObject(WebAppConstants.ERROR_CODE,
			 * _be.getErrorCode());
			 */
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController: getAllTransportTypes() -- ",
					e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}

		return mv;

	}

	@RequestMapping(value = "/showAddTransportType.htm", method = RequestMethod.GET)
	public ModelAndView addTransportType(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportTypeController: addTransportType() Method Start.");
		FlowData flowData = null;

		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {

			resDtoObjects = masterServiceImpl.addTransportType(flowData,
					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			mv.addObject("transportType", new TransportTypeDto());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController addTransportType --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		logger.info("TransportTypeController: addTransportType() Method End.");
		return mv;

	}

	@RequestMapping(value = "/saveTransportType.htm", method = RequestMethod.POST)
	public ModelAndView saveTransportType(
			@ModelAttribute("transportType") TransportTypeDto transportType,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("TransportTypeController: saveTransportType() Method Start.");
		FlowData flowData = null;
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			System.out.println(transportType);
			transportType.setCompId(8);
			reqDtoObjects.put("transportType", transportType);
			resDtoObjects = masterServiceImpl.saveTransportType(flowData, reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
			mv.addObject("lTransports", lTransports);
			
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController saveTransportType --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		logger.info("TransportTypeController: saveTransportType() Method End.");
		return mv;
	}

	@RequestMapping(value = "/showEditTransportType.htm", method = RequestMethod.GET)
	public ModelAndView showEditTransportType(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportTypeController: EditTransportType() Method Start.");
		FlowData flowData = null;
		ModelAndView modelView = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			System.out.println(request.getParameter("id"));
			int id=Integer.parseInt(request.getParameter("id"));
			reqDtoObjects.put("id",id);
			resDtoObjects = masterServiceImpl.showEditTransportType(flowData, reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			modelView = new ModelAndView(viewName);
			modelView.addObject("transportType",
					resDtoObjects.get("transportType"));
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController EditTransportType  --",
					e);
			modelView
					.addObject(
							WebAppConstants.ERROR_CODE,
							LogiwarePortalErrors.GENERIC_EXCEPTION
									.getErrorCode());
		}
		logger.info("TransportTypeController: EditTransportType() Method End.");
		return modelView;
	}
	
	
	@RequestMapping(value="/showDeleteTransportType.htm",method=RequestMethod.GET)
	public ModelAndView showDeleteTransportType(HttpServletRequest request,HttpServletResponse response){
		
		
		logger.info("TransportTypeController: DeleteTransportType() Method Start.");
		FlowData flowData = null;
		ModelAndView modelView = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			System.out.println(request.getParameter("id"));
			int id=Integer.parseInt(request.getParameter("id"));
			reqDtoObjects.put("id",id);
			resDtoObjects = masterServiceImpl.showDeleteTransportType(flowData, reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects.get(WebAppConstants.VIEW_NAME);
			modelView = new ModelAndView(viewName);
			/*modelView.addObject("transportType",
					resDtoObjects.get("transportType"));*/
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController DeleteTransportType  --",
					e);
			modelView.addObject(WebAppConstants.ERROR_CODE,
							LogiwarePortalErrors.GENERIC_EXCEPTION
									.getErrorCode());
		}
		logger.info("TransportTypeController: DeleteTransportType() Method End.");
		return modelView;
	}

	
	
	@RequestMapping(value="/getAllTransportTypeDetails.htm", method=RequestMethod.GET)
	public ModelAndView getAllTransportTypeDetails(HttpServletRequest request, HttpServletResponse response){
		
		
		logger.info("TransportTypeController: getAllTransportTypeDetails() Method Start.");
		FlowData flowData = null;
		/*
		 * super.handleRequestInternal(request, response); FlowData flowData =
		 * null; if (request.getSession().getAttribute(WebAppConstants.FLOWDATA)
		 * != null) { flowData = (FlowData) request.getSession().getAttribute(
		 * WebAppConstants.FLOWDATA); } if (!flowData.isLoggedIn()) return
		 * super.loginPage(flowData, request);
		 */
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
//			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData,
//					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects
					.get("lTransports");
			mv.addObject("lTransports", lTransports);

			/*
			 * } catch (LogiwareBaseException _be) {
			 * logger.error("Exception in PaymentController: viewPaymentEntries"
			 * , _be); mv.addObject(WebAppConstants.ERROR_CODE,
			 * _be.getErrorCode());
			 */
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController: getAllTransportTypeDetails() -- ",
					e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}

		logger.info("TransportTypeController: getAllTransportTypeDetails() Method End.");
		return mv;
		
		
	}
}
