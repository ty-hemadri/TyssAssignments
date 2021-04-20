package com.tyss.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardDemo
 */
@WebServlet("/ForwardDemo")
public class ForwardDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("user");
		String pass = request.getParameter("pwd");
		if(name.equals("Hemadri") && pass.equals("Hemadri123"))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
			dispatcher.forward(request, response);
		}
		else
		{
			// go back to login page
			writer.println("username or password is incorrect!");
			RequestDispatcher dispatcher= request.getRequestDispatcher("Login.html");
			dispatcher.include(request, response);
		}
	}

}
