/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
	
	private JPanel contentPane;
	private JTextField SearchBar;
	
	public BookManagementGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 1000); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel BookManagement = new JPanel(); // 1600x1000패널 생성
		BookManagement.setBounds(0, 0, 1600, 1000);
		contentPane.add(BookManagement);
		BookManagement.setLayout(null);
		
		SearchBar = new JTextField(); //검색을 할 수 있게 text창 생성
		SearchBar.setBounds(1100, 100, 300, 50);
		BookManagement.add(SearchBar);
		SearchBar.setColumns(10);
		
		JButton SearchBtn = new JButton("Search"); //Search 검색 버튼 생성
		SearchBtn.setBounds(1400, 100, 100, 50);
		BookManagement.add(SearchBtn);
		
		JLabel lblNewLabel = new JLabel("도서 관리"); //도서 관리 text 출력
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(300, 0, 1300, 150);
		BookManagement.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("책 이름"); // 책 이름 text 출력
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(400, 150, 150, 50);
		BookManagement.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("등록 번호"); // 등록 번호 text 출력
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(600, 150, 150, 50);
		BookManagement.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("대출 상태"); // 대출 상태 text 출력
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(1000, 150, 150, 50);
		BookManagement.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("저자"); // 저자 text 출력
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(800, 150, 150, 50);
		BookManagement.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("더보기"); // 더보기 button 생성
		btnNewButton_1.setBounds(1200, 150, 150, 50);
		BookManagement.add(btnNewButton_1);
		
		// 메인 메뉴
		JPanel MenuBar = new JPanel();
		MenuBar.setBounds(0, 0, 300, 1000);
		BookManagement.add(MenuBar);
		MenuBar.setLayout(null);
		
		JButton MenuTab = new JButton("메뉴 탭"); // 메뉴 탭 버튼 생성
		MenuTab.setFont(new Font("굴림", Font.PLAIN, 30));
		MenuTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		MenuTab.setBounds(0, 0, 300, 150);
		MenuBar.add(MenuTab);
		
		JButton BookManage = new JButton("도서 관리");
		BookManage.setFont(new Font("굴림", Font.PLAIN, 30));
		BookManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BookManage.setBounds(0, 150, 300, 150);
		MenuBar.add(BookManage);
		
		JButton UserManage = new JButton("유저 관리");
		UserManage.setFont(new Font("굴림", Font.PLAIN, 30));
		UserManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UserManage.setBounds(0, 300, 300, 150);
		MenuBar.add(UserManage);
		
		JButton ReturnBook = new JButton("반납");
		ReturnBook.setFont(new Font("굴림", Font.PLAIN, 30));
		ReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ReturnBook.setBounds(0, 450, 300, 150);
		MenuBar.add(ReturnBook);
		
		JButton RentalBook = new JButton("대여");
		RentalBook.setFont(new Font("굴림", Font.PLAIN, 30));
		RentalBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RentalBook.setBounds(0, 600, 300, 150);
		MenuBar.add(RentalBook);
	}
	
}

public class Program {
	public static void main(String[] args) {
		
		JFrame GuiFrame = new JFrame(); //JFrame 객체 생성(도서관리 프로그램의 가장 큰 틀)
		
		JPanel TopMenuName = new JPanel();
		
		JLabel MenuName = new JLabel("도서 관리");
		TopMenuName.add(MenuName, BorderLayout.NORTH);
		
		//임시 페이지 이동이 가능한 마우스 이벤트
		JButton MovePage = new JButton("페이지 이동"); 
		MovePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagementGui bookManagementGui = new BookManagementGui();
				bookManagementGui.setVisible(true);
			}
		});
		
		GuiFrame.setLayout(new BorderLayout());
		GuiFrame.add(TopMenuName);
		GuiFrame.add(MovePage);
		
		GuiFrame.setTitle("LibraryProgram"); //Title 이름 정하기
		GuiFrame.setSize(1600, 1000); // 프레임 크기
		GuiFrame.setVisible(true); //프레임 출력
	}
}
