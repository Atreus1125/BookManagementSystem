package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import JavaDao.BorrowDao;
import JavaDao.ReaderDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.ImageIcon;

public class MFindBorrowFrame extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	private JTextField textField_1;
	private final JLabel lblNewLabel_2 = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFindBorrowFrame frame = new MFindBorrowFrame();
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
	public MFindBorrowFrame() {
		setTitle("\u501F\u9605\u4FE1\u606F\u67E5\u8BE2\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 0, 482, 199);
		contentPane.add(scrollPane);
		BorrowDao bdao = new BorrowDao();
		Vector columnnames = bdao.findColumnNames();
		JTable table = new JTable(null, columnnames);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		lblNewLabel.setBounds(10, 217, 90, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		lblNewLabel_1.setBounds(10, 251, 90, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(92, 214, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 248, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Vector rowData = new Vector();
				if(textField.getText().isEmpty() && textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "读者编号与图书编号不能同时为空", "提示", JOptionPane.ERROR_MESSAGE);
				}
				else if(!textField.getText().isEmpty()){
					rowData = bdao.findByRno(Integer.valueOf(textField.getText().trim()));
					JTable table = new JTable(rowData, columnnames);
					scrollPane.setViewportView(table);
				}
				else {
					rowData = bdao.findByBno(Integer.valueOf(textField_1.getText().trim()));
					JTable table = new JTable(rowData, columnnames);
					scrollPane.setViewportView(table);
				}
			}
		});
		btnNewButton.setBounds(192, 231, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Vector rowData = new Vector();
				rowData = bdao.findAll();
				JTable table = new JTable(rowData, columnnames);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(338, 231, 113, 27);
		contentPane.add(btnNewButton_1);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\FindFramePicture.png"));
		lblNewLabel_2.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_2);
	}
}
