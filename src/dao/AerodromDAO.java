package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aerodrom;

public class AerodromDAO {
	
	public static List<Aerodrom> getAll(){
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		System.out.println(connection);
		ResultSet resultSet = null;
		List<Aerodrom> aerodromi = new ArrayList<>();
		
		try {
			String query =  "SELECT * FROM aerodrom";
			preparedStatement = connection.prepareStatement(query);		
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Aerodrom aerodrom = new Aerodrom();
				aerodrom.setId(resultSet.getInt("id"));
				aerodrom.setNaziv(resultSet.getString("naziv"));
				aerodromi.add(aerodrom);
				
			}
			
			return aerodromi;
		
		}catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
		
		return null;
		
	}
	
	public static Aerodrom getById(int id) {
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		System.out.println(connection);
		ResultSet resultSet = null;
		
		try {
			String query =  "SELECT * FROM aerodrom WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);	
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Aerodrom aerodrom = new Aerodrom();
				aerodrom.setId(resultSet.getInt("id"));
				aerodrom.setNaziv(resultSet.getString("naziv"));
				return aerodrom;
			}
			
			return null;
		
		}catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
		
		return null;
	}

}
