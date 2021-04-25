/*package Test;

import java.util.Vector;

import org.junit.Test;

import Classes.Borrow;
import JavaDao.BorrowDao;
import JavaDao.ReaderDao;

public class TestBorrowDao 
{
	@Test
	public void testdoBorrowInsert() 
	{
		Borrow b = new Borrow(16002, 301, null, null);
		BorrowDao bdao = new BorrowDao();
		if(bdao.doBorrowInsert(b)) {
			System.out.println("插入成功");
		}
		else {
			System.out.println("插入失败");
		}
	}
	
	@Test
	public void testfindAll() 
	{
		BorrowDao bdao = new BorrowDao();
		Vector rowData = new Vector();
		rowData = bdao.findAll();
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByBno() 
	{
		BorrowDao bdao = new BorrowDao();
		int bno = 301;
		Vector rowData = new Vector();
		rowData = bdao.findByBno(bno);
		System.out.println(rowData);
	}
}
*/