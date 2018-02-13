package com.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String Name ="admin";
		String password="pwd";
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("password");
		if(userName.equals(Name)&&userPassword.equals(password)) {
			HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(5*60);
            request.setAttribute("message", "Welcome");
			request.getRequestDispatcher("/successLogin.jsp").forward(request, response);
		}
		else {
			 request.setAttribute("errormessage", "invalidUser");
			 request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
		}
		
		
	}


}
