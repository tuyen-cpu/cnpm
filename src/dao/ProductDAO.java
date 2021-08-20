package dao;

import connection.ConnectDB;
import model.Account;
import model.Employee;
import model.Product;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {
	public boolean insert(Product product) {
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO PRODUCT(Id, NamePro, Price, Quantity, Brand, Descriptions) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, product.getId());
			stmt.setString(2, product.getNamePro());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.setString(5, product.getBrand());
			stmt.setString(6, product.getDescriptions());
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

	public void view() {
		Connection con = ConnectDB.getConnection();
		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Product p = new Product(22, "Iphone 12 pro max", 120000, 4, "Apple", "Sieu cap vip pro");
		ProductDAO dao = new ProductDAO();
//		dao.insert(p);
		

	}

}
