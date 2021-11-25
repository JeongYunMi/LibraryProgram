package kr.ac.hansei.java;

import java.awt.EventQueue;

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

public class ex {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex window = new ex();
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
	public ex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
     
        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 1600, 1000);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("   \uD55C\uC138 \uB3C4\uC11C \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
        lblNewLabel.setBounds(0, 0, 524, 200);
        panel.add(lblNewLabel);
        
        JButton MenuTab = new JButton("\uB300\uCD9C");
        MenuTab.setFont(new Font("굴림", Font.PLAIN, 30));
        MenuTab.setBounds(643, 0, 240, 160);
        panel.add(MenuTab);
        
        JButton BookManagement = new JButton("도서 관리");
        BookManagement.setFont(new Font("굴림", Font.PLAIN, 30));
        BookManagement.setBounds(1120, 0, 240, 160);
        panel.add(BookManagement);
       
        
        JButton UserManagement = new JButton("유저 관리");
        UserManagement.setFont(new Font("굴림", Font.PLAIN, 30));
        UserManagement.setBounds(1360, 0, 240, 160);
        panel.add(UserManagement);
        
        JButton ReturnBook = new JButton("반납");
        ReturnBook.setFont(new Font("굴림", Font.PLAIN, 30));
        ReturnBook.setBounds(881, 0, 240, 160);
        panel.add(ReturnBook);
     
        
        JButton LoanBook = new JButton("대여");
        LoanBook.setFont(new Font("굴림", Font.PLAIN, 30));
        LoanBook.setBounds(0, 800, 400, 200);
        panel.setBounds(0, 10, 1600, 1000);
        panel.setLayout(null);
        
        String header[] = {"책 번호", "책 이름", "저자", "출판일", "위치", "출판사", "대여일","반납 예정일", "대여 유무"};     //책 관리를 위한 JTable의 칼럼 명
        String BookInfo[][] = {                                  
              {"1", "자바를 자바라", "김재훈", "1998-11-21", "L-21", "자바프로그래밍", "2021-11-21", "2021-11-28", "대여 중"},//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
              {"2", "자바의 정석", "정윤미", "2000-08-21", "L-22", "자바프로그래밍", "", "", "대여 가능"}
        };
        
        JTextField textField = new JTextField();   //검색할 택스트필드 생성
        textField.setBounds(1200, 100, 200, 50);
        panel.add(textField);
        textField.setColumns(10);
        
        
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 160, 1594, 801);
        panel.add(panel1);
        
           JLabel BookManagement1 = new JLabel("도서관리");
           BookManagement1.setFont(new Font("굴림", Font.PLAIN, 30));
           BookManagement1.setHorizontalAlignment(SwingConstants.CENTER);
           BookManagement1.setBounds(0, 10, 1600, 110);
           panel1.add(BookManagement1);
           
           JButton MoreInfo = new JButton("선택한 책 정보 조회");
           MoreInfo.setFont(new Font("굴림", Font.PLAIN, 20));
           MoreInfo.setBounds(0, 100, 300, 50);
           panel1.add(MoreInfo);
           
              
              JButton BookAddbtn = new JButton("책 추가");
              BookAddbtn.setFont(new Font("굴림", Font.PLAIN, 20));
              BookAddbtn.setBounds(320, 100, 150, 50);
              panel1.add(BookAddbtn);
              
              JButton BookDelete = new JButton("책 삭제");
              BookDelete.setFont(new Font("굴림", Font.PLAIN, 20));
              BookDelete.setBounds(490, 100, 150, 50);
              panel1.add(BookDelete);
              
              JLabel BookSearch = new JLabel("책 검색");
              BookSearch.setFont(new Font("굴림", Font.BOLD, 20));
              BookSearch.setBounds(1100, 100, 100, 50);
              panel1.add(BookSearch);
        
        JButton BookSearchbtn = new JButton("책 검색");
        BookSearchbtn.setFont(new Font("굴림", Font.PLAIN, 20));
        BookSearchbtn.setBounds(1419, 100, 150, 50);
        panel1.add(BookSearchbtn);
        
        JTable BookInfoTable = new JTable(BookInfo, header);   //JTable 생성
        JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
        BookTableScroll.setBounds(0, 200, 1600, 800);
        panel1.add(BookTableScroll);   
	}

}
