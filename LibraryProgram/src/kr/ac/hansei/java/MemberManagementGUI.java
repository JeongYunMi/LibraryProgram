package kr.ac.hansei.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;

/*회원정보를 담는 클래스입니다.*/
class Member{
	private int memberNum;   		//회원 고유번호
	private String memberName;  	//회원 이름
	private int rentalBook;    		//빌린 권 수
	private int totalRentalBook;   	//전체 대여가능 권수
	private String memberState;		//회원 상태
	private String rentalBookName = "";  //빌린 책 이름
	
	public Member(int memberNum, String memberName, int rentalBook, int totalRentalBook, String memberState) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.rentalBook = rentalBook;
		this.totalRentalBook = totalRentalBook;
		this.memberState = memberState;
	}
	
	public int getMemberNum() {
		return this.memberNum;
	}
	
	public String getMemberName() {
		return this.memberName;
	}
	
	public int getRentalBook() {
		return this.rentalBook;
	}
	
	public int getTotalRentalBook() {
		return this.totalRentalBook;
	}
	
	public String getMemberState() {
		return this.memberState;
	}
	
	public void setRentalBook(int rentalBook) {
		this.rentalBook = rentalBook;
	}
	
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}

	public String getRentalBookName() {
		return rentalBookName;
	}

	public void setRentalBookName(String rentalBookName) {
		this.rentalBookName = rentalBookName;
	}
}

public class MemberManagementGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagementGUI window = new MemberManagementGUI();
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
	public MemberManagementGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};
		String MemberInfo[][] = {
				{"2019XXXXX", "김재훈", "5", "대출 가능"},
				{"201910063", "정윤미", "3", "연체"}
		};
		
		JPanel MemberManagementPane = new JPanel();
		MemberManagementPane.setBounds(0, 40, 864, 461);
		frame.getContentPane().add(MemberManagementPane);
		MemberManagementPane.setLayout(null);
		
		JTable MemberInfoTable = new JTable(MemberInfo, header);
		JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
		MemberTableScroll.setBounds(0, 92, 864, 380);
		MemberManagementPane.add(MemberTableScroll);
		
		JLabel lblNewLabel = new JLabel("회원관리");
		lblNewLabel.setBounds(0, 10, 99, 34);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		MemberManagementPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 864, 34);
		MemberManagementPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("회원 검색");
		lblNewLabel_1.setBounds(572, 2, 78, 32);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(644, 2, 128, 32);
		textField.setColumns(10);
		panel_1.add(textField);
		
		JButton btnNewButton_3 = new JButton("검색");
		btnNewButton_3.setBounds(784, 3, 68, 31);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("회원 추가");
		btnNewButton_1.setBounds(161, -4, 85, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("선택한 회원정보 조회");
		btnNewButton.setBounds(0, 0, 149, 34);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("회원 삭제");
		btnNewButton_2.setBounds(258, -1, 85, 35);
		panel_1.add(btnNewButton_2);
		
		
	}

}
