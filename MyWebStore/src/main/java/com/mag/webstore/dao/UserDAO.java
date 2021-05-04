package com.mag.webstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mag.webstore.business.User;

public class UserDAO extends DAOContext {

	public static User isValidLogin ( String login, String password ) {
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			String strSql = "SELECT * FROM T_Users WHERE login=? AND password=?";
			try(PreparedStatement statment = connection.prepareStatement(strSql)){
				statment.setString( 1, login );
				statment.setString( 2, password );
				try( ResultSet resultSet = statment.executeQuery() ){
					if( resultSet.next() ) {
						return new User(
										resultSet.getInt("idUser"),
										resultSet.getString("login"),
										resultSet.getString("password"),
										resultSet.getInt("connectionNumber")
								);
					}else {
							return null;
						}
					}
			}
			} catch ( Exception exception ) {
				throw new RuntimeException (exception);
			}
		}
}
