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
		Reader r = new Reader(16002, "˹ά��", "��", "�������", "123456");
		ReaderDao rdao = new ReaderDao();
		if(rdao.doInsert(r)) {
			System.out.println("����ɹ�");
		}
		else {
			System.out.println("����ʧ��");
		}
	}
	
	@Test
	public void testdoUpdate() 
	{
		Reader r = new Reader(16002, "˹ά��", "��", "�������", "111111");
		ReaderDao rdao = new ReaderDao();
		if(rdao.doUpdate(r)) {
			System.out.println("�޸ĳɹ�");
		}
		else {
			System.out.println("�޸�ʧ��");
		}
	}
	
	@Test
	public void testdoDelete() 
	{
		Reader r = new Reader();
		r.setRno(17002);
		ReaderDao rdao = new ReaderDao();
		if(rdao.doDelete(r)) {
			System.out.println("ɾ���ɹ�");
		}
		else {
			System.out.println("ɾ��ʧ��");
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
		String rdept = "���";
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
