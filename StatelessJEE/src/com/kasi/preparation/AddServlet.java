package com.kasi.preparation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	MyBean myBean;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =  response.getWriter();
		
		myBean.setI(Integer.parseInt(request.getParameter("t1")));
		myBean.setJ(Integer.parseInt(request.getParameter("t2")));
		myBean.add();
		
		out.println("Result: " + myBean.getK());
	}

}
