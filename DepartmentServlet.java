package com.mydept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dept.dao.Department;
import com.dept.dao.DepartmentDAOImpl;
import com.dept.dao.Exceptions.*;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       DepartmentDAOImpl ddi=new DepartmentDAOImpl();
    /**
     * @see GenericServlet#GenericServlet()
     */
    public DepartmentServlet() {
        super();
        System.out.println("Department Servlet .Servlet..constructor");
        System.out.println("For Github changes");
        // TODO Auto-generated constructor stub
        System.out.println("For Github changes---1");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Department init() ");
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prudvi");
	        Statement st=con.createStatement();
	        System.out.println("connection established successfully...!!"); 
		} catch (Exception e){
            e.printStackTrace();
        }*/
            

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Department Destroy()...is called");
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Department Servlet Service() .. is called");
		String buttonValue=request.getParameter("submit");
		PrintWriter pw=response.getWriter();
		pw.println("Button clicked id "+buttonValue);
		if(buttonValue.contentEquals("Add Dept"))
		{
			int dno=Integer.parseInt(request.getParameter("v_deptno"));
			String dnm=request.getParameter("v_dname");
			String dloc=request.getParameter("v_loc");
			
			Department deptObj=new Department();// this is blank object
			deptObj.setDepartmentNumber(dno);//html value to be filled here
			deptObj.setDepartmentName(dnm);//html value to be filled here
			deptObj.setDepartmentLocation(dloc);//html value to be filled here
			try {
			ddi.addDepartment(deptObj);
			pw.println("<h4>Department is added to the database</h4>");
		}catch(DepartmentAlreadyExistsException e) {
			pw.println("<h4> Department add issue: "+e.getMessage()+"</h4>");
		}
		}
		else if(buttonValue.contentEquals("Find Dept")) {
			int dno=Integer.parseInt(request.getParameter("v_deptno"));
			
				Department deptObj;
				try {
					deptObj = ddi.findDepartment(dno);
				
				pw.println("<table border=5 cellpadding=10 cellspacing=10>");
			
			pw.println("<tr>");
				pw.println("<td>"+deptObj.getDepartmentNumber()+"</td>");
				pw.println("<td>"+deptObj.getDepartmentName()+"</td>");
				pw.println("<td>"+deptObj.getDepartmentLocation()+"</td>");
			pw.println("</tr>");
			pw.println("</table>");
			
		}catch(NullPointerException e) {
			pw.println("<h4>Finding Department Issue :"+e.getMessage()+"</h4>");
			} 
		}	
		else if(buttonValue.equals("Find All Depts")) 
		{
			pw.println("<table border=1 cellspacing=10 cellpadding=10>");
			pw.println("<th>");		pw.println("DEPT NO");	pw.println("</th>");
			pw.println("<th>");		pw.println("DEPT NAME");pw.println("</th>");
			pw.println("<th>");		pw.println("LOCATION"); pw.println("</th>");
			List<Department> deptList = ddi.findDepartments();
			Iterator<Department> deptIter = deptList.iterator();
			
				while(deptIter.hasNext()) {
					Department deptObj = deptIter.next();
					pw.println("<tr>");
					
							pw.println("<td>");
								pw.println(deptObj.getDepartmentNumber());
							pw.println("</td>");
					
							pw.println("<td>");
								pw.println(deptObj.getDepartmentName());
							pw.println("</td>");

							pw.println("<td>");
								pw.println(deptObj.getDepartmentLocation());
							pw.println("</td>");
							
					pw.println("</tr>");
				}
			pw.println("</table>");
		}
		else if (buttonValue.equals("Modify Dept"))
		{
			
				int dno = Integer.parseInt(request.getParameter("v_deptno")); //to read html variable name's values 
			
			String dnm = request.getParameter("v_dname");
			String dloc = request.getParameter("v_loc");
			Department deptObj = new Department(); //blank one
			deptObj.setDepartmentNumber(dno);
			deptObj.setDepartmentName(dnm);
			deptObj.setDepartmentLocation(dloc);
			try {
			ddi.modifyDepartment(deptObj);
			pw.println("<h4> Department is modified</h4>");
			}catch(DepartmentNotFoundException e) {
    			pw.println("<h4> Department Modify issue: "+e.getMessage()+"</h4>");
    		}
		}
		else if (buttonValue.equals("Delete Dept"))
		{
			int dno = Integer.parseInt(request.getParameter("v_deptno")); //to read html variable name's values 
			Department deptObj = new Department(); //blank one
			deptObj.setDepartmentNumber(dno);
            try {
			ddi.removeDepartment(deptObj);
			pw.println("<h4> Department is deleted</h4>");
            }catch(DepartmentNotFoundException e) {
    			pw.println("<h4> Department delete issue: "+e.getMessage()+"</h4>");
    		}
		
		}
		
		pw.println("<a href='http://localhost:8085/ServletWithParametersProject/'> Back to Welcome </a>");
			
		

	}

}
