package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Let;

public class LetDAO {
	
	public static List<Let> getAll(){
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Let> letovi = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM let";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Let let = new Let();
				let.setId(resultSet.getInt("id"));
				let.setBroj(resultSet.getString("broj"));
				let.setDatumPolaska(resultSet.getTimestamp("datum_polaska"));
				let.setDatumDolaska(resultSet.getTimestamp("datum_dolaska"));
				let.setPolazniAerodrom(AerodromDAO.getById(resultSet.getInt("polazni_aerodrom_id")));
				let.setDolazniAerodrom(AerodromDAO.getById(resultSet.getInt("dolazni_aerodrom_id")));
				let.setBrojSedista(resultSet.getInt("broj_sedista"));
				let.setCena(resultSet.getFloat("cena"));
				
				letovi.add(let);
				
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return letovi;
		
	} 
	
	public static boolean dodajLet(Let let) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			String query = "INSERT INTO let (broj, datum_polaska, datum_dolaska, polazni_aerodrom_id,dolazni_aerodrom_id, broj_sedista, cena) values (?,?,?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, let.getBroj());
			java.sql.Timestamp sqdatumPolaska = new java.sql.Timestamp(let.getDatumPolaska().getTime());
			java.sql.Timestamp sqdatumDolaska = new java.sql.Timestamp(let.getDatumDolaska().getTime());
			preparedStatement.setTimestamp(2, sqdatumPolaska);
			preparedStatement.setTimestamp(3, sqdatumDolaska);
			preparedStatement.setInt(4, let.getPolazniAerodrom().getId());
			preparedStatement.setInt(5, let.getDolazniAerodrom().getId());
			preparedStatement.setInt(6, let.getBrojSedista());
			preparedStatement.setFloat(7, let.getCena());
			
			return preparedStatement.executeUpdate() == 1;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
		return false;
		
	}

}
