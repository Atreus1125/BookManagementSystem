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
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;

public class MainFrameReader extends JFrame {

	public static String loginname;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameReader frame = new MainFrameReader();
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
	public MainFrameReader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u8BFB\u8005\u4E3B\u754C\u9762");
		setBounds(450, 200, 1000, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnReader = new JMenu("\u8BFB\u8005\u4FE1\u606F");
		mnReader.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnReader);
		
		JMenuItem mntmUpdateReader = new JMenuItem("\u8BFB\u8005\u4FE1\u606F\u66F4\u65B0");
		mntmUpdateReader.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnReader.add(mntmUpdateReader);
		mntmUpdateReader.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MUpdateReaderFrame_ updatereader_ = new MUpdateReaderFrame_();
						updatereader_.loginname = loginname;
						updatereader_.setVisible(true);
					}
		});
		
		JMenu mnBook = new JMenu("\u56FE\u4E66\u4FE1\u606F");
		mnBook.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menuBar.add(mnBook);
		
		JMenuItem mntmFindBook = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2");
		mntmFindBook.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnBook.add(mntmFindBook);
		
		JMenu mnNewMenu_1 = new JMenu("          ");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu = new JMenu("\u4E66\u4E2D\u81EA\u6709\u9EC4\u91D1\u5C4B\uFF0C\u4E66\u4E2D\u81EA\u6709\u989C\u5982\u7389\u3002\u2014\u2014\u5B8B\u771F\u5B97\u300A\u52B1\u5FD7\u7BC7\u300B");
		mnNewMenu.setForeground(new Color(0, 51, 204));
		mnNewMenu.setFont(new Font("»ªÎÄÐÂÎº", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		mntmFindBook.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MFindBookFrame findbook = new MFindBookFrame();
						findbook.setVisible(true);
					}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("E:\\Eclipse\\\u5FD8\u8DEF\\BookManagementSystem\\src\\MainFramePicture.png"));
		lblNewLabel.setBounds(0, 0, 982, 527);
		contentPane.add(lblNewLabel);
		//label.;
	}
}
