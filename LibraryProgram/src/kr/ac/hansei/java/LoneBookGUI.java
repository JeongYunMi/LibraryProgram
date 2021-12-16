/*
 * class명: LoneBookGUI
 * last update: 21.12.16
 * Contributor : kimjaehoon, jeongyunmi
 * summary : 메뉴 중 대출 탭을 클릭했을 때 나오는 GUI를 담은 class
 * 			 회원정보 출력 JPanel, 자료 정보 출력 JPanel, 대출 버튼을 포함하고 있다.
 * */

package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


class LoneBookGUI extends JPanel {
	private DBConnection DbConnection = new DBConnection();
	private JTextField TextMemberNum;
	private JTextField TextBookNum;
	
	String[] member = new String[3];
	String[] book = new String[6];
	boolean possibleBook = false;
	boolean possibleMember = false;

public LoneBookGUI() {
	/*
	 * 기본 레이아웃을 BorderLayout으로 설정
	 * 회원정보와 자료 정보를 수직으로 출력
	 * */
	setLayout(new BorderLayout(20, 10));
	setBounds(0, 0, 1500, 1000);
	
	JPanel SearchInfoPane = new JPanel();
	SearchInfoPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
	add(SearchInfoPane, BorderLayout.NORTH);
	
	JPanel SearchMamberPane = new JPanel();
	SearchMamberPane.setLayout(new FlowLayout(FlowLayout.CENTER));
	SearchInfoPane.add(SearchMamberPane);
	
	JLabel MemberSearchLabel = new JLabel("회원 번호: ");
	MemberSearchLabel.setFont(new Font("돋움", Font.PLAIN, 22));
	SearchMamberPane.add(MemberSearchLabel);
	
	TextMemberNum = new JTextField();
    TextMemberNum.setColumns(15);
    SearchMamberPane.add(TextMemberNum);
    
    JButton MemberSearchbtn = new JButton("검색");
    MemberSearchbtn.setFont(new Font("굴림", Font.PLAIN, 20));
    SearchMamberPane.add(MemberSearchbtn);
    
    
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
	 * 회원정보 출력을 위한 패널
	 * 회원 정보 라벨과 회원 정보 출력 부분 패널 포함
	 * */
    JPanel MemberInfoPane = new JPanel();
    MemberInfoPane.setLayout(new GridLayout(2, 1, 0, 10));
    ContentPane.add(MemberInfoPane);
    
    JLabel MemberInfoLabel = new JLabel("회원 정보");
    MemberInfoLabel.setFont(new Font("돋움", Font.PLAIN, 22));
    MemberInfoPane.add(MemberInfoLabel);
    
    JPanel MemberInfoContentPane = new JPanel();
    MemberInfoContentPane.setLayout(new GridLayout(3, 1, 20, 5));
    MemberInfoPane.add(MemberInfoContentPane);
    
    JLabel MemberNameLabel = new JLabel("회원 이름: 조회된 정보가 없습니다.");
    MemberNameLabel.setFont(new Font("돋움", Font.PLAIN, 22));
    MemberInfoContentPane.add(MemberNameLabel);
    
    JLabel MemberNumberLabel = new JLabel("회원 번호: 조회된 정보가 없습니다.");
    MemberNumberLabel.setFont(new Font("돋움", Font.PLAIN, 22));
    MemberInfoContentPane.add(MemberNumberLabel);
    
    JLabel MemberPhoneLabel = new JLabel("회원 전화번호: 조회된 정보가 없습니다.");
    MemberPhoneLabel.setFont(new Font("돋움", Font.PLAIN, 22));
    MemberInfoContentPane.add(MemberPhoneLabel);
    
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
    
    /*
	 * 대출 버튼
	 * */
    JButton btnNewButton = new JButton("대출");
    btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
    add(btnNewButton, BorderLayout.SOUTH);
    
    
    
    /*
     * 회원 조회 버튼을 클릭하면 생길 이벤트
     * */
    MemberSearchbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String temp = DbConnection.GetRentalMember(TextMemberNum.getText());;
			member = temp.split(",");
			if(temp != "") {
				MemberNameLabel.setText("회원 이름: " + member[1]);
				MemberNumberLabel.setText("회원 번호: " + member[0]);
				MemberPhoneLabel.setText("회원 전화번호: " + member[2]);
				possibleMember = true;
			}else {
				JOptionPane.showMessageDialog(null, "일치하는 회원정보가 없습니다.");
			}
		}
	});
    
    /*
     * 책 조회버튼을 클릭하면 생길 이벤트
     * */
    BookSearchbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
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
     * 조회된 정보를 바탕으로 대출을 수행하는 버튼 이벤트
     * */
    btnNewButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if(possibleBook && possibleMember) {
					DbConnection.AddRentalBook(book[1],member[0]);
				}else {
					JOptionPane.showMessageDialog(null, "대여할 수 있는 책이 아니거나, 회원 입력이 제대로 완료되지 않았습니다.");
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	}
}