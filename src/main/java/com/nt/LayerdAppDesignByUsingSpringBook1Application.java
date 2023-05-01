package com.nt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayRollSystemControler;
import com.nt.model.Employee;

@SpringBootApplication
public class LayerdAppDesignByUsingSpringBook1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LayerdAppDesignByUsingSpringBook1Application.class, args);

		PayRollSystemControler pm = ctx.getBean("controller", PayRollSystemControler.class);

		Scanner sc = new Scanner(System.in);
		System.out.println("enter desg1");
		String desg1 = sc.next().toUpperCase();

		System.out.println("enter desg2");
		String desg2 = sc.next().toUpperCase();

		System.out.println("enter desg3");
		String desg3 = sc.next().toUpperCase();

		try {

			List<Employee> listEmp = pm.showEmpDetailsByDesg(desg1, desg2, desg3);

			for (Employee employee : listEmp) {
				System.out.println(employee);

			}

		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Internal DBProblem");

		} catch (Exception se) {
			se.printStackTrace();
			System.out.println("Internal Internal unknown problr");

		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
