package Test;

import java.util.Vector;

import org.junit.Test;

import Classes.Book;
import JavaDao.BookDao;

public class TestBookDao 
{
	@Test
	public void testdoInsert() 
	{
		Book b = new Book(803, "程序设计", "计算机类", "在馆");
		BookDao bdao = new BookDao();
		if(bdao.doInsert(b)) {
			System.out.println("插入成功");
		}
		else {
			System.out.println("插入失败");
		}
	}
	
	@Test
	public void testdoUpdate() 
	{
		Book b = new Book(803, "程序设计", "计算机类", "借出");
		BookDao bdao = new BookDao();
		if(bdao.doUpdate(b)) {
			System.out.println("修改成功");
		}
		else {
			System.out.println("修改失败");
		}
	}
	
	@Test
	public void testdoDelete() 
	{
		Book b = new Book();
		b.setBno(803);
		BookDao bdao = new BookDao();
		if(bdao.doDelete(b)) {
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testfindAll() 
	{
		BookDao mdao = new BookDao();
		Vector rowData = new Vector();
		rowData = mdao.findAll();
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByBno() 
	{
		BookDao bdao = new BookDao();
		int bno = 401;
		Vector rowData = new Vector();
		rowData = bdao.findByBno(bno);
		System.out.println(rowData);
	}
	
	@Test
	public void testfindColumnNames() 
	{
		BookDao mdao = new BookDao();
		Vector columnNames = new Vector();
		columnNames = mdao.findColumnNames();
		System.out.println(columnNames);
	}
}
