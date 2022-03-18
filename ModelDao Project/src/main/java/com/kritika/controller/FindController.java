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

public class FindController extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Integer empNo = Integer.parseInt(req.getParameter("EmpNo"));
		
		try
		{
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employee = employeeDao.findRecord(empNo);
			out.println("<h1>Employee Record</h1>");
			out.println("<hr>");
			out.println("Employee No is :"+employee.getEmpNo()+"<br>");
			out.println("Employee Name is :"+employee.getEmpName()+"<br>");
			out.println("Employee Sal is :"+employee.getEmpSal()+"<br>");
			out.println("<hr>");
			
		}catch(ClassNotFoundException e)
		{
			out.println(e);
		}catch(SQLException e)
		{
			out.println(e);
		}
		out.println("<br><br><a href='index.html'>Back</a>");
	}

}
