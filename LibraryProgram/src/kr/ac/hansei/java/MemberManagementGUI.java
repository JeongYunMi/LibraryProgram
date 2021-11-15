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
	private JTable table;
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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAD00\uB9AC");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 24));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);   //현재 창 메뉴 이름 - 회원관리
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};
		String MemberInfo[][] = {
				{"2019XXXXX", "김재훈", "5", "대출 가능"},
				{"201910063", "정윤미", "3", "연체"}
		};
		
		JPanel panel_1 = new JPanel();             //버튼(회원검색, 조회, 추가, 삭제 등)을 담을 panel
		panel.add(panel_1);
		//panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("회원 검색");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("검색");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("회원 추가");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("선택한 회원정보 조회");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("회원 삭제");
		panel_1.add(btnNewButton_2);
		//panel.setLayout(new BorderLayout());
		JTable MemberTable= new JTable(MemberInfo, header); // 회원 정보를 담을 JTable 
		JScrollPane MemberTableScroll = new JScrollPane(MemberTable);
		panel.add(MemberTableScroll, BorderLayout.CENTER);
		
		
	}

}
