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

public class MInsertReaderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MInsertReaderFrame frame = new MInsertReaderFrame();
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
	public MInsertReaderFrame() {
		setTitle("\u8BFB\u8005\u6CE8\u518C\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		lblNewLabel_1.setBounds(132, 55, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFB\u8005\u59D3\u540D");
		lblNewLabel_2.setBounds(132, 90, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFB\u8005\u6027\u522B");
		lblNewLabel_3.setBounds(132, 125, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFB\u8005\u4E13\u4E1A");
		lblNewLabel_4.setBounds(132, 160, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BFB\u8005\u5BC6\u7801");
		lblNewLabel_5.setBounds(132, 195, 72, 18);
		contentPane.add(lblNewLabel_5);
		
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
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号已存在，请勿重复注册");
					}
					else if(rdao.doInsert(r))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号注册成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者账号注册失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "编号、姓名、性别、专业、密码均不能为空");
				}
			
			}
		});
		btnNewButton_1.setBounds(184, 247, 113, 27);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 52, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(237, 87, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 122, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 157, 86, 24);
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
