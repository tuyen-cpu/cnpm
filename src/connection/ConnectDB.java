package connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Account;
import dao.AccountDAO;

public class ConnectDB {
	private static String driverClass = "org.sqlite.JDBC";
	private static String url = "jdbc:sqlite:cnpm.db";
	static AccountDAO accountDAO;
	static {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static boolean checkDBExists(String dbName) {
		File file = new File(dbName);
		if (file.exists()) {		
			return true;
		} else {			
			return false;
		}
	}

	public static Connection getConnection() {
		Connection c = null;
		Statement stmt = null;
		if (!checkDBExists("cnpm.db")) {
			System.out.println("zô chưa có và tạo");
			try {
				Class.forName(driverClass);
				c = DriverManager.getConnection(url);
				System.out.println("Database Opened...\n");
				stmt = c.createStatement();
				String sql1 = "CREATE TABLE Product "
						+ "(Id int AUTO_INCREMENT primary key not null,"
						+ "NamePro nvarchar(50)," + "Price float,"
						+ "Quantity int," + "Brand nvarchar(50),"
						+ "Descriptions nvarchar(100))";

				String sql2 = "CREATE TABLE Account"
						+ "(UserName varchar(30) primary key ,"
						+ "Passwd varchar(100) not null," + "RoleAccount int)";

				String sql3 = "CREATE TABLE Employee"
						+ "(Id INTEGER primary key AUTOINCREMENT,"
						+ "FullName nvarchar(50),"
						+ "PhoneNum varchar(30),"
						+ "AddressNum varchar(100),"
						+ "UserName varchar(30),"
						+ "CONSTRAINT fk FOREIGN KEY (UserName)REFERENCES Account(UserName))";
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);
				stmt.executeUpdate(sql3);
				stmt.close();
				accountDAO = new AccountDAO();


				try {

					PreparedStatement st = c
							.prepareStatement("INSERT INTO Account VALUES ( ?, ?, ?)");
					st.setString(1, "admin");
					st.setString(2, AccountDAO.encodeMD5("Admin123$"));
					st.setInt(3, 0);
					st.executeUpdate();
					stmt.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
				// c.close();
				return c;
			}

			catch (Exception e) {

				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());

				System.exit(0);

			}
		} else {
			System.out.println("Vào kết nối!");
			try {
				c = DriverManager.getConnection(url);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return c;
	}

	public static void main(String[] args) {
		getConnection();

	}

}
