package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LoneBookGUI extends JPanel {

public LoneBookGUI() {
	
	setLayout(new GridLayout(2, 1));
    
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
    
    JButton btnNewButton = new JButton("대출");
    btnNewButton.setFont(new Font("돋움", Font.PLAIN, 22));
    btnNewButton.setSize(103, 41);
    BookInfoContentPane.add(btnNewButton);
	}
}