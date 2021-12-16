/*
 * class명: ReturnBookGUI
 * last update: 21.12.03
 * Contributor : kimjaehoon, jeongyunmi
 * summary : 메뉴 중 반납 탭을 클릭했을 때 나오는 GUI를 담은 class
 * 			 회원정보 출력 JPanel, 자료 정보 출력 JPanel, 반납 버튼을 포함하고 있다.
 * */

package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


class ReturnBookGUI extends JPanel {

	private DBConnection DbConnection = new DBConnection();
	private JTextField TextMemberNum;
	private JTextField TextBookNum;
	public JTable jtable;

	String[] book = new String[6];
	boolean possibleBook = false;

	public ReturnBookGUI() {
		
		/*
		 * 기본 레이아웃을 GridLayout으로 설정
		 * 회원정보와 자료 정보를 수직으로 출력
		 * */
		setLayout(new BorderLayout(20, 10));
		setBounds(0, 0, 1500, 1000);
	
		JPanel SearchInfoPane = new JPanel();
		SearchInfoPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		add(SearchInfoPane, BorderLayout.NORTH);
	

		JPanel SearchBookPane = new JPanel();
		SearchBookPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		SearchInfoPane.add(SearchBookPane);
	
		JLabel BookSearchLabel = new JLabel("책 번호: ");
		BookSearchLabel.setFont(new Font("돋움", Font.PLAIN, 22));
		SearchBookPane.add(BookSearchLabel);
	
		TextBookNum = new JTextField();
	    TextBookNum.setColumns(15);
	    SearchBookPane.add(TextBookNum);
    
	    JButton BookSearchbtn = new JButton("검색");
	    BookSearchbtn.setFont(new Font("굴림", Font.PLAIN, 20));
	    SearchBookPane.add(BookSearchbtn);
     
	    JPanel ContentPane = new JPanel();
	    ContentPane.setLayout(new GridLayout(2, 1, 0, 10));
	    add(ContentPane, BorderLayout.CENTER);
	    
	    /*
		 * 책정보 출력을 위한 패널
		 * 책 정보 라벨과 책 정보 출력 부분 패널, 대출 버튼 포함
		 * */

	    JPanel BookInfoPane = new JPanel();
	    BookInfoPane.setLayout(new GridLayout(2, 1, 20, 5));
	    ContentPane.add(BookInfoPane);
	    
	    JLabel lblNewLabel1 = new JLabel("자료 정보");
	    lblNewLabel1.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoPane.add(lblNewLabel1);
	    
	    JPanel BookInfoContentPane = new JPanel();
	    BookInfoContentPane.setLayout(new GridLayout(4, 2, 20, 5));
	    BookInfoPane.add(BookInfoContentPane);
	    
	    JLabel BookNameLabel = new JLabel("책 이름: 조회된 정보가 없습니다.");
	    BookNameLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoContentPane.add(BookNameLabel);
	    
	    JLabel BookNumberLabel = new JLabel("책 번호: 조회된 정보가 없습니다.");
	    BookNumberLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoContentPane.add(BookNumberLabel);
	    
	    JLabel BookAuthorLabel = new JLabel("지은이: 조회된 정보가 없습니다.");
	    BookAuthorLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoContentPane.add(BookAuthorLabel);
	    
	    JLabel BookdateLabel = new JLabel("출판일: 조회된 정보가 없습니다.");
	    BookdateLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoContentPane.add(BookdateLabel);
	    
	    JLabel BookPubLabel = new JLabel("출판사: 조회된 정보가 없습니다.");
	    BookPubLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoContentPane.add(BookPubLabel);
	    
	    JLabel BookRentalLabel = new JLabel("책 대여 가능 여부: 조회된 정보가 없습니다.");
	    BookRentalLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	    BookInfoContentPane.add(BookRentalLabel);
    
	    JButton btnNewButton = new JButton("반납");
	    btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
	    add(btnNewButton, BorderLayout.SOUTH);
	    
	    /*
	     * 텍스트 필드에 받은 값을 GetRentalBook으로 반환
	     * 값을 받아와 값 출력
	     */
	  	    
	    BookSearchbtn.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) {
	    		String temp = DbConnection.GetRentalBook(TextBookNum.getText());;
				book = temp.split(",");
				
				if(temp.endsWith(",")) {
					possibleBook = true;
				}
				
				if(temp != "") {
					BookNameLabel.setText("책 이름: " + book[0]);
					BookNumberLabel.setText("책 번호: " + book[1]);
					BookAuthorLabel.setText("지은이: " + book[2]);
					BookdateLabel.setText("출판일: " + book[3]);
					BookPubLabel.setText("출판사: " + book[4]);
					if(possibleBook) {
						BookRentalLabel.setText("책 대여 가능 여부: 가능");
					}else{
						BookRentalLabel.setText("책 대여 가능 여부: 불가");
					}		
				}else {
					JOptionPane.showMessageDialog(null, "일치하는 책 정보가 없습니다.");
				}
			}
		});

	    /*
	     * 반납버튼 클릭시
	     * AddReturnBook으로 TextBookNum 넘겨준다
	     */
	    btnNewButton.addActionListener(new ActionListener() { 
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 DbConnection.AddReturnBook(TextBookNum.getText());;
	        	 JOptionPane.showMessageDialog(null, "반납이 완료되었습니다.");
	         } 		
	    });    
	}
}