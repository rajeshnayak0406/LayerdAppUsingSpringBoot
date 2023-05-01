package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String query = "SELECT empno,ename,job,sal from emp where job in(?,?,?)";
	@Autowired
	DataSource ds;

	

	@Override
	public List<Employee> getEmpByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> impl=null;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);

			ResultSet res = ps.executeQuery();
			
          impl=new ArrayList();
			while (res.next()) {
				Employee ee = new Employee();
				ee.setEmpno(res.getInt(1));
				ee.setEname(res.getString(2));
				ee.setJob(res.getString(3));
				ee.setSal(res.getInt(4));
				impl.add(ee);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

		return impl;

	}

}
