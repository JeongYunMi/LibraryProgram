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
	
	public JTextField textField;
	public JTable BookInfoTable;
    
	public BookManagementGUI() {
		/*
	 * 기본 레이아웃을 BorderLayout으로 설정
	 * */
	setLayout(new BorderLayout());
	
	/*
	 * header: 책 관리를 위한 JTable의 칼럼 명
	 * BookInfo: 들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
	 * */
	String header[] = {"책 번호", "책 이름", "저자", "출판일", "출판사", "대여일","반납 예정일", "대여 유무"};
    String BookInfo[][] = {};
    
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
    BookAddbtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==BookAddbtn) {
				JFrame frame = new JFrame();
				frame.setBounds(0, 0, 600, 800);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 600, 800);
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				
				JTextField TextBNumber = new JTextField();
				TextBNumber.setBounds(159, 206, 242, 21);
				panel.add(TextBNumber);
				TextBNumber.setColumns(10);
				
				JTextField TextBName = new JTextField();
				TextBName.setColumns(10);
				TextBName.setBounds(159, 311, 242, 21);
				panel.add(TextBName);
				
				JTextField TextBAuthor = new JTextField();
				TextBAuthor.setColumns(10);
				TextBAuthor.setBounds(159, 416, 242, 21);
				panel.add(TextBAuthor);
				
				JTextField TextReleaseDate = new JTextField();
				TextReleaseDate.setColumns(10);
				TextReleaseDate.setBounds(159, 504, 242, 21);
				panel.add(TextReleaseDate);
				
				JTextField TextBPublisher = new JTextField();
				TextBPublisher.setColumns(10);
				TextBPublisher.setBounds(159, 602, 242, 21);
				panel.add(TextBPublisher);
				
				JLabel LabelBNumber = new JLabel("번호");
				LabelBNumber.setHorizontalAlignment(SwingConstants.CENTER);
				LabelBNumber.setBounds(159, 166, 235, 30);
				panel.add(LabelBNumber);
				
				JLabel LabelBName = new JLabel("이름");
				LabelBName.setHorizontalAlignment(SwingConstants.CENTER);
				LabelBName.setBounds(159, 271, 235, 30);
				panel.add(LabelBName);
				
				JLabel LabelBAuthor = new JLabel("저자");
				LabelBAuthor.setHorizontalAlignment(SwingConstants.CENTER);
				LabelBAuthor.setBounds(159, 376, 235, 30);
				panel.add(LabelBAuthor);
				
				JLabel LabelBPublishDate = new JLabel("출판일");
				LabelBPublishDate.setHorizontalAlignment(SwingConstants.CENTER);
				LabelBPublishDate.setBounds(159, 464, 235, 30);
				panel.add(LabelBPublishDate);
				
				JLabel LabelBPublisher = new JLabel("출판사");
				LabelBPublisher.setHorizontalAlignment(SwingConstants.CENTER);
				LabelBPublisher.setBounds(159, 562, 235, 30);
				panel.add(LabelBPublisher);
				
				JLabel lblNewLabel = new JLabel("책 추가하기");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
				lblNewLabel.setBounds(0, 10, 588, 146);
				panel.add(lblNewLabel);
				
				JButton BtnAddBtn = new JButton("추가하기");
				BtnAddBtn.setBounds(159, 674, 242, 67);
				panel.add(BtnAddBtn);
				
			}
		}
	});
          
    JButton BookDelete = new JButton("책 삭제");
    BookDelete.setFont(new Font("굴림", Font.PLAIN, 20));
    BookManagementButtonG.add(BookDelete);
    BookDelete.addActionListener(new ActionListener() { 
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==BookDelete) {
				int n = BookInfoTable.getSelectedRow();
			
				DefaultTableModel tm =(DefaultTableModel)BookInfoTable.getModel();
				if(n>=0 && n<BookInfoTable.getRowCount()) {
					tm.removeRow(n);
					}
				JOptionPane.showMessageDialog(null, "삭제되었습니다");
			}
		}
    });
          
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
