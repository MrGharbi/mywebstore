package com.mag.webstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mag.webstore.business.Article;

public class ArticleDAO extends DAOContext{
	
	public static int getArticleCount() {
		try ( Connection connection = DriverManager.getConnection ( dbURL, dbLogin, dbPassword ) ) {
			
			String strSQL = "SELECT count(idArticle) FROM T_Articles";
			try ( Statement statement = connection.createStatement() ) {
				try ( ResultSet resultSet = statement.executeQuery(strSQL)) {
					resultSet.next();
					return resultSet.getInt(1);
				}
			}
			
		} catch ( Exception exception) {
			
			throw new RuntimeException( exception ); 
			
		}
	}
	
	public static Article getArticleById ( int idArticle ) {
		
		try( Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
			String strSQL = "Select * from T_Articles where idArticle=?";
			try ( PreparedStatement statement = connection.prepareStatement(strSQL) ) {
				statement.setInt( 1, idArticle );
				try ( ResultSet resultSet = statement.executeQuery()) {
					resultSet.next();
					return new Article (
									resultSet.getInt ( "idArticle" ),
									resultSet.getString( "description" ),
									resultSet.getString( "brand" ),
									resultSet.getDouble( "unitaryPrice" )
							);
							
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException ( exception);
		}
		
	}
	
}
