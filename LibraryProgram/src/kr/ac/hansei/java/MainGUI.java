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
         * menuPanel: �÷ο� ���̾ƿ�, ��� �߽� ����, �¿찣�� 200px, ���ϰ��� 20px
         * 			  ���α׷� Ÿ��Ʋ("�Ѽ� ���� ���� ���α׷�")�� JLabel, programTitleLabel �� 
         * 			  �޴���ư(����, �ݳ�, ��������, ��������)�� ������ִ� JPanel, menuTabPanel�� �����ϰ� ����.
         * */
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        
        JLabel programTitleLabel = new JLabel("�Ѽ� ���� ���� ���α׷�");
        programTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        programTitleLabel.setFont(new Font("����", Font.PLAIN, 40));
        menuPanel.add(programTitleLabel);
        
        
        JPanel menuTabPanel = new JPanel();
        menuTabPanel.setLayout(new GridLayout(1, 4, 10, 0));
        
        JButton LoneBook = new JButton("����");
        LoneBook.setFont(new Font("����", Font.PLAIN, 30));
        menuTabPanel.add(LoneBook);
        
        JButton ReturnBook = new JButton("�ݳ�");
        ReturnBook.setFont(new Font("����", Font.PLAIN, 30));
        menuTabPanel.add(ReturnBook);
        
        JButton BookManagement = new JButton("���� ����");
        BookManagement.setFont(new Font("����", Font.PLAIN, 30));
        menuTabPanel.add(BookManagement);
        
        JButton UserManagement = new JButton("���� ����");
        UserManagement.setFont(new Font("����", Font.PLAIN, 30));
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
         * frame: GUI �⺻ ���� 1600*1000�������̸�, gui â�� ������ ���ÿ� ���α׷� ����, �ٷ� ���̵��� �����Ǿ� �ִ�.
         * */
        frame.setBounds(0, 0, 1600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}
