package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.DatatypeConverter;

import model.Account;
import model.Employee;
import connection.ConnectDB;

public class AccountDAO {
	public boolean insert(Account account) {
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO Account VALUES ( ?, ?, ?)");
			
			stmt.setString(1, account.getUserName());
			stmt.setString(2, encodeMD5(account.getPassword()));
			stmt.setInt(3, account.getRole());
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

	public static String encodeMD5(String password) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			String myHash = DatatypeConverter.printHexBinary(digest)
					.toUpperCase();
			return myHash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static boolean findAcc(String uname, String pass) {
		String user = "'" + uname + "'";
		String passwd = "'" + pass + "'";
		boolean result = false;
		
		Connection connection = null;
		
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM Account WHERE "
					+ " UserName = " + user + "AND Passwd = " + "'" + encodeMD5(pass) + "'");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) result = true; 
			stm.close();
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			return false;
			
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		
		return result;
	}

}
