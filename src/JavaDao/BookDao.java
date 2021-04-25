package JavaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import Classes.Book;
import Classes.Manager;
import JdbcUtils.JdbcConn;

public class BookDao
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	public boolean doInsert(Book b) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "insert into book values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b.getBno());
			pstmt.setString(2, b.getBname());
			pstmt.setString(3, b.getBsort());
			pstmt.setString(4, b.getBstate());
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
	
	public boolean doUpdate(Book b) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "update book set bname= ?, bsort = ?, bstate = ? where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getBname());
			pstmt.setString(2, b.getBsort());
			pstmt.setString(3, b.getBstate());
			pstmt.setInt(4, b.getBno());
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
	
	public boolean doDelete(Book b) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "delete from book where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b.getBno());
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
			String sql = "select * from book order by bno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
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
			String sql = "select * from book where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
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
			String sql = "select bno 图书编号, bname 图书名称, bsort 所属类别, bstate 当前状态  from book";
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
	
	public Book findByFullBno(int bno) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "select * from book where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			Book b = null;
			if(rs.next()) {
				b = new Book();
				b.setBno(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setBstor(rs.getString(3));
				b.setBstate(rs.getString(4));
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
	
	public boolean doUpdateState(Book b) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "update book set bstate = ? where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getBstate());
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
	
	public int findTotalNumber() 
	{
		con = JdbcConn.getConnection();
		int sum = 0;
		try {
			String sql = "select count (*) from book";
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
