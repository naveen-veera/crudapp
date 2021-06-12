package crudapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudapp.dao.UserDAO;
import crudapp.model.User;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= this.getServletContext().getRequestDispatcher("src/main/webapp/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		
		User user = new User(email,password);
		
		UserDAO userdao = new UserDAO();
		boolean status = userdao.checkUser(user);
		if(status) {
			System.out.println("user is present");
		}
		else {
			System.out.println("please register yourself");
		}
		
	}

}
