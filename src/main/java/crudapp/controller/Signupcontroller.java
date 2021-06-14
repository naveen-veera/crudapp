package crudapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudapp.dao.UserDAO;
import crudapp.model.Users;

public class Signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public UserDAO userDAO = new UserDAO();

    public Signupcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Signup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		
		String username= request.getParameter("email");
		String password = request.getParameter("password");
		UserDAO userdao = new UserDAO();
		Users user = new Users(username,password);
		user.setUsername(username);
		user.setPassword(password);
		
		int status = userdao.signup(user);
		if(status == 1) {
			System.out.println("Success");
		}
		
	}

}
