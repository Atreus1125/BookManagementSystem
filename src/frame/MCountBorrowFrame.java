package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import JavaDao.BookDao;
import JavaDao.BorrowDao;
import JavaDao.ReaderDao;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MCountBorrowFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MCountBorrowFrame frame = new MCountBorrowFrame();
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
	public MCountBorrowFrame() {
		setTitle("\u501F\u9605\u4FE1\u606F\u7EDF\u8BA1\u754C\u9762");
		setBounds(650, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ReaderDao rdao = new ReaderDao();
		BookDao bdao = new BookDao();
		BorrowDao bdao_ = new BorrowDao();
		
		String str = null;
		
		str = "��̨���ݿ��й��洢��" + rdao.findTotalNumber() + "λ���ߵĸ�����Ϣ"; 
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setBounds(60, 45, 365, 18);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		str = "ͬʱ�洢��" + bdao.findTotalNumber() + "��ͼ��������Ϣ"; 
		JLabel lblNewLabel_1 = new JLabel(str);
		lblNewLabel_1.setBounds(60, 105, 321, 18);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1);
		
		str = "�Լ�" + bdao_.findTotalNumber() + "���йض�����ͼ��Ľ�����Ϣ"; 
		JLabel lblNewLabel_2 = new JLabel(str);
		lblNewLabel_2.setBounds(60, 165, 321, 18);
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u611F\u8C22\u60A8\u5BF9\u672C\u7CFB\u7EDF\u7684\u652F\u6301\uFF01");
		lblNewLabel_3.setBounds(60, 225, 321, 18);
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\CountBorrowFramePicture.png"));
		lblNewLabel_4.setBounds(0, 0, 482, 303);
		contentPane.add(lblNewLabel_4);
	}
}
