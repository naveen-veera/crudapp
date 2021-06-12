package crudapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crudapp.model.User;
import crudapp.utility.ConnectionManager;

public class UserDAO {

	public boolean checkUser(User user) {
		System.out.println("Check user called");
		boolean status = false;
		try{
			Connection connection = ConnectionManager.getConnection();
		
				// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement("select * from usertable where email = ? and password = ? ");
		
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
	
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
	
		} catch (SQLException e) {
			// process sql exception
			System.out.println(e);
		}
		return status;
	}
	

}
