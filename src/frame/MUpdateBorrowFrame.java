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

import Classes.Book;
import Classes.Borrow;
import Classes.Reader;
import JavaDao.BookDao;
import JavaDao.BorrowDao;
import JavaDao.ReaderDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MUpdateBorrowFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MUpdateBorrowFrame frame = new MUpdateBorrowFrame();
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
	public MUpdateBorrowFrame() {
		setTitle("\u501F\u9605\u4FE1\u606F\u66F4\u65B0\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		lblNewLabel.setBounds(132, 75, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		lblNewLabel_1.setBounds(132, 165, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(237, 72, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 162, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u501F\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BorrowDao bdao = new BorrowDao();
				Borrow b = new Borrow();
				BookDao bdao_ = new BookDao();
				Book b_ = new Book();
				ReaderDao rdao = new ReaderDao();
				Reader r = new Reader();
				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty())
				{
					b.setRno(Integer.valueOf(textField.getText()));
					b.setBno(Integer.valueOf(textField_1.getText()));
					b_.setBno(Integer.valueOf(textField_1.getText()));
					b_.setBstate("借出");
					if(rdao.findByFullRno(Integer.valueOf(textField.getText())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者不存在");
					}
					else if(bdao_.findByFullBno(Integer.valueOf(textField_1.getText())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书不存在");
					}
					else if(bdao_.findByFullBno(Integer.valueOf(textField_1.getText())).getBstate().equals("借出"))
					{
						JOptionPane.showMessageDialog(getContentPane(), "此书暂时不在馆");
					}
					else if(bdao.doBorrowInsert(b) && bdao_.doUpdateState(b_))
					{
						JOptionPane.showMessageDialog(getContentPane(), "借阅信息更新成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "借阅信息更新失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "读者编号、图书编号均不能为空");
				}
			}
		});
		btnNewButton.setBounds(72, 247, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5F52\u8FD8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BorrowDao bdao = new BorrowDao();
				Borrow b = new Borrow();
				BookDao bdao_ = new BookDao();
				Book b_ = new Book();
				ReaderDao rdao = new ReaderDao();
				Reader r = new Reader();
				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty())
				{
					b.setRno(Integer.valueOf(textField.getText()));
					b.setBno(Integer.valueOf(textField_1.getText()));
					b_.setBno(Integer.valueOf(textField_1.getText()));
					b_.setBstate("在馆");
					if(rdao.findByFullRno(Integer.valueOf(textField.getText())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此读者不存在");
					}
					else if(bdao_.findByFullBno(Integer.valueOf(textField_1.getText())) == null)
					{
						JOptionPane.showMessageDialog(getContentPane(), "此图书不存在");
					}
					else if(bdao.doReturnInsert(b) && bdao_.doUpdateState(b_))
					{
						JOptionPane.showMessageDialog(getContentPane(), "归还信息更新成功");
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), "归还信息更新失败");
					}	
				}
				else
				{
						JOptionPane.showMessageDialog(getContentPane(), "读者编号、图书编号均不能为空");
				}
			}
		});
		btnNewButton_1.setBounds(285, 247, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\FindFramePicture.png"));
		lblNewLabel_2.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_2);
	}
}
