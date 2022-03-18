package com.kritika.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kritika.dao.EmployeeDao;
import com.kritika.model.Employee;

public class FindAllController extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		try
		{
			EmployeeDao employeeDao = new EmployeeDao();
			List<Employee> e = employeeDao.findAllRecord();
			Iterator<Employee> itr = e.iterator();
			
			out.println("<table>");
			while(itr.hasNext())
			{
				Employee employee = itr.next();
				out.println("<tr>");
				out.println("Employee No is: "+employee.getEmpNo()+"<br>");
				out.println("Employee Name is: "+employee.getEmpName()+"<br>");
				out.println("Employee Sal is: "+employee.getEmpSal()+"<br>");
				out.println("</tr>");
				out.println("<br>");
			}
			out.println("</table");
		}catch(Exception e)
		{
			out.println(e);
		}
		out.println("<br><br><a href='findAllController'>Refresh</a>");
		out.println("<br><br><a href='index.html'>Back</a>");
	}

}
