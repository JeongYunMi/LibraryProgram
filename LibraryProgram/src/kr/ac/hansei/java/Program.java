/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/*
 * returnbook 클래스는 반납창을 나타낸다
 */

class ReturnBook extends JFrame {

public ReturnBook() {

	setBounds(100, 100, 880, 540);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//GUI 창이 꺼질 경우 알아서 프로그램 종료
	getContentPane().setLayout(null);
	
	JPanel RentalBookPane = new JPanel(); 
	RentalBookPane.setBounds(0, 40, 864, 461);
	getContentPane().add(RentalBookPane);
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
	
	JButton btnNewButton = new JButton("반납");
	btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
	btnNewButton.setBounds(737, 191, 103, 41);
	BookInfoContentPane.add(btnNewButton);
	}
}

/*
 * AboutBook 클래스에 책의 정보가 더 담겨있다
 */

class AboutBook extends JFrame{
		
	public AboutBook() {
		setBounds(0,0,1600,1000);// 기본 프레임 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		String header[] = {"등록 번호","책 이름", "저자","출판일", "위치", "출판사","대여일","반납예정일","반납여부"}; //책 정보 탭
		String BookInfo[][] = { // 책 정보에 들어갈 예시
				{"1","자바gui","김재훈","1998-11-21","L-21","한세출판","2021-11-10","2021-11-21","대여중"	},
				{"2","자바의 정석","정윤미","2009-11-01","L-20","한세출판","","","대여 가능"	},			
		};
		
		JLabel lblNewLabel = new JLabel("책 정보"); // 책 정보 label 생성
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 1600, 100);
		
		getContentPane().add(lblNewLabel); //패널 생성
		JPanel BookManagementPane = new JPanel();
		BookManagementPane.setBounds(0,100,1600,900);
		getContentPane().add(BookManagementPane);
		BookManagementPane.setLayout(null);
		
		JTable BookInfoTable = new JTable(BookInfo, header); // 테이블 생성
		JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
		BookTableScroll.setBounds(0, 0, 1600, 900);
		BookManagementPane.add(BookTableScroll);	
		
	}
}
/*
 * Book클래스에는 책시리얼넘버, 책이름, 저자,출판일, 위치, 출판사, 대여일, 반납예정일, 대여유무가 담겨있습니다
 */

class Book {
	
	public static Vector<Book> BookVec = new Vector<Book>(30); //Vector 선언
	private String bookNum; // 책시리얼넘버
	private String bookName; // 책이름
	private String bookWriter; //저자
	private String bookBorn; // 출판일
	private String bookLocation; // 위치
	private String bookPublisher; //출판사
	private String loanDate; //대여일
	private String loanDdate; //반납예정일
	private String loanState; //대여유무
	
	public Book(String bookNum, String bookName, String bookWriter, String bookBorn, String bookLocation,
			String bookPublisher, String loanDate, String loanDdate, String loanState) { 
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookBorn = bookBorn;
		this.bookLocation = bookLocation;
		this.bookPublisher = bookPublisher;
		this.loanDate = loanDate;
		this.loanDdate = loanDdate;
		this.loanState = loanState;
	}
	
	public Book() {	} //생성자
	
	public String getBookName() { //책시리얼넘버, 책이름, 저자, 출판일, 위치, 출판사는 변하지 않는 내용이니 get 메소드 사용
		return this.bookName;
	}
	
	public String getbookNum() { 
		return this.bookNum;
	}
	
	public String getBookWriter() {
		return this.bookWriter;
	}

	public String getBookBorn() {
		return this.bookBorn;
	}
	
	public String getBookLocation() {
		return this.bookLocation;
	}

	public String getBookPublisher() {
		return this.bookPublisher;
	}

	public String getLoanDate() { //대여일, 대여 반납일, 대여유무는 변하기 때문에 set메소드를 써준다.
		return this.loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getLoanDdate() {
		return loanDdate;
	}
	
	public void setLoanDdate(String loanDdate) {
		this.loanDdate = loanDdate;
	}

	public String getLoanState() {
		return loanState;
	}
	
	public void setLoanState(String loanState) {
		this.loanState = loanState;
	}
}

/*
 * 도서 관리 페이지를 담은 class이다.
 */

class BookManagementGui extends JFrame {
	
	private JFrame frame;
	private JTextField textField;
	
	public BookManagementGui() {
		
		setBounds(0, 0, 1600, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
		String header[] = {"책 번호", "책 이름", "저자", "출판일", "위치", "출판사", "대여일","반납 예정일", "대여 유무"};  	//책 관리를 위한 JTable의 칼럼 명
		String BookInfo[][] = {										 	
				{"1", "자바를 자바라", "김재훈", "1998-11-21", "L-21", "자바프로그래밍", "2021-11-21", "2021-11-28", "대여 중"},//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
				{"2", "자바의 정석", "정윤미", "2000-08-21", "L-22", "자바프로그래밍", "", "", "대여 가능"}
		};
		
		JPanel panel = new JPanel();	//패널 생성
		panel.setBounds(0, 0, 1600, 1200);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel BookManagement = new JLabel("도서관리");
		BookManagement.setFont(new Font("굴림", Font.PLAIN, 30));
		BookManagement.setHorizontalAlignment(SwingConstants.CENTER);
		BookManagement.setBounds(0, 10, 1600, 110);
		panel.add(BookManagement);
		
		JButton MoreInfo = new JButton("선택한 책 정보 조회");
		MoreInfo.setFont(new Font("굴림", Font.PLAIN, 20));
		MoreInfo.setBounds(0, 100, 300, 50);
		panel.add(MoreInfo);
		MoreInfo.addActionListener(new ActionListener() {	//버튼 클릭시 aboutbook 클래스로 이동
			public void actionPerformed(ActionEvent e) {
				AboutBook aboutbook = new AboutBook();
				aboutbook.setVisible(true);
			}
		});
		
		JButton BookAddbtn = new JButton("책 추가");
		BookAddbtn.setFont(new Font("굴림", Font.PLAIN, 20));
		BookAddbtn.setBounds(320, 100, 150, 50);
		panel.add(BookAddbtn);
		
		JButton BookDelete = new JButton("책 삭제");
		BookDelete.setFont(new Font("굴림", Font.PLAIN, 20));
		BookDelete.setBounds(490, 100, 150, 50);
		panel.add(BookDelete);
		
		JLabel BookSearch = new JLabel("책 검색");
		BookSearch.setFont(new Font("굴림", Font.BOLD, 20));
		BookSearch.setBounds(1100, 100, 100, 50);
		panel.add(BookSearch);
		
		textField = new JTextField();	//검색할 택스트필드 생성
		textField.setBounds(1200, 100, 200, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton BookSearchbtn = new JButton("책 검색");
		BookSearchbtn.setFont(new Font("굴림", Font.PLAIN, 20));
		BookSearchbtn.setBounds(1419, 100, 150, 50);
		panel.add(BookSearchbtn);
		
		JTable BookInfoTable = new JTable(BookInfo, header);	//JTable 생성
		JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
		BookTableScroll.setBounds(0, 200, 1600, 800);
		panel.add(BookTableScroll);	
	}
	
}

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

class MemberManagementGUI extends JFrame{
	
	private JFrame frame;
	private JTextField SearchtextField;
	
	public MemberManagementGUI() {
		String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};	//회원 관리를 위한 JTable의 칼럼 명
		String MemberInfo[][] = { 	//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
				{"2019XXXXX", "김재훈", "5", "대출 가능"},
				{"201910063", "정윤미", "3", "연체"},
	};
		
		JPanel MemberManagementPane = new JPanel();
		MemberManagementPane.setBounds(0, 40, 864, 461);
	    frame.getContentPane().add(MemberManagementPane);
	    MemberManagementPane.setLayout(null);                        //회원관리 메뉴 탭이 선택될 경우 활성화될 panel
	      
	    JTable MemberInfoTable = new JTable(MemberInfo, header);
	    JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
	    MemberTableScroll.setBounds(0, 92, 864, 380);
	    MemberManagementPane.add(MemberTableScroll);                  //회원정보 출력을 위한 JTable
	      
	    JLabel MenuLabelMM = new JLabel("회원관리");
	    MenuLabelMM.setBounds(0, 10, 99, 34);
	    MenuLabelMM.setFont(new Font("Dialog", Font.BOLD, 24));
	    MemberManagementPane.add(MenuLabelMM);                        //명시적으로 표현될 메뉴 이름
	      
	    JPanel MemberManagementButtonG = new JPanel();
	    MemberManagementButtonG.setBounds(0, 49, 864, 34);
	    MemberManagementPane.add(MemberManagementButtonG);
	    MemberManagementButtonG.setLayout(null);                     //회원 관리를 위한 버튼을 모아둘 탭
	      
	    JLabel MemberSearchLabel = new JLabel("회원 검색");                  
	    MemberSearchLabel.setBounds(572, 2, 78, 32);
	    MemberSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    MemberManagementButtonG.add(MemberSearchLabel);                  //회원 검색 라벨
	      
	    SearchtextField = new JTextField();
	    SearchtextField.setBounds(644, 2, 128, 32);
	    SearchtextField.setColumns(10);
	    MemberManagementButtonG.add(SearchtextField);                  //회원 검색을 위한 텍스트필드
	      
	    JButton SearchButton = new JButton("검색");
	    SearchButton.setBounds(784, 3, 68, 31);
	    MemberManagementButtonG.add(SearchButton);                     //검색 확인 버튼
	      
	    JButton MemberAdd = new JButton("회원 추가");
	    MemberAdd.setBounds(161, -4, 85, 38);
	    MemberManagementButtonG.add(MemberAdd);                        //회원 추가 버튼
	      
	    JButton MemberDetail = new JButton("선택한 회원정보 조회");
	    MemberDetail.setBounds(0, 0, 149, 34);
	    MemberManagementButtonG.add(MemberDetail);                     //Table에서 선택된 회원에 대한 상세정보 조회 버튼
	      
	    JButton MemberDel = new JButton("회원 삭제");
	    MemberDel.setBounds(258, -1, 85, 35);
	    MemberManagementButtonG.add(MemberDel);                        //회원 삭제 버튼
	   	
}

class MainMenu extends JFrame{
	
	private JFrame frame;
	
	public MainMenu() {
		
		setBounds(0, 0, 1600, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1600, 1000);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("한세 도서 관리 프로그램");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
		lblNewLabel.setBounds(0, 0, 1600, 200);
		panel.add(lblNewLabel);
		
		JButton MenuTab = new JButton("메뉴 탭");
		MenuTab.setFont(new Font("굴림", Font.PLAIN, 30));
		MenuTab.setBounds(0, 0, 400, 200);
		panel.add(MenuTab);
		
		JButton BookManagement = new JButton("도서 관리");
		BookManagement.setFont(new Font("굴림", Font.PLAIN, 30));
		BookManagement.setBounds(0, 200, 400, 200);
		panel.add(BookManagement);
		BookManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagementGui bookmanagementgui = new BookManagementGui();
				bookmanagementgui.setVisible(true);
			}
		});
		
		JButton UserManagement = new JButton("유저 관리");
		UserManagement.setFont(new Font("굴림", Font.PLAIN, 30));
		UserManagement.setBounds(0, 400, 400, 200);
		panel.add(UserManagement);
		
		JButton ReturnBook = new JButton("반납");
		ReturnBook.setFont(new Font("굴림", Font.PLAIN, 30));
		ReturnBook.setBounds(0, 600, 400, 200);
		panel.add(ReturnBook);
		ReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook returnbook = new ReturnBook();
				returnbook.setVisible(true);
			}
		});
		
		JButton LoanBook = new JButton("대여");
		LoanBook.setFont(new Font("굴림", Font.PLAIN, 30));
		LoanBook.setBounds(0, 800, 400, 200);
		panel.add(LoanBook);	
		
	}
}

public class Program {
   public static void main(String[] args) {
      new MainMenu();
   }
}