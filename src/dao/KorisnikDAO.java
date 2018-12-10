package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Korisnik;import sun.security.krb5.internal.util.KrbDataOutputStream;

public class KorisnikDAO {
	
	
	public static boolean register(Korisnik korisnik) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			String query = "INSERT INTO korisnik(korisnicko_ime,loznika,datum_registracije,uloga,blokiran) VALUES (?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, korisnik.getUsername());
			preparedStatement.setString(2, korisnik.getPassword());
			java.sql.Timestamp sqdatumPolaska = new java.sql.Timestamp(korisnik.getDatumRegistracije().getTime());
			preparedStatement.setTimestamp(3, sqdatumPolaska);
			preparedStatement.setBoolean(4, korisnik.isAdmin());
			preparedStatement.setBoolean(5, korisnik.isBlokiran());
			
			return preparedStatement.executeUpdate() == 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {preparedStatement.close();} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static Korisnik login(String username) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String query = "SELECT * korisnik WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Korisnik korisnik = new Korisnik();
				korisnik.setId(resultSet.getInt("id"));
				korisnik.setUsername(resultSet.getString("korisnicko_ime"));
				korisnik.setPassword(resultSet.getString("lozinka"));
				korisnik.setDatumRegistracije(resultSet.getTimestamp("datum_registracije"));
				korisnik.setAdmin(resultSet.getBoolean("uloga"));
				korisnik.setBlokiran(resultSet.getBoolean("blokiran"));
				
				return korisnik;
				
			}
			return null;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {preparedStatement.close();} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static boolean blockUser(String username) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			String query = "UPDATE korisnik set blokiran = 1 WHERE username = ? AND blokiran = 0";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			
			return preparedStatement.executeUpdate() == 1;
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
		
		return false;
	}
	
	public static boolean unblockUser(String username) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			String query = "UPDATE korisnik set blokiran = 0 WHERE username = ? AND blokiran = 1";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			
			return preparedStatement.executeUpdate() == 1;
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
		
		return false;
	}

}
