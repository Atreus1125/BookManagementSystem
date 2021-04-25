package Test;

import java.util.Vector;

import org.junit.Test;

import Classes.Reader;
import JavaDao.ReaderDao;

public class TestReaderDao 
{
	@Test
	public void testdoInsert() 
	{
		Reader r = new Reader(16002, "斯维因", "男", "软件工程", "123456");
		ReaderDao rdao = new ReaderDao();
		if(rdao.doInsert(r)) {
			System.out.println("插入成功");
		}
		else {
			System.out.println("插入失败");
		}
	}
	
	@Test
	public void testdoUpdate() 
	{
		Reader r = new Reader(16002, "斯维因", "男", "软件工程", "111111");
		ReaderDao rdao = new ReaderDao();
		if(rdao.doUpdate(r)) {
			System.out.println("修改成功");
		}
		else {
			System.out.println("修改失败");
		}
	}
	
	@Test
	public void testdoDelete() 
	{
		Reader r = new Reader();
		r.setRno(17002);
		ReaderDao rdao = new ReaderDao();
		if(rdao.doDelete(r)) {
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testfindAll() 
	{
		ReaderDao rdao = new ReaderDao();
		Vector rowData = new Vector();
		rowData = rdao.findAll();
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByRno() 
	{
		ReaderDao rdao = new ReaderDao();
		int rno = 16002;
		Vector rowData = new Vector();
		rowData = rdao.findByRno(rno);
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByRdept() 
	{
		ReaderDao rdao = new ReaderDao();
		String rdept = "软件";
		Vector rowData = new Vector();
		rowData = rdao.findByRdept(rdept);
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByRnoRpassword() 
	{
		ReaderDao rdao = new ReaderDao();
		Reader reader = new Reader();
		int rno = 16002;
		String rpassword = "111111";
		reader = rdao.findByRnoRpassword(rno, rpassword);
		System.out.println(reader);
	}
	
	@Test
	public void testfindColumnNames() 
	{
		ReaderDao rdao = new ReaderDao();
		Vector columnNames = new Vector();
		columnNames = rdao.findColumnNames();
		System.out.println(columnNames);
	}
}
