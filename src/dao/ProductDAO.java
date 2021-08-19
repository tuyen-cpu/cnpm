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
import java.sql.SQLException;

public class ProductDAO {
    public boolean insert(Product product) {
        Connection connection = null;
        try {
            connection = ConnectDB.getConnection();
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO PRODUCT VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, product.getNamePro());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setString(4, product.getBrand());
            stmt.setString(5, product.getDescriptions());
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
}
