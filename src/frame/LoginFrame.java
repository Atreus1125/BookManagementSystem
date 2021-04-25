package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import JavaDao.ManagerDao;
import JavaDao.ReaderDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textMno;
	private JTextField textMpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(71, 75, 72, 18);
		getContentPane().add(label);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 483, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(41, 89, 72, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(41, 145, 72, 23);
		contentPane.add(lblNewLabel_1);
		
		textMno = new JTextField();
		textMno.setBackground(new Color(224, 255, 255));
		textMno.setBounds(127, 88, 117, 24);
		contentPane.add(textMno);
		textMno.setColumns(10);
		
		textMpassword = new JTextField();
		textMpassword.setBackground(new Color(224, 255, 255));
		textMpassword.setBounds(127, 144, 117, 24);
		contentPane.add(textMpassword);
		textMpassword.setColumns(10);
		
		JButton btnLogin = new JButton("\u767B\u9646");
		btnLogin.setFont(new Font("宋体", Font.BOLD, 15));
		btnLogin.setBackground(SystemColor.info);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ManagerDao mdao = new ManagerDao();
				ReaderDao rdao = new ReaderDao();
				if(textMno.getText().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "编号不能为空", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
				else if(textMpassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "密码不能为空", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
				else if(mdao.findByMnoMpassword(Integer.valueOf(textMno.getText().trim()), textMpassword.getText().trim()) != null) {
					JOptionPane.showMessageDialog(getContentPane(), "管理员登陆成功！", "登陆信息", JOptionPane.INFORMATION_MESSAGE);
					MainFrame mainframe = new MainFrame();
					mainframe.loginname = textMno.getText();
					mainframe.setTitle("\u7BA1\u7406\u5458\u4E3B\u754C\u9762" + "   欢迎使用，当前登陆管理员账号：" + mainframe.loginname);
					mainframe.setVisible(true);
					setVisible(false);
				}
				else if(rdao.findByRnoRpassword(Integer.valueOf(textMno.getText().trim()), textMpassword.getText().trim()) != null) {
					JOptionPane.showMessageDialog(getContentPane(), "读者登陆成功！", "登陆信息", JOptionPane.INFORMATION_MESSAGE);
					MainFrameReader mainframereader = new MainFrameReader();
					mainframereader.loginname = textMno.getText();
					mainframereader.setTitle("\u8BFB\u8005\u4E3B\u754C\u9762" + "   欢迎使用，当前登陆读者账号：" + mainframereader.loginname);
					mainframereader.setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "用户名或密码错误", "提示信息", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(69, 208, 125, 27);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setFont(new Font("宋体", Font.BOLD, 15));
		btnCancel.setBackground(SystemColor.info);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textMno.setText("");
				textMpassword.setText("");
			}
		});
		btnCancel.setBounds(69, 248, 126, 27);
		contentPane.add(btnCancel);
		
		JButton btnNewButton = new JButton("\uFF01\u6CE8\u518C\u65B0\u7528\u6237");
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MInsertReaderFrame insertreader = new MInsertReaderFrame();
				insertreader.setVisible(true);
			}
		});
		
		btnNewButton.setBounds(101, 356, 125, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uFF1F\u5FD8\u8BB0\u5BC6\u7801");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MFindPasswordFrame findpassword = new MFindPasswordFrame();
				findpassword.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(245, 356, 125, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("JAVA\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_3.setForeground(new Color(199, 21, 133));
		lblNewLabel_3.setFont(new Font("方正粗黑宋简体", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(51, 23, 208, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\5907fc9044a41.png"));
		lblNewLabel_2.setBounds(0, 0, 465, 396);
		contentPane.add(lblNewLabel_2);
	}	
}
