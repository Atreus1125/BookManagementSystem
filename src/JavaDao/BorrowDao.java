package JavaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import Classes.Borrow;
import Classes.Manager;
import JdbcUtils.JdbcConn;

public class BorrowDao 
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	public boolean doBorrowInsert(Borrow b) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "insert into borrow values(B_SEQ.nextval, ?, ?, sysdate, null)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b.getRno());
			pstmt.setInt(2, b.getBno());
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public boolean doReturnInsert(Borrow b) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "insert into borrow values(B_SEQ.nextval, ?, ?, null, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b.getRno());
			pstmt.setInt(2, b.getBno());
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public Vector findAll() 
	{
		con = JdbcConn.getConnection();
		Vector rowData = new Vector();
		try {
			String sql = "select * from borrow order by id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getInt(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				rowData.add(row);
			}
			return rowData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public Vector findByRno(int rno) 
	{
		con = JdbcConn.getConnection();
		Vector rowData = new Vector();
		try {
			String sql = "select * from borrow where rno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getInt(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				rowData.add(row);
			}
			return rowData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public Vector findByBno(int bno) 
	{
		con = JdbcConn.getConnection();
		Vector rowData = new Vector();
		try {
			String sql = "select * from borrow where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getInt(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				rowData.add(row);
			}
			return rowData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public Vector findColumnNames() 
	{
		con = JdbcConn.getConnection();
		Vector columnNames = new Vector();
		try {
			String sql = "select id 信息编号, rno 读者编号, bno 图书编号, bdate 借阅日期, rdate 归还日期  from borrow";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			for(int i = 1;i <= colCount;i ++)
			{
				columnNames.add(rsmd.getColumnName(i));
			}
			return columnNames;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public int findTotalNumber() 
	{
		con = JdbcConn.getConnection();
		int sum = 0;
		try {
			String sql = "select count (*) from borrow";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				sum = rs.getInt(1);
			}
			return sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Integer) null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
}
