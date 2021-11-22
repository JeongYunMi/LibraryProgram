/*
 * class占쏙옙: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

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

class MemberManagementGUI {

	private JFrame frame;
	private JTextField SearchtextField;

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
		frame = new JFrame();									//기본 프레임
		frame.setBounds(100, 100, 880, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//GUI 창이 꺼질 경우 알아서 프로그램 종료
		frame.getContentPane().setLayout(null);
		 
		String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};  	//회원 관리를 위한 JTable의 칼럼 명
		String MemberInfo[][] = {										 	//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
				{"2019XXXXX", "김재훈", "5", "대출 가능"},
				{"201910063", "정윤미", "3", "연체"}
		};
		
		JPanel MemberManagementPane = new JPanel();
		MemberManagementPane.setBounds(0, 40, 864, 461);
		frame.getContentPane().add(MemberManagementPane);
		MemberManagementPane.setLayout(null);								//회원관리 메뉴 탭이 선택될 경우 활성화될 panel
		
		JTable MemberInfoTable = new JTable(MemberInfo, header);
		JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
		MemberTableScroll.setBounds(0, 92, 864, 380);
		MemberManagementPane.add(MemberTableScroll);						//회원정보 출력을 위한 JTable
		
		JLabel MenuLabelMM = new JLabel("회원관리");
		MenuLabelMM.setBounds(0, 10, 99, 34);
		MenuLabelMM.setFont(new Font("Dialog", Font.BOLD, 24));
		MemberManagementPane.add(MenuLabelMM);								//명시적으로 표현될 메뉴 이름
		
		JPanel MemberManagementButtonG = new JPanel();
		MemberManagementButtonG.setBounds(0, 49, 864, 34);
		MemberManagementPane.add(MemberManagementButtonG);
		MemberManagementButtonG.setLayout(null);							//회원 관리를 위한 버튼을 모아둘 탭
		
		JLabel MemberSearchLabel = new JLabel("회원 검색");						
		MemberSearchLabel.setBounds(572, 2, 78, 32);
		MemberSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MemberManagementButtonG.add(MemberSearchLabel);						//회원 검색 라벨
		
		SearchtextField = new JTextField();
		SearchtextField.setBounds(644, 2, 128, 32);
		SearchtextField.setColumns(10);
		MemberManagementButtonG.add(SearchtextField);						//회원 검색을 위한 텍스트필드
		
		JButton SearchButton = new JButton("검색");
		SearchButton.setBounds(784, 3, 68, 31);
		MemberManagementButtonG.add(SearchButton);							//검색 확인 버튼
		
		JButton MemberAdd = new JButton("회원 추가");
		MemberAdd.setBounds(161, -4, 85, 38);
		MemberManagementButtonG.add(MemberAdd);								//회원 추가 버튼
		
		JButton MemberDetail = new JButton("선택한 회원정보 조회");
		MemberDetail.setBounds(0, 0, 149, 34);
		MemberManagementButtonG.add(MemberDetail);							//Table에서 선택된 회원에 대한 상세정보 조회 버튼
		
		JButton MemberDel = new JButton("회원 삭제");
		MemberDel.setBounds(258, -1, 85, 35);
		MemberManagementButtonG.add(MemberDel);								//회원 삭제 버튼
	}

}
