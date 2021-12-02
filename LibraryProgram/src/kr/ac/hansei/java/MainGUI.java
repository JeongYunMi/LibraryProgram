package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainGUI extends JFrame{
	private JFrame frame;
	MemberManagementGUI memberManagementGUI = new MemberManagementGUI();
	BookManagementGUI bookManagementGUI = new BookManagementGUI();
	LoneBookGUI loneBookGUI = new LoneBookGUI();
	ReturnBookGUI returnBookGUI = new ReturnBookGUI();
	
	public MainGUI() {
		frame = new JFrame();
		
        /*
         * menuPanel: 플로우 레이아웃, 가운데 중심 정렬, 좌우간격 200px, 상하간격 20px
         * 			  프로그램 타이틀("한세 도서 관리 프로그램")인 JLabel, programTitleLabel 과 
         * 			  메뉴버튼(대출, 반납, 도서관리, 유저관리)이 모아져있는 JPanel, menuTabPanel을 포함하고 있음.
         * */
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        
        JLabel programTitleLabel = new JLabel("한세 도서 관리 프로그램");
        programTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        programTitleLabel.setFont(new Font("굴림", Font.PLAIN, 40));
        menuPanel.add(programTitleLabel);
        
        
        JPanel menuTabPanel = new JPanel();
        menuTabPanel.setLayout(new GridLayout(1, 4, 10, 0));
        
        JButton LoneBook = new JButton("대출");
        LoneBook.setFont(new Font("굴림", Font.PLAIN, 30));
        menuTabPanel.add(LoneBook);
        
        JButton ReturnBook = new JButton("반납");
        ReturnBook.setFont(new Font("굴림", Font.PLAIN, 30));
        menuTabPanel.add(ReturnBook);
        
        JButton BookManagement = new JButton("도서 관리");
        BookManagement.setFont(new Font("굴림", Font.PLAIN, 30));
        menuTabPanel.add(BookManagement);
        
        JButton UserManagement = new JButton("유저 관리");
        UserManagement.setFont(new Font("굴림", Font.PLAIN, 30));
        menuTabPanel.add(UserManagement);
        
        menuPanel.add(menuTabPanel);
        
        
        JPanel Card = new JPanel();
        Card.setLayout(new FlowLayout());
        
        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(Card, BorderLayout.CENTER);

        
        UserManagement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Card.removeAll();
				Card.add(memberManagementGUI);
				Card.updateUI();
			}
		});
        
        BookManagement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Card.removeAll();
				Card.add(bookManagementGUI);
				Card.updateUI();
			}
		});
        
        LoneBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Card.removeAll();
				Card.add(loneBookGUI);
				Card.updateUI();
			}
		});
        
        ReturnBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Card.removeAll();
				Card.add(returnBookGUI);
				Card.updateUI();
			}
		});
        
        
        /*
         * frame: GUI 기본 설정 1600*1000사이즈이며, gui 창이 꺼짐과 동시에 프로그램 종료, 바로 보이도록 설정되어 있다.
         * */
        frame.setBounds(0, 0, 1600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}
