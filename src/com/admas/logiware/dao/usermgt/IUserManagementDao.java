package com.admas.logiware.dao.usermgt;

import com.admas.logiware.jpa.Employee;
import com.admas.logiware.jpa.UserDetails;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface IUserManagementDao {

	public UserDetails login(String userName , String password) throws LogiwareExceptionHandler;
	
	public Employee getEmployeeById(Integer empId) throws LogiwareExceptionHandler;
	
	public boolean addUser(com.admas.logiware.dto.UserDetails userDetails) throws LogiwareExceptionHandler;

	public Boolean saveChangePassword(com.admas.logiware.dto.UserDetails userDetails)throws LogiwareExceptionHandler;

	public Employee authenticateEmail(String email)throws LogiwareExceptionHandler;

	public Boolean resetPassword(EmployeeDto employeeDto)throws LogiwareExceptionHandler;
}
