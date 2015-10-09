/*Copyright Currencies Direct Ltd 2015-2016. All rights reserved
worldwide. Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.*/
package com.admas.logiware.exception;

/**
 * @author Sonal M.
 * 
 */
public enum LogiwareServiceErrors {

	/**
	 * SUCCESS Response
	 */
	SUCCESS("0000", "Success"),

	/**
	 * FAILED Response
	 */
	GENERIC_EXCEPTION("LW0001", "Generic exception"),
	
	GENERIC_EXCEPTION_HIBERNATE("LW0002", "Generic exception"),
		
	INVALID_INPUT("LW-UM-0001", "Please enter valid parameter"),


	INVALID_CREDENTIALS("LW-UM-0002", "Please enter valid username or password"),	

	
	NO_STATE_FOUND("LW-MM-0007","No States found"),
	
	NO_ROLE_FOUND("LW-MM-0009","No Roles found"),
	
	NO_CITY_FOUND("LW-MM-0001","No cities found"),
	
	NO_COMPANY_FOUND("LW-MM-0002","No companies found"),
	
	NO_CUSTOMER_FOUND("LW-MM-0003","No customers found"),
	
	CUSTOMER_INACTIVE("LA-CI-0001","Customer Inactive"),
	
	NO_EMPLOYEE_FOUND("LW-MM-0004", "No employee found"),
	
	NO_TRANSPORTTYPE_FOUND("LW-MM-0004", "No transport type found"),
	
	NO_TRANSPORTTYPE_DTL_FOUND("LW-MM-0005","No transport type details found"),
	
	NO_BRANCH_FOUND("LW-MM-0006","No branch details found"),
	
	NO_CONTRACT_COMP_FOUND("LW-CC-0001", "No contract company found"),
	NO_ROUTE_PAY_SETTING_FOUND("LW-CC-0002", "No route pay setting found"),
	
	NO_SETTINGS_FOUND("LW-MM-0008","No Settings were found"),
	
	NO_LOWERYOWNERS_FOUND("LW-LO-0001", "No Lowery Owners found"),
	
	NO_LOWERY_FOUND("LW-TD-0001", "No Transport Details found"),
	
	SMS_CONFIG_NOT_FOUND("LW-SM-0001", "Sms Config not found"),
	
	SMS_SENDING_FAIL("LW-SM-0002", "Sms sending fail"),
	
	SMS_DELIVERY_REPORT_FEATCHING_FAIL("LW-SM-0003", "Sms delivery report featching fail"),
	
	SMS_BALANCE_FEATCHING_FAIL("LW-SM-0004", "Sms balance featching fail"),
	
	SMS_SAVING_FAIL("LW-SM-0005", "Sms saving fail"),
	
	NO_PAY_EXCEPTION_FOUND("LW-PS-0001", "No Payment exception found");
	
	
	
	/**
	 * variable for error code
	 */
	private String errorCode;
	/**
	 * variable for error code
	 */
	private String errorDescription;

	/**
	 * @param errorCode
	 * @param errorDescription
	 */
	private LogiwareServiceErrors(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * @return error description
	 */
	public String getErrorDescription() {
		return this.errorDescription;
	}

	/**
	 * @return error code
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return this.errorCode + ":" + this.errorDescription;
	}
}
