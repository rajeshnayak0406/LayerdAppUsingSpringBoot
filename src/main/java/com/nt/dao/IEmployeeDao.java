package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDao {

	public List<Employee> getEmpByDesg(String desg1, String desg2,String desg3) throws Exception;
	
	
}
