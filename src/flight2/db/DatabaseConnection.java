package flight2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:oracle"; // 203.233.199.200
	private static final String id = "C##STONESTEEL";
	private static final String password = "tiger";
	
	//jdbc 드라이버 로딩
		static {
			try {
				Class.forName(driver); 
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		private DatabaseConnection() {}
			
		//Connection 생성하여 리턴
		public static Connection getConnection() {
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, id, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		//Connection 연결 종료
		public static void close(Connection con) {
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
