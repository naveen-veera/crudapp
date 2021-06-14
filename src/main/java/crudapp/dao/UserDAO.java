package crudapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import crudapp.model.Users;
import crudapp.utility.ConnectionManager;
import crudapp.utility.HibernateConnectionManager;

public class UserDAO {
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

//	public boolean checkUser(User user) {
//		System.out.println("Check user called");
//		boolean status = false;
//		try{
//			Connection connection = ConnectionManager.getConnection();
//		
//				// Step 2:Create a statement using connection object
//		PreparedStatement preparedStatement = connection.prepareStatement("select * from usertable where email = ? and password = ? ");
//		
//			preparedStatement.setString(1, user.getEmail());
//			preparedStatement.setString(2, user.getPassword());
//	
//			System.out.println(preparedStatement);
//			ResultSet rs = preparedStatement.executeQuery();
//			status = rs.next();
//	
//		} catch (SQLException e) {
//			// process sql exception
//			System.out.println(e);
//		}
//		return status;
//	}

	public int signup(Users user) {
		System.out.println("Works 1");
		Session session = this.sessionFactory.openSession();
		System.out.println("Works 2");
		Transaction transaction =  session.beginTransaction();
		System.out.println(user);
		System.out.println(transaction);
		System.out.println(session);
		if(session.save(user) != null) {
			transaction.commit();
			session.close();
			return 1;
		}else {
			return 0;
		}
		

	}
}
