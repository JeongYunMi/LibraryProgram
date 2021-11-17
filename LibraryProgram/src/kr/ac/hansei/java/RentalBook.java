package kr.ac.hansei.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class RentalBook {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalBook window = new RentalBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RentalBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();									//기본 프레임
		frame.setBounds(100, 100, 880, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//GUI 창이 꺼질 경우 알아서 프로그램 종료
		frame.getContentPane().setLayout(null);
		
		JPanel RentalBookPane = new JPanel();
		RentalBookPane.setBounds(0, 40, 864, 461);
		frame.getContentPane().add(RentalBookPane);
		RentalBookPane.setLayout(null);
		
		JPanel MemberInfoPane = new JPanel();
		MemberInfoPane.setBounds(0, 0, 864, 182);
		RentalBookPane.add(MemberInfoPane);
		MemberInfoPane.setLayout(null);
		
		JLabel MemberInfoLabel = new JLabel("회원 정보");
		MemberInfoLabel.setFont(new Font("돋움", Font.PLAIN, 22));
		MemberInfoLabel.setBounds(12, 0, 97, 26);
		MemberInfoPane.add(MemberInfoLabel);
		
		JPanel MemberInfoContentPane = new JPanel();
		MemberInfoContentPane.setBounds(10, 27, 842, 145);
		MemberInfoPane.add(MemberInfoContentPane);
		
		JPanel BookInfoPane = new JPanel();
		BookInfoPane.setBounds(0, 181, 864, 280);
		RentalBookPane.add(BookInfoPane);
		BookInfoPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("자료 정보");
		lblNewLabel.setFont(new Font("돋움", Font.PLAIN, 22));
		lblNewLabel.setBounds(12, 10, 95, 34);
		BookInfoPane.add(lblNewLabel);
		
		JPanel BookInfoContentPane = new JPanel();
		BookInfoContentPane.setBounds(12, 38, 840, 232);
		BookInfoPane.add(BookInfoContentPane);
		BookInfoContentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("대출");
		btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
		btnNewButton.setBounds(737, 191, 103, 41);
		BookInfoContentPane.add(btnNewButton);
	}
}
