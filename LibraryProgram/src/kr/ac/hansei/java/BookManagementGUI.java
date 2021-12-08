/*
 * class명: BookManagementGUI
 * last update: 21.12.03
 * Contributor : kimjaehoon, jeongyunmi
 * summary : 메뉴 중 책 관리 탭을 클릭했을 때 나오는 GUI를 담은 class
 * 			 책정보 목록을 가지는 JTable과 책관리 관련 버튼(검색, 등록, 삭제 등)을 가지고 있다.
 * */

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
import javax.swing.table.DefaultTableModel;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


class BookManagementGUI extends JPanel {
	private JTextField textField;
	
	public BookManagementGUI() {
		/*
		 * 기본 레이아웃을 BorderLayout으로 설정
		 * */
		setLayout(new BorderLayout());
		
		/*
		 * header: 책 관리를 위한 JTable의 칼럼 명
		 * BookInfo: 들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
		 * */
		String header[] = {"책 번호", "책 이름", "저자", "출판일", "위치", "출판사", "대여일","반납 예정일", "대여 유무"};
        String BookInfo[][] = {                                  
              {"1", "자바를 자바라", "김재훈", "1998-11-21", "L-21", "자바프로그래밍", "2021-11-21", "2021-11-28", "대여 중"},
              {"2", "자바의 정석", "정윤미", "2000-08-21", "L-22", "자바프로그래밍", "", "", "대여 가능"}
        };
        
        /*
         * 책정보 출력을 위한 JTable
         * 화면보다 길어지는 것을 처리하기 위해 JScrollPane으로 처리
         * */
        JTable BookInfoTable = new JTable(BookInfo, header);
        JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
        add(BookTableScroll, BorderLayout.CENTER);   
        
        /*
         * db추가
         */
        
        MongoClient mongoClient = null;        
        DBCursor cursor = null;
        try {
        	mongoClient = new MongoClient("localhost", 27017);
        	DB db = mongoClient.getDB("BookDB");
        	DBCollection coll = db.getCollection("BookInfo");
        	cursor = coll.find();
        	
        	String[] columnNames = {"책번호", "책 이름", "저자", "출판일", "위치"
        			,"출판사", "대여일", "반납 예정일", "대여 유무"
        			};
        	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        	
        	while(cursor.hasNext()) {
        		DBObject obj = cursor.next();
                int BookNumber = (int)obj.get("BookNumber");
                String title = (String)obj.get("title");
                String author = (String)obj.get("author");
                int releasedate = (int)obj.get("releasedate");
                String location = (String)obj.get("location");
                String publisher = (String)obj.get("publisher");
                int loandate = (int)obj.get("loandate");
                int returndate = (int)obj.get("returndate");
                String loanexistence = (String)obj.get("loanexistence");
                model.addRow(new Object[] { BookNumber, title, author, releasedate, 
                		location, publisher, loandate, returndate, loanexistence 
                });
        	}
        	BookInfoTable.setModel(model);
        	
        	cursor.close();
        	mongoClient.close();
        	}finally {
        		if(cursor!=null)
        			cursor.close();
        	}
        if(mongoClient!=null) {
        	mongoClient.close();
        
        	
        }
        
        /*
         * 책관리에 대한 버튼 그룹을 모아놓은 패널
         * BookManagementGUI 패널의 상단에 위치
         * 한 줄로 표현하기 위해 FlowLayout으로 설정
         * */
        JPanel BookManagementButtonG = new JPanel();
        add(BookManagementButtonG, BorderLayout.NORTH);
        BookManagementButtonG.setLayout(new FlowLayout());
        
        /*
         * 도서관리 메뉴 라벨 명
         * 선택한 책 정보 조회, 책 추가, 책 삭제 버튼과 책검색을 위한 라벨 및 텍스트 필드, 검색 버튼
         * */
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
	}
	
}