/*
 * class명: BookManagementGUI
 * last update: 21.12.03
 * Contributor : kimjaehoon, jeongyunmi
 * summary : 메뉴 중 책 관리 탭을 클릭했을 때 나오는 GUI를 담은 class
 * 			 책정보 목록을 가지는 JTable과 책관리 관련 버튼(검색, 등록, 삭제 등)을 가지고 있다.
 * */

package kr.ac.hansei.java;

/*
 * class명: BookManagementGUI
 * last update: 21.12.03
 * Contributor : kimjaehoon, jeongyunmi
 * summary : 메뉴 중 책 관리 탭을 클릭했을 때 나오는 GUI를 담은 class
 * 			 책정보 목록을 가지는 JTable과 책관리 관련 버튼(검색, 등록, 삭제 등)을 가지고 있다.
 * */


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

class BookManagementGUI extends JPanel {
	
	private static DBConnection DbConnection = new DBConnection();
	
	private JTextField textField;
	private JTable jtable;

	public BookManagementGUI() {
		/*
		 * 기본 레이아웃을 BorderLayout으로 설정
		 * */
		setLayout(new BorderLayout());
	
		/*
		 * header: 책 관리를 위한 JTable의 칼럼 명
		 * BookInfo: 들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
		 * */

    
		/*
		 * 책정보 출력을 위한 JTable
		 * 화면보다 길어지는 것을 처리하기 위해 JScrollPane으로 처리
		 * */
		JTable BookInfoTable = new JTable();
		JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
		add(BookTableScroll, BorderLayout.CENTER);
		/*
		 * db추가
		 */
		DefaultTableModel model = DbConnection.GetBookData();
		BookInfoTable.setModel(model);
    
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

	    JButton BookAddbtn = new JButton("책 추가");
	    BookAddbtn.setFont(new Font("굴림", Font.PLAIN, 20));
	    BookManagementButtonG.add(BookAddbtn);
	    BookAddbtn.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==BookAddbtn) {
					AddBookGUI.AddBookGUI();
			}
		}
	});
        JButton BookRefresh = new JButton("새로고침");
        BookRefresh.setFont(new Font("굴림", Font.PLAIN, 20));
	    BookManagementButtonG.add(BookRefresh); 
	    
	    JButton BookDelete = new JButton("책 삭제");
	    BookDelete.setFont(new Font("굴림", Font.PLAIN, 20));
	    BookManagementButtonG.add(BookDelete);
	    BookDelete.addActionListener(new ActionListener() { 
    	@Override
    		public void actionPerformed(ActionEvent e) {
    			if(e.getSource()==BookDelete) 
    				DeleteBookGUI.DeleteBookGUI();
		}
    });
    
	    /*
	     * 
	     */
	    
	    BookRefresh.addActionListener(new ActionListener() { 
		@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==BookRefresh) {
					DefaultTableModel BookTable = DbConnection.GetBookData();
					BookInfoTable.setModel(BookTable);
					updateUI();
				}	
			}
    	});
	}
}
