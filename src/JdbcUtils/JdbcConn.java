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
	//��̬�����
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");//ע��
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ݿ�����
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
	//�ر����ݿ�����
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
