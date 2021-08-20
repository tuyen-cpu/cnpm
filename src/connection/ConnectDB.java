package connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
//	private static String url = "jdbc:sqlserver://localhost;databaseName=CNPM";
//	private static String username = "sa";
//	private static String password = "123";
//	private static String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String driverClass = "org.sqlite.JDBC";
	private static String url = "jdbc:sqlite:cnpm.db";
	static {
		try {
			Class.forName(driverClass);
			System.out.println("tuyen");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(url, username, password);
//	}
	public static boolean checkDBExists(String dbName){
		File file = new File (dbName);
		if(file.exists()){
			System.out.println("đã có");
			return true;
		}else{
			System.out.println("chưa có");
			return false;
		}
	}
	public static Connection getConnection(){
		Connection c = null;
		Statement stmt = null;
		if(!checkDBExists("cnpm.db")){
			System.out.println("zô chưa có và tạo");
			try {
				Class.forName(driverClass);
				c = DriverManager.getConnection(url);
				System.out.println("Database Opened...\n");
				stmt = c.createStatement();
				String sql1 = "CREATE TABLE Product " +
				"(Id int IDENTITY(1,1)primary key not null," +
				"NamePro nvarchar(50)," +
				"Price float," +
				"Quantity int," +
				"Brand nvarchar(50),"+
				"Descriptions nvarchar(100))";
				
				String sql2 = "CREATE TABLE Account" +
				"(UserName varchar(30) primary key ," +
				"Passwd varchar(100) not null," +
				"RoleAccount int)" ;
				
				String sql3 = "CREATE TABLE Employee" +
				"(Id INTEGER primary key AUTOINCREMENT," +
				"FullName nvarchar(50)," +
				"PhoneNum varchar(30),"+
				"AddressNum varchar(100)," +
				"UserName varchar(30),"+
				"CONSTRAINT fk FOREIGN KEY (UserName)REFERENCES Account(UserName))";
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);
				stmt.executeUpdate(sql3);
				stmt.close();
//				c.close();
				return c;
				}

				catch ( Exception e ) {

				System.err.println( e.getClass().getName() + ": " + e.getMessage() );

				System.exit(0);

				}
		}else{
			System.out.println("zô kết nối");
			try {
				c= DriverManager.getConnection(url);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}		
		
	return c;
	}
	
}
