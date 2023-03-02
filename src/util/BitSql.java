package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

public class BitSql {
	private static Connection conn;
	private BitSql() {}
	private static Map<String, String> env=System.getenv();
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/lecture"
						, env.get("local.mysql.user")
						, env.get("local.mysql.password")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}