package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;
@Service("empService")
public class EmployeeMAnagementServiceimpl  implements IEmplyeeManagementService{
	@Autowired
	private IEmployeeDao dao;
	
	
	
	
	
	
	@Override
	public List<Employee> fetchEmpDetailsByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> listEmps=dao.getEmpByDesg(desg1, desg2, desg3);
		
		
		
		return listEmps;
		
	}
	

}
