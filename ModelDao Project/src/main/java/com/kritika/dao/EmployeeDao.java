package com.kritika.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kritika.model.Employee;

public class EmployeeDao 
{
	private Connection conn;
	private PreparedStatement pst;
	private String sql;
	ResultSet rs;
	
	public EmployeeDao() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/modeldao","root","");
	}
	public int addRecord(Employee employee)throws SQLException
	{
		sql = "insert into employee values(?,?,?)";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, employee.getEmpNo());
		pst.setString(2, employee.getEmpName());
		pst.setFloat(3, employee.getEmpSal());
		return pst.executeUpdate();
	}
	public int deleteRecord(Employee employee)throws SQLException
	{
		sql = "delete from employee where empno=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1,employee.getEmpNo());
		return pst.executeUpdate();
	}
	public int updateRecord(Employee employee)throws SQLException
	{
		sql = "update employee set empName=?, empSal=? where empNo=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(3,employee.getEmpNo());
		pst.setString(1,employee.getEmpName());
		pst.setFloat(2,employee.getEmpSal());
		return pst.executeUpdate();
	}
	public Employee findRecord(Integer empNo)throws SQLException
	{
		sql = "select * from employee where empNo=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1,empNo);
		rs=pst.executeQuery();
		Employee employee = new Employee();
		if(rs.next()==true)
		{
			employee.setEmpNo(rs.getInt(1));
			employee.setEmpName(rs.getString(2));
			employee.setEmpSal(rs.getFloat(3));
		}
		return employee;
	}
	public List<Employee> findAllRecord()throws SQLException
	{
		sql = "select * from employee";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		List<Employee> store = new ArrayList<>();
		while(rs.next()==true)
		{
			Employee employee = new Employee();
			employee.setEmpNo(rs.getInt(1));
			employee.setEmpName(rs.getString(2));
			employee.setEmpSal(rs.getFloat(3));
			store.add(employee);
		}
		return store;
	}
}
