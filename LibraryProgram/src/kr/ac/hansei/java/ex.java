package kr.ac.hansei.java;

import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ex {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex window = new ex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
     
        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 1600, 1000);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("   \uD55C\uC138 \uB3C4\uC11C \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("����", Font.PLAIN, 40));
        lblNewLabel.setBounds(0, 0, 524, 200);
        panel.add(lblNewLabel);
        
        JButton MenuTab = new JButton("\uB300\uCD9C");
        MenuTab.setFont(new Font("����", Font.PLAIN, 30));
        MenuTab.setBounds(643, 0, 240, 160);
        panel.add(MenuTab);
        
        JButton BookManagement = new JButton("���� ����");
        BookManagement.setFont(new Font("����", Font.PLAIN, 30));
        BookManagement.setBounds(1120, 0, 240, 160);
        panel.add(BookManagement);
       
        
        JButton UserManagement = new JButton("���� ����");
        UserManagement.setFont(new Font("����", Font.PLAIN, 30));
        UserManagement.setBounds(1360, 0, 240, 160);
        panel.add(UserManagement);
        
        JButton ReturnBook = new JButton("�ݳ�");
        ReturnBook.setFont(new Font("����", Font.PLAIN, 30));
        ReturnBook.setBounds(881, 0, 240, 160);
        panel.add(ReturnBook);
     
        
        JButton LoanBook = new JButton("�뿩");
        LoanBook.setFont(new Font("����", Font.PLAIN, 30));
        LoanBook.setBounds(0, 800, 400, 200);
        panel.setBounds(0, 10, 1600, 1000);
        panel.setLayout(null);
        
        String header[] = {"å ��ȣ", "å �̸�", "����", "������", "��ġ", "���ǻ�", "�뿩��","�ݳ� ������", "�뿩 ����"};     //å ������ ���� JTable�� Į�� ��
        String BookInfo[][] = {                                  
              {"1", "�ڹٸ� �ڹٶ�", "������", "1998-11-21", "L-21", "�ڹ����α׷���", "2021-11-21", "2021-11-28", "�뿩 ��"},//�� ���� ���� �ڷ� - ���� DB���� �̾ƴ� �� ����
              {"2", "�ڹ��� ����", "������", "2000-08-21", "L-22", "�ڹ����α׷���", "", "", "�뿩 ����"}
        };
        
        JTextField textField = new JTextField();   //�˻��� �ý�Ʈ�ʵ� ����
        textField.setBounds(1200, 100, 200, 50);
        panel.add(textField);
        textField.setColumns(10);
        
        
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 160, 1594, 801);
        panel.add(panel1);
        
           JLabel BookManagement1 = new JLabel("��������");
           BookManagement1.setFont(new Font("����", Font.PLAIN, 30));
           BookManagement1.setHorizontalAlignment(SwingConstants.CENTER);
           BookManagement1.setBounds(0, 10, 1600, 110);
           panel1.add(BookManagement1);
           
           JButton MoreInfo = new JButton("������ å ���� ��ȸ");
           MoreInfo.setFont(new Font("����", Font.PLAIN, 20));
           MoreInfo.setBounds(0, 100, 300, 50);
           panel1.add(MoreInfo);
           
              
              JButton BookAddbtn = new JButton("å �߰�");
              BookAddbtn.setFont(new Font("����", Font.PLAIN, 20));
              BookAddbtn.setBounds(320, 100, 150, 50);
              panel1.add(BookAddbtn);
              
              JButton BookDelete = new JButton("å ����");
              BookDelete.setFont(new Font("����", Font.PLAIN, 20));
              BookDelete.setBounds(490, 100, 150, 50);
              panel1.add(BookDelete);
              
              JLabel BookSearch = new JLabel("å �˻�");
              BookSearch.setFont(new Font("����", Font.BOLD, 20));
              BookSearch.setBounds(1100, 100, 100, 50);
              panel1.add(BookSearch);
        
        JButton BookSearchbtn = new JButton("å �˻�");
        BookSearchbtn.setFont(new Font("����", Font.PLAIN, 20));
        BookSearchbtn.setBounds(1419, 100, 150, 50);
        panel1.add(BookSearchbtn);
        
        JTable BookInfoTable = new JTable(BookInfo, header);   //JTable ����
        JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
        BookTableScroll.setBounds(0, 200, 1600, 800);
        panel1.add(BookTableScroll);   
	}

}
