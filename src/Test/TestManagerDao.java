/*package Test;

import java.util.Vector;

import org.junit.Test;

import Classes.Manager;
import JavaDao.ManagerDao;

public class TestManagerDao 
{
	@Test
	public void testdoInsert() 
	{
		Manager m = new Manager("444", "123456");
		ManagerDao mdao = new ManagerDao();
		if(mdao.doInsert(m)) {
			System.out.println("����ɹ�");
		}
		else {
			System.out.println("����ʧ��");
		}
	}
	
	@Test
	public void testdoUpdate() 
	{
		Manager m = new Manager("111", "111441");
		ManagerDao mdao = new ManagerDao();
		if(mdao.doUpdate(m)) {
			System.out.println("�޸ĳɹ�");
		}
		else {
			System.out.println("�޸�ʧ��");
		}
	}
	
	@Test
	public void testdoDelete() 
	{
		Manager m = new Manager();
		m.setId(1);
		ManagerDao mdao = new ManagerDao();
		if(mdao.doDelete(m)) {
			System.out.println("ɾ���ɹ�");
		}
		else {
			System.out.println("ɾ��ʧ��");
		}
	}
	
	@Test
	public void testfindAll() 
	{
		ManagerDao mdao = new ManagerDao();
		Vector rowData = new Vector();
		rowData = mdao.findAll();
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByMno() 
	{
		ManagerDao mdao = new ManagerDao();
		String mno = "2";
		Vector rowData = new Vector();
		rowData = mdao.findByMno(mno);
		System.out.println(rowData);
	}
	
	@Test
	public void testfindByMnoMpassword() 
	{
		ManagerDao mdao = new ManagerDao();
		Manager manager = new Manager();
		String mno = "444";
		String mpassword = "123456";
		manager = mdao.findByMnoMpassword(mno, mpassword);
		System.out.println(manager);
	}
	
	@Test
	public void testfindColumnNames() 
	{
		ManagerDao mdao = new ManagerDao();
		Vector columnNames = new Vector();
		columnNames = mdao.findColumnNames();
		System.out.println(columnNames);
	}
}
*/