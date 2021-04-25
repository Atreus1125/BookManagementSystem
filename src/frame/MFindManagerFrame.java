package frame;

import java.awt.BorderLayout;
import java.awt.Component;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.ImageIcon;

public class MFindManagerFrame extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFindManagerFrame frame = new MFindManagerFrame();
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
	public MFindManagerFrame() {
		setTitle("\u7BA1\u7406\u5458\u4FE1\u606F\u67E5\u8BE2\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane.setBounds(0, 0, 482, 199);
		contentPane.add(scrollPane);	
		ManagerDao mdao = new ManagerDao();
		Vector columnnames = mdao.findColumnNames();
		JTable table = new JTable(null, columnnames);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u7F16\u53F7");
		lblNewLabel.setBounds(14, 235, 90, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 232, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector rowData = new Vector();
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "管理员编号不能为空", "提示", JOptionPane.ERROR_MESSAGE);
				}
				else {
					rowData = mdao.findByMno(Integer.valueOf(textField.getText().trim()));
					JTable table = new JTable(rowData, columnnames);
					scrollPane.setViewportView(table);
				}
			}
		});
		btnNewButton.setBounds(192, 231, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u5168\u90E8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector rowData = new Vector();
				rowData = mdao.findAll();
				JTable table = new JTable(rowData, columnnames);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(338, 231, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\FindFramePicture.png"));
		lblNewLabel_1.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_1);
	}
}
