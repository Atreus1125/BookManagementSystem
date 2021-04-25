package JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConn 
{
	private static Connection conn;
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "library";
	private static String password = "123";
	//静态代码块
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");//注册
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//数据库连接
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//关闭数据库连接
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
