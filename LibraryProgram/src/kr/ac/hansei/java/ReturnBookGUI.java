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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ReturnBookGUI extends JPanel {

public ReturnBookGUI() {
	/*
	 * 기본 레이아웃을 GridLayout으로 설정
	 * 회원정보와 자료 정보를 수직으로 출력
	 * */
	setLayout(new GridLayout(2, 1));
    
	/*
	 * 회원정보 출력을 위한 패널
	 * 회원 정보 라벨과 회원 정보 출력 부분 패널 포함
	 * */
    JPanel MemberInfoPane = new JPanel();
    MemberInfoPane.setLayout(new GridLayout(1, 2, 20, 5));
    MemberInfoPane.setBounds(0, 0, 1576, 320);
    add(MemberInfoPane);
    
    JLabel MemberInfoLabel = new JLabel("회원 정보");
    MemberInfoLabel.setFont(new Font("돋움", Font.PLAIN, 22));
    MemberInfoPane.add(MemberInfoLabel);
    
    JPanel MemberInfoContentPane = new JPanel();
    MemberInfoContentPane.setSize(1537, 283);
    MemberInfoPane.add(MemberInfoContentPane);
    
    /*
	 * 책정보 출력을 위한 패널
	 * 책 정보 라벨과 책 정보 출력 부분 패널, 반납 버튼 포함
	 * */
    JPanel BookInfoPane = new JPanel();
    BookInfoPane.setLayout(new GridLayout(1, 2, 20, 5));
    BookInfoPane.setSize(1588, 441);
    add(BookInfoPane);
    
    JLabel lblNewLabel1 = new JLabel("자료 정보");
    lblNewLabel1.setFont(new Font("돋움", Font.PLAIN, 22));
    lblNewLabel1.setSize(95, 34);
    BookInfoPane.add(lblNewLabel1);
    
    JPanel BookInfoContentPane = new JPanel();
    BookInfoContentPane.setLayout(new BorderLayout());
    BookInfoContentPane.setSize( 1539, 379);
    BookInfoPane.add(BookInfoContentPane);
    
    JButton btnNewButton = new JButton("반납");
    btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
    btnNewButton.setSize(103, 41);
    BookInfoContentPane.add(btnNewButton);
	}
}