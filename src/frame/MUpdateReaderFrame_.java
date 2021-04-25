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

import Classes.Manager;
import Classes.Reader;
import JavaDao.ManagerDao;
import JavaDao.ReaderDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MUpdateReaderFrame_ extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public String loginname;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MUpdateReaderFrame frame = new MUpdateReaderFrame();
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
	public MUpdateReaderFrame_() {
		setTitle("\u8BFB\u8005\u4FE1\u606F\u66F4\u65B0\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		lblNewLabel.setBounds(65, 25, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		lblNewLabel_1.setBounds(132, 75, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFB\u8005\u59D3\u540D");
		lblNewLabel_2.setBounds(132, 105, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFB\u8005\u6027\u522B");
		lblNewLabel_3.setBounds(132, 135, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFB\u8005\u4E13\u4E1A");
		lblNewLabel_4.setBounds(132, 165, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BFB\u8005\u5BC6\u7801");
		lblNewLabel_5.setBounds(132, 195, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ReaderDao rdao = new ReaderDao();
				Reader r = new Reader();
				if(!textField.getText().trim().isEmpty()) 
				{
					if(!textField.getText().trim().equals(loginname))
					{
						JOptionPane.showMessageDialog(getContentPane(), "您没有对此读者账号查询的权限");
					}
					else if(rdao.findByFullRno(Integer.valueOf(textField.getText().trim())) != null) 
					{
						r = rdao.findByFullRno(Integer.valueOf(textField.getText().trim()));
						textField_1.setText(String.valueOf(r.getRno()));
						textField_2.setText(r.getRname());
						textField_3.setText(r.getRsex());
						textField_4.setText(r.getRdept());
						textField_5.setText(r.getRpassword());
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "查询不到此读者账号");
					}
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "请输入查询内容");
				}
			
			}
		});
		btnNewButton.setBounds(329, 21, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C\u8D26\u53F7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ReaderDao rdao = new ReaderDao();
				Reader r = new Reader();
				if(!textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty() && !textField_5.getText().isEmpty())
				{
					r.setRno(Integer.valueOf(textField_1.getText()));
					r.setRname(textField_2.getText());
					r.setRsex(textField_3.getText());
					r.setRdept(textField_4.getText());
					r.setRpassword(textField_5.getText());
					if(rdao.findByFullRno(Integer.valueOf(textField_1.getText().trim())) != null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号已存在");
					}
					else if(rdao.doInsert(r))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号添加成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号添加失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "编号、姓名、性别、专业、密码均不能为空");
				}
			
			}
		});
		btnNewButton_1.setBounds(33, 247, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u8D26\u53F7");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ReaderDao rdao = new ReaderDao();
				Reader r = new Reader();
				if(!textField_1.getText().isEmpty())
				{
					r.setRno(Integer.valueOf(textField_1.getText()));
					if(!textField.getText().trim().equals(loginname))
					{
						JOptionPane.showMessageDialog(getContentPane(), "您没有对此读者账号查询的权限");
					}
					else if(rdao.findByFullRno(Integer.valueOf(textField_1.getText().trim())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号不存在");
					}
					else if(rdao.doDelete(r))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者员账号删除成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号删除失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "读者编号不能为空");
				}
			
			
			}
		});
		btnNewButton_2.setBounds(184, 247, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ReaderDao rdao = new ReaderDao();
				Reader r = new Reader();
				if(!textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() && !textField_4.getText().isEmpty() && !textField_5.getText().isEmpty())
				{
					r.setRno(Integer.valueOf(textField_1.getText()));
					r.setRname(textField_2.getText());
					r.setRsex(textField_3.getText());
					r.setRdept(textField_4.getText());
					r.setRpassword(textField_5.getText());
					if(!textField.getText().trim().equals(loginname))
					{
						JOptionPane.showMessageDialog(getContentPane(), "您没有对此读者账号查询的权限");
					}
					else if(rdao.findByFullRno(Integer.valueOf(textField_1.getText().trim())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "不可修改读者编号");
					}
					else if(rdao.doUpdate(r))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者信息修改成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者信息修改失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "编号、姓名、性别、专业、密码均不能为空");
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
		textField_1.setEditable(false);
		textField_1.setBounds(237, 72, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(237, 102, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 132, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 162, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(237, 192, 86, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\BrrowFramePicture.png"));
		lblNewLabel_6.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_6);
	}
}
