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

public class DeleteController extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Integer empNo = Integer.parseInt(req.getParameter("EmpNo"));
		
		try
		{
		Employee employee = new Employee();
		employee.setEmpNo(empNo);
		
		EmployeeDao employeeDao = new EmployeeDao();
		int delete = employeeDao.deleteRecord(employee);
		if(delete==0)
		{
		out.println("Record is Not found....");
		}
		else
		{
			out.println(delete+"Row is deleted...");
		}
		}catch(SQLException e)
		{
			out.println(e);
		}catch(Exception e)
		{
			out.println(e);
		}
		out.println("<br><br><a href ='index.html'>Back</a>");
	}

}
