package JavaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import Classes.Manager;
import Classes.Reader;
import JdbcUtils.JdbcConn;

public class ReaderDao
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	public boolean doInsert(Reader r) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "insert into reader values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r.getRno());
			pstmt.setString(2, r.getRname());
			pstmt.setString(3, r.getRsex());
			pstmt.setString(4, r.getRdept());
			pstmt.setString(5, r.getRpassword());
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
	
	public boolean doUpdate(Reader r) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "update reader set rname = ?,rsex = ?, rdept = ?, rpassword = ? where rno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getRname());
			pstmt.setString(2, r.getRsex());
			pstmt.setString(3, r.getRdept());
			pstmt.setString(4, r.getRpassword());
			pstmt.setInt(5, r.getRno());
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
	
	public boolean doDelete(Reader r) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "delete from reader where rno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r.getRno());
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
			String sql = "select * from reader order by rno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
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
			String sql = "select * from reader where rno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
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
	
	public Vector findByRdept(String rdept) 
	{
		con = JdbcConn.getConnection();
		Vector rowData = new Vector();
		try {
			String sql = "select * from reader where rdept like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + rdept + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
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
	
	public Reader findByRnoRpassword(int rno, String rpassword) 
	{
		con = JdbcConn.getConnection();
		Reader reader = null;
		try {
			String sql = "select * from reader where rno = ? and rpassword = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setString(2, rpassword);
			//pstmt.setInt(2, Integer.valueOf(rpassword));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reader = new Reader(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			return reader;
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
			String sql = "select rno 读者编号, rname 姓名, rdept 性别, rdept 专业, rpassword 密码  from reader";
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
	
	public Reader findByFullRno(int rno) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "select * from reader where rno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			Reader r = null;
			if(rs.next()) {
				r = new Reader();
				r.setRno(rs.getInt(1));
				r.setRname(rs.getString(2));
				r.setRsex(rs.getString(3));
				r.setRdept(rs.getString(4));
				r.setRpassword(rs.getString(5));
			}
			return r;
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
			String sql = "select count (*) from reader";
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
	
	public Reader findByRnoRnameRsexRdept(int rno, String rname, String rsex, String rdept) 
	{
		con = JdbcConn.getConnection();
		Reader reader = null;
		try {
			String sql = "select * from reader where rno = ? and rname = ? and rsex = ? and rdept = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setString(2, rname);
			pstmt.setString(3, rsex);
			pstmt.setString(4, rdept);
			//pstmt.setInt(2, Integer.valueOf(rpassword));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reader = new Reader(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			return reader;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
}
