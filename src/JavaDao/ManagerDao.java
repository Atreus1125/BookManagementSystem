package JavaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import Classes.Manager;
import JdbcUtils.JdbcConn;

public class ManagerDao
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	public boolean doInsert(Manager m) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "insert into manager values(?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getMno());
			pstmt.setString(2, m.getMpassword());
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
	
	public boolean doUpdate(Manager m) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "update manager set mpassword = ? where mno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getMpassword());
			pstmt.setInt(2, m.getMno());
			//pstmt.setInt(2, Integer.valueOf(m.getMno()));
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
	
	public boolean doDelete(Manager m) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "delete from manager where mno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getMno());
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
			String sql = "select * from manager order by mno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
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
	
	public Vector findByMno(int mno) 
	{
		con = JdbcConn.getConnection();
		Vector rowData = new Vector();
		try {
			String sql = "select * from manager where mno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
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
	
	public Manager findByMnoMpassword(int mno, String mpassword) 
	{
		con = JdbcConn.getConnection();
		Manager manager = null;
		try {
			String sql = "select * from manager where mno = ? and mpassword = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			pstmt.setInt(2, Integer.valueOf(mpassword));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				manager = new Manager(rs.getInt(1), rs.getString(2));
			}
			return manager;
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
			String sql = "select mno ”√ªß√˚, mpassword √‹¬Î  from manager";
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
	
	public Manager findByFullMno(int mno) 
	{
		con = JdbcConn.getConnection();
		try {
			String sql = "select * from manager where mno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			Manager m = null;
			if(rs.next()) {
				m = new Manager();
				m.setMno(rs.getInt(1));
				m.setMpassword(rs.getString(2));
			}
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			JdbcConn.closeConnection();
		}
	}
}
