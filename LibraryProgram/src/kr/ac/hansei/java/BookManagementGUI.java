package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * 도서 관리 페이지를 담은 class이다.
 */

class BookManagementGUI extends JPanel {
	private JTextField textField;
	
	public BookManagementGUI() {
		
		setLayout(new BorderLayout());
		
		String header[] = {"책 번호", "책 이름", "저자", "출판일", "위치", "출판사", "대여일","반납 예정일", "대여 유무"};     //책 관리를 위한 JTable의 칼럼 명
        String BookInfo[][] = {                                  
              {"1", "자바를 자바라", "김재훈", "1998-11-21", "L-21", "자바프로그래밍", "2021-11-21", "2021-11-28", "대여 중"},//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
              {"2", "자바의 정석", "정윤미", "2000-08-21", "L-22", "자바프로그래밍", "", "", "대여 가능"}
        };
        
        
        JPanel BookManagementButtonG = new JPanel();
        BookManagementButtonG.setBounds(0, 160, 1584, 801);
        add(BookManagementButtonG, BorderLayout.NORTH);
        
        BookManagementButtonG.setLayout(new FlowLayout());
        
        JLabel BookManagement1 = new JLabel("도서관리");
        BookManagement1.setFont(new Font("굴림", Font.PLAIN, 30));
        BookManagement1.setHorizontalAlignment(SwingConstants.CENTER);
        BookManagementButtonG.add(BookManagement1);
           
        JButton MoreInfo = new JButton("선택한 책 정보 조회");
        MoreInfo.setFont(new Font("굴림", Font.PLAIN, 20));
        BookManagementButtonG.add(MoreInfo);
           
              
        JButton BookAddbtn = new JButton("책 추가");
        BookAddbtn.setFont(new Font("굴림", Font.PLAIN, 20));
        BookManagementButtonG.add(BookAddbtn);
              
        JButton BookDelete = new JButton("책 삭제");
        BookDelete.setFont(new Font("굴림", Font.PLAIN, 20));
        BookManagementButtonG.add(BookDelete);
              
        JLabel BookSearch = new JLabel("책 검색");
        BookSearch.setFont(new Font("굴림", Font.BOLD, 20));
        BookManagementButtonG.add(BookSearch);
        
        JButton BookSearchbtn = new JButton("책 검색");
        BookSearchbtn.setFont(new Font("굴림", Font.PLAIN, 20));
        BookManagementButtonG.add(BookSearchbtn);
        
        textField = new JTextField();
        textField.setBounds(1176, 55, 229, 35);
        BookManagementButtonG.add(textField);
        textField.setColumns(10);
        
        JTable BookInfoTable = new JTable(BookInfo, header);   //JTable 생성
        JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
        BookTableScroll.setBounds(37, 106, 1509, 685);
        add(BookTableScroll, BorderLayout.CENTER);   
        
        
	}
	
}