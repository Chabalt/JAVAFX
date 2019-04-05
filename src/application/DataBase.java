package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	private static DataBase instance;
	private Connection connection;
	
	private DataBase() {
		connect();
	}
	
	public static DataBase getInstance() {
		if(instance == null) {
			instance = new DataBase();
		}
		return instance;
	}
	
	private void connect() {
		try {
			String url ="jdbc:sqlite:game.db";
			connection = DriverManager.getConnection(url);
			System.out.println("Connextion ok !");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Statement creatStatement () throws SQLException {
		return connection.createStatement();
	}
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
	
}
	