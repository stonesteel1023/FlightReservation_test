package flight2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:oracle"; // 203.233.199.200
	private static final String id = "C##STONESTEEL";
	private static final String password = "tiger";
	
	//jdbc ����̹� �ε�
		static {
			try {
				Class.forName(driver); 
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		private DatabaseConnection() {}
			
		//Connection �����Ͽ� ����
		public static Connection getConnection() {
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, id, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		//Connection ���� ����
		public static void close(Connection con) {
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
