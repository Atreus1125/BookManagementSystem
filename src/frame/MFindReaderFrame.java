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

import JavaDao.ManagerDao;
import JavaDao.ReaderDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.ImageIcon;

public class MFindReaderFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFindReaderFrame frame = new MFindReaderFrame();
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
	public MFindReaderFrame() {
		setTitle("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 482, 199);
		contentPane.add(scrollPane);	
		ReaderDao rdao = new ReaderDao();
		Vector columnnames = rdao.findColumnNames();
		JTable table = new JTable(null, columnnames);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u7F16\u53F7");
		lblNewLabel.setBounds(10, 217, 90, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 214, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\uFF08\u7F16\u53F7\u4F18\u5148\uFF09");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Vector rowData = new Vector();
				if(textField.getText().isEmpty() && textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "读者编号与专业不能同时为空", "提示", JOptionPane.ERROR_MESSAGE);
				}
				else if(!textField.getText().isEmpty()){
					rowData = rdao.findByRno(Integer.valueOf(textField.getText().trim()));
					JTable table = new JTable(rowData, columnnames);
					scrollPane.setViewportView(table);
				}
				else {
					rowData = rdao.findByRdept(textField_1.getText().trim());
					JTable table = new JTable(rowData, columnnames);
					scrollPane.setViewportView(table);
				}
			}
		});
		btnNewButton.setBounds(192, 231, 163, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector rowData = new Vector();
				rowData = rdao.findAll();
				JTable table = new JTable(rowData, columnnames);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(355, 231, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E13\u4E1A");
		lblNewLabel_1.setBounds(20, 251, 90, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 248, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\FindFramePicture.png"));
		lblNewLabel_2.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_2);
	}
}
