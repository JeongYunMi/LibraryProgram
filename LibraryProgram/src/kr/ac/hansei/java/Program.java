/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


class MainMenu extends JFrame{
	
	private static JFrame frame;
	private static JTextField SearchtextField;
	private static JTextField textField;
	
	static void BookManagementGui() {
		
		String header[] = {"책 번호", "책 이름", "저자", "출판일", "위치", "출판사", "대여일","반납 예정일", "대여 유무"};     //책 관리를 위한 JTable의 칼럼 명
        String BookInfo[][] = {                                  
              {"1", "자바를 자바라", "김재훈", "1998-11-21", "L-21", "자바프로그래밍", "2021-11-21", "2021-11-28", "대여 중"},//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
              {"2", "자바의 정석", "정윤미", "2000-08-21", "L-22", "자바프로그래밍", "", "", "대여 가능"}
        };
        
        
        JPanel BookManagementPanel = new JPanel();
        BookManagementPanel.setBounds(0, 160, 1584, 801);
        frame.add(BookManagementPanel);
        BookManagementPanel.setLayout(null);
        
        JLabel BookManagement1 = new JLabel("도서관리");
        BookManagement1.setFont(new Font("굴림", Font.PLAIN, 30));
        BookManagement1.setHorizontalAlignment(SwingConstants.CENTER);
        BookManagement1.setBounds(37, 35, 120, 35);
        BookManagementPanel.add(BookManagement1);
           
        JButton MoreInfo = new JButton("선택한 책 정보 조회");
        MoreInfo.setFont(new Font("굴림", Font.PLAIN, 20));
        MoreInfo.setBounds(213, 39, 213, 33);
        BookManagementPanel.add(MoreInfo);
           
              
        JButton BookAddbtn = new JButton("책 추가");
        BookAddbtn.setFont(new Font("굴림", Font.PLAIN, 20));
        BookAddbtn.setBounds(442, 39, 99, 33);
        BookManagementPanel.add(BookAddbtn);
              
        JButton BookDelete = new JButton("책 삭제");
        BookDelete.setFont(new Font("굴림", Font.PLAIN, 20));
        BookDelete.setBounds(568, 39, 99, 33);
        BookManagementPanel.add(BookDelete);
              
        JLabel BookSearch = new JLabel("책 검색");
        BookSearch.setFont(new Font("굴림", Font.BOLD, 20));
        BookSearch.setBounds(1067, 58, 91, 28);
        BookManagementPanel.add(BookSearch);
        
        JButton BookSearchbtn = new JButton("책 검색");
        BookSearchbtn.setFont(new Font("굴림", Font.PLAIN, 20));
        BookSearchbtn.setBounds(1430, 54, 105, 36);
        BookManagementPanel.add(BookSearchbtn);
        
        JTable BookInfoTable = new JTable(BookInfo, header);   //JTable 생성
        JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
        BookTableScroll.setBounds(37, 106, 1509, 685);
        BookManagementPanel.add(BookTableScroll);   
        
        textField = new JTextField();
        textField.setBounds(1176, 55, 229, 35);
        BookManagementPanel.add(textField);
        textField.setColumns(10);
	}
	
	
	static void MemberManagementGUI(){
    	
		JPanel MemberManagementPane = new JPanel();
        MemberManagementPane.setBounds(0, 171, 1584, 777);
        try {
			frame.add(MemberManagementPane);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MemberManagementPane.setLayout(null);
        
        String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};  	//회원 관리를 위한 JTable의 칼럼 명
		String MemberInfo[][] = {										 	//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
				{"2019XXXXX", "김재훈", "5", "대출 가능"},
				{"201910063", "정윤미", "3", "연체"}
		};
        
        JTable MemberInfoTable = new JTable(MemberInfo, header);   //JTable 생성
        
        JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
        MemberTableScroll.setBounds(0, 92, 1572, 685);
        MemberManagementPane.add(MemberTableScroll);
       
        
        JLabel MenuLabelMM = new JLabel("회원관리");
        MenuLabelMM.setFont(new Font("Dialog", Font.BOLD, 24));
        MenuLabelMM.setBounds(0, 10, 99, 34);
        MemberManagementPane.add(MenuLabelMM);
        
        JPanel MemberManagementButtonG = new JPanel();
        MemberManagementButtonG.setLayout(null);
        MemberManagementButtonG.setBounds(0, 49, 1572, 34);
        MemberManagementPane.add(MemberManagementButtonG);
        MemberManagementButtonG.setVisible(true);
        
        JLabel MemberSearchLabel = new JLabel("회원 검색");
        MemberSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        MemberSearchLabel.setBounds(1292, 2, 78, 32);
        MemberManagementButtonG.add(MemberSearchLabel);
        
        SearchtextField = new JTextField();
        SearchtextField.setColumns(10);
        SearchtextField.setBounds(1364, 2, 128, 32);
        MemberManagementButtonG.add(SearchtextField);
        
        JButton SearchButton = new JButton("검색");
        SearchButton.setBounds(1504, 3, 68, 31);
        MemberManagementButtonG.add(SearchButton);
        
        JButton MemberAdd = new JButton("회원 추가");
        MemberAdd.setBounds(161, -4, 85, 38);
        MemberManagementButtonG.add(MemberAdd);
        
        JButton MemberDetail = new JButton("선택한 회원정보 조회");
        MemberDetail.setBounds(0, 0, 149, 34);
        MemberManagementButtonG.add(MemberDetail);
        
        JButton MemberDel = new JButton("회원 삭제");
        MemberDel.setBounds(258, -1, 85, 35);
        MemberManagementButtonG.add(MemberDel);
  }
	
	void LoneBook() {
		
		JPanel RentalBookPane = new JPanel();
	    RentalBookPane.setBounds(0, 191, 1588, 760);
	    frame.add(RentalBookPane);
	    RentalBookPane.setLayout(null);
	    
	    JPanel MemberInfoPane = new JPanel();
	    MemberInfoPane.setLayout(null);
	    MemberInfoPane.setBounds(0, 0, 1576, 320);
	    RentalBookPane.add(MemberInfoPane);
	    
	    JLabel MemberInfoLabel = new JLabel("회원 정보");
	    MemberInfoLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    MemberInfoLabel.setBounds(12, 0, 97, 26);
	    MemberInfoPane.add(MemberInfoLabel);
	    
	    JPanel MemberInfoContentPane = new JPanel();
	    MemberInfoContentPane.setBounds(10, 27, 1537, 283);
	    MemberInfoPane.add(MemberInfoContentPane);
	    
	    JPanel BookInfoPane = new JPanel();
	    BookInfoPane.setLayout(null);
	    BookInfoPane.setBounds(0, 319, 1588, 441);
	    RentalBookPane.add(BookInfoPane);
	    
	    JLabel lblNewLabel1 = new JLabel("자료 정보");
	    lblNewLabel1.setFont(new Font("돋움", Font.PLAIN, 22));
	    lblNewLabel1.setBounds(12, 10, 95, 34);
	    BookInfoPane.add(lblNewLabel1);
	    
	    JPanel BookInfoContentPane = new JPanel();
	    BookInfoContentPane.setLayout(null);
	    BookInfoContentPane.setBounds(12, 38, 1539, 379);
	    BookInfoPane.add(BookInfoContentPane);
	    
	    JButton btnNewButton = new JButton("대출");
	    btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
	    btnNewButton.setBounds(1436, 338, 103, 41);
	    BookInfoContentPane.add(btnNewButton);
		}
	
	public MainMenu() {
		
		setBounds(0, 0, 1600, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		frame = new JFrame();
		frame.setBounds(0, 0, 1600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
     
        JPanel menuTabPanel = new JPanel();
        menuTabPanel.setBounds(0, 10, 1600, 1000);
        frame.getContentPane().add(menuTabPanel);
        menuTabPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("   \uD55C\uC138 \uB3C4\uC11C \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
        lblNewLabel.setBounds(0, 0, 524, 160);
        menuTabPanel.add(lblNewLabel);
        
        JButton LoneBook = new JButton("\uB300\uCD9C");
        LoneBook.setFont(new Font("굴림", Font.PLAIN, 30));
        LoneBook.setBounds(643, 0, 240, 160);
        menuTabPanel.add(LoneBook);
        LoneBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoneBook();
			}
		});
        
        
        JButton BookManagement = new JButton("도서 관리");
        BookManagement.setFont(new Font("굴림", Font.PLAIN, 30));
        BookManagement.setBounds(1120, 0, 240, 160);
        menuTabPanel.add(BookManagement);
        BookManagement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookManagementGui();

			}
		});
       
        
        JButton UserManagement = new JButton("유저 관리");
        UserManagement.setFont(new Font("굴림", Font.PLAIN, 30));
        UserManagement.setBounds(1360, 0, 240, 160);
        menuTabPanel.add(UserManagement);
        UserManagement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberManagementGUI();	
			}
		});
        
        
        JButton ReturnBook = new JButton("반납");
        ReturnBook.setFont(new Font("굴림", Font.PLAIN, 30));
        ReturnBook.setBounds(881, 0, 240, 160);
        menuTabPanel.add(ReturnBook);
     
        menuTabPanel.setBounds(0, 10, 1600, 1000);
        menuTabPanel.setLayout(null);	
		
	}
}

public class Program {
   public static void main(String[] args) {
      new MainGUI();
   }
}