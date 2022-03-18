package com.kritika.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kritika.dao.EmployeeDao;
import com.kritika.model.Employee;

public class AddController extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Integer empNo = Integer.parseInt(req.getParameter("EmpNo"));
		String empName = req.getParameter("EmpName");
		Float empSal = Float.parseFloat(req.getParameter("EmpSal"));
		
		try
		{
		Employee employee = new Employee();
		employee.setEmpNo(empNo);
		employee.setEmpName(empName);
		employee.setEmpSal(empSal);
		
		EmployeeDao employeeDao = new EmployeeDao();
		int count = employeeDao.addRecord(employee);
		out.println(count + "Row is added....");
		}catch(SQLException e)
		{
			out.println(e);
		}catch(Exception e)
		{
			out.println(e);
		}
		out.println("<br><br><a href='index.html'>Back</a>");
	}
}
