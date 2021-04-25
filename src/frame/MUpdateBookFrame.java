package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Classes.Book;
import Classes.Manager;
import JavaDao.BookDao;
import JavaDao.ManagerDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MUpdateBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MUpdateBookFrame frame = new MUpdateBookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MUpdateBookFrame() {
		setTitle("\u56FE\u4E66\u4FE1\u606F\u66F4\u65B0\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		lblNewLabel.setBounds(62, 25, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		lblNewLabel_1.setBounds(132, 70, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		lblNewLabel_2.setBounds(132, 110, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u7C7B\u522B");
		lblNewLabel_3.setBounds(132, 150, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5F53\u524D\u72B6\u6001");
		lblNewLabel_4.setBounds(132, 190, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BookDao bdao = new BookDao();
				Book b = new Book();
				if(!textField.getText().trim().isEmpty()) 
				{
					if(bdao.findByFullBno(Integer.valueOf(textField.getText().trim())) != null) 
					{
						b = bdao.findByFullBno(Integer.valueOf(textField.getText().trim()));
						textField_1.setText(String.valueOf(b.getBno()));
						textField_2.setText(b.getBname());
						textField_3.setText(b.getBsort());
						textField_4.setText(b.getBstate());
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "查询不到此图书");
					}
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "请输入查询内容");
				}
			
			}
		});
		btnNewButton.setBounds(329, 21, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BookDao bdao = new BookDao();
				Book b = new Book();
				if(!textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty())
				{
					b.setBno(Integer.valueOf(textField_1.getText()));
					b.setBname(textField_2.getText());
					b.setBstor(textField_3.getText());
					b.setBstate(textField_4.getText());
					if(bdao.findByFullBno(Integer.valueOf(textField_1.getText().trim())) != null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息已存在");
					}
					else if(bdao.doInsert(b))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息添加成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息添加失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "编号、密码均不能为空");
				}
			
			}
		});
		btnNewButton_1.setBounds(33, 247, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BookDao bdao = new BookDao();
				Book b = new Book();
				if(!textField_1.getText().isEmpty())
				{
					b.setBno(Integer.valueOf(textField_1.getText()));
					if(bdao.findByFullBno(Integer.valueOf(textField_1.getText().trim())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息不存在");
					}
					else if(bdao.doDelete(b))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息删除成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息删除失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "管理员编号不能为空");
				}
			
			
			}
		});
		btnNewButton_2.setBounds(184, 247, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BookDao bdao = new BookDao();
				Book b = new Book();
				if(!textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty())
				{
					b.setBno(Integer.valueOf(textField_1.getText()));
					b.setBname(textField_2.getText());
					b.setBstor(textField_3.getText());
					b.setBstate(textField_4.getText());
					if(bdao.findByFullBno(Integer.valueOf(textField_1.getText().trim())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "不可修改图书编号");
					}
					else if(bdao.doUpdate(b))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息修改成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书信息修改失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "编号、名称、类别、状态均不能为空");
				}
			
			}
		});
		btnNewButton_3.setBounds(329, 247, 113, 27);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(184, 22, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 67, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(237, 107, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 147, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 187, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\FindFramePicture.png"));
		lblNewLabel_5.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_5);
	}

}
