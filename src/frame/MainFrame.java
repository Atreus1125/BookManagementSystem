package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainFrame extends JFrame {

	public static String loginname;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("\u7BA1\u7406\u5458\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1000, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnManager = new JMenu("\u7BA1\u7406\u5458\u4FE1\u606F");
		mnManager.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnManager);
		
		JMenuItem mntmFindManager = new JMenuItem("\u7BA1\u7406\u5458\u4FE1\u606F\u67E5\u8BE2");
		mntmFindManager.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnManager.add(mntmFindManager);
		mntmFindManager.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MFindManagerFrame findmanager = new MFindManagerFrame();
					findmanager.setVisible(true);
				}
		});
		
		JMenuItem mntmUpdateManager = new JMenuItem("\u7BA1\u7406\u5458\u4FE1\u606F\u66F4\u65B0");
		mntmUpdateManager.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnManager.add(mntmUpdateManager);
		mntmUpdateManager.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MUpdateManagerFrame updatemanager = new MUpdateManagerFrame();
					updatemanager.setVisible(true);
				}
		});
		
		JMenu mnReader = new JMenu("\u8BFB\u8005\u4FE1\u606F");
		mnReader.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnReader);
		
		JMenuItem mntmFindReader = new JMenuItem("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2");
		mntmFindReader.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnReader.add(mntmFindReader);
		mntmFindReader.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MFindReaderFrame findreader = new MFindReaderFrame();
						findreader.setVisible(true);
					}
		});
		
		JMenuItem mntmUpdateReader = new JMenuItem("\u8BFB\u8005\u4FE1\u606F\u66F4\u65B0");
		mntmUpdateReader.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnReader.add(mntmUpdateReader);
		mntmUpdateReader.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MUpdateReaderFrame updatereader = new MUpdateReaderFrame();
						updatereader.setVisible(true);
					}
		});
		
		JMenu mnBook = new JMenu("\u56FE\u4E66\u4FE1\u606F");
		mnBook.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnBook);
		
		JMenuItem mntmFindBook = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2");
		mntmFindBook.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnBook.add(mntmFindBook);
		mntmFindBook.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MFindBookFrame findbook = new MFindBookFrame();
						findbook.setVisible(true);
					}
		});
		
		JMenuItem mntmUpdateBook = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u66F4\u65B0");
		mntmUpdateBook.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnBook.add(mntmUpdateBook);
		mntmUpdateBook.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MUpdateBookFrame updatebook = new MUpdateBookFrame();
						updatebook.setVisible(true);
					}
		});
		
		JMenu mnBorrow = new JMenu("\u501F\u9605\u4FE1\u606F");
		mnBorrow.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnBorrow);
		
		JMenuItem mntmFindBorrow = new JMenuItem("\u501F\u9605\u4FE1\u606F\u67E5\u8BE2");
		mntmFindBorrow.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnBorrow.add(mntmFindBorrow);
		mntmFindBorrow.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MFindBorrowFrame findborrow = new MFindBorrowFrame();
						findborrow.setVisible(true);
					}
		});
		
		JMenuItem mntmUpdateBorrow = new JMenuItem("\u501F\u9605\u4FE1\u606F\u66F4\u65B0");
		mntmUpdateBorrow.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnBorrow.add(mntmUpdateBorrow);
		
		JMenuItem mntmCountBorrow = new JMenuItem("\u501F\u9605\u4FE1\u606F\u7EDF\u8BA1");
		mntmCountBorrow.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnBorrow.add(mntmCountBorrow);
		mntmCountBorrow.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MCountBorrowFrame countborrow = new MCountBorrowFrame();
						countborrow.setVisible(true);
					}
		});
		
		JMenu mnNewMenu = new JMenu("          ");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u5BCC\u8D35\u5FC5\u4ECE\u52E4\u82E6\u5F97\uFF0C\u7537\u513F\u987B\u8BFB\u4E94\u8F66\u4E66\u3002\u2014\u2014\u5510\u00B7\u675C\u752B\u300A\u9898\u6CCA\u5B66\u58EB\u8305\u5C4B\u300B");
		mnNewMenu_1.setForeground(new Color(0, 51, 204));
		mnNewMenu_1.setFont(new Font("»ªÎÄÐÂÎº", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		mntmUpdateBorrow.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MUpdateBorrowFrame updateborrow = new MUpdateBorrowFrame();
						updateborrow.setVisible(true);
					}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\MainFramePicture.png"));
		lblNewLabel.setBounds(0, 0, 982, 527);
		contentPane.add(lblNewLabel);
	}
}
