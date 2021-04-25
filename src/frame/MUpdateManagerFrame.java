package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Classes.Manager;
import JavaDao.ManagerDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MUpdateManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MUpdateManagerFrame frame = new MUpdateManagerFrame();
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
	public MUpdateManagerFrame() {
		setTitle("\u7BA1\u7406\u5458\u4FE1\u606F\u66F4\u65B0\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u7F16\u53F7");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(62, 25, 84, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u7BA1\u7406\u5458\u7F16\u53F7");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(132, 117, 91, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5BC6\u7801");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(132, 176, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		textField_1 =new JTextField();
		textField_1.setBounds(184, 22, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ManagerDao mdao = new ManagerDao();
				Manager m = new Manager();
				if(!textField_1.getText().trim().isEmpty()) 
				{
					if(mdao.findByFullMno(Integer.valueOf(textField_1.getText().trim())) != null) 
					{
						m = mdao.findByFullMno(Integer.valueOf(textField_1.getText().trim()));
						textField_3.setText(String.valueOf(m.getMno()));
						textField_4.setText(m.getMpassword());
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "查询不到此管理员");
					}
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "请输入查询内容");
				}
			}
		});
		btnNewButton.setBounds(329, 21, 113, 27);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 114, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 173, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C\u8D26\u53F7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ManagerDao mdao = new ManagerDao();
				Manager m = new Manager();
				if(!textField_3.getText().isEmpty() && !textField_4.getText().isEmpty())
				{
					m.setMno(Integer.valueOf(textField_3.getText()));
					m.setMpassword(textField_4.getText());
					if(mdao.findByFullMno(Integer.valueOf(textField_3.getText().trim())) != null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员账号已存在");
					}
					else if(mdao.doInsert(m))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员账号添加成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员账号添加失败");
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
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u8D26\u53F7");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ManagerDao mdao = new ManagerDao();
				Manager m = new Manager();
				if(!textField_3.getText().isEmpty())
				{
					m.setMno(Integer.valueOf(textField_3.getText()));
					if(mdao.findByFullMno(Integer.valueOf(textField_3.getText().trim())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员账号不存在");
					}
					else if(mdao.doDelete(m))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员账号删除成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员账号删除失败");
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
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ManagerDao mdao = new ManagerDao();
				Manager m = new Manager();
				if(!textField_3.getText().isEmpty() && !textField_4.getText().isEmpty())
				{
					m.setMno(Integer.valueOf(textField_3.getText()));
					m.setMpassword(textField_4.getText());
					if(mdao.findByFullMno(Integer.valueOf(textField_3.getText().trim())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "不可修改管理员编号");
					}
					else if(mdao.doUpdate(m))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员密码修改成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此管理员密码修改失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "编号、密码均不能为空");
				}
			}
		});
		btnNewButton_3.setBounds(329, 247, 113, 27);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\FindFramePicture.png"));
		lblNewLabel.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel);
	}
}
