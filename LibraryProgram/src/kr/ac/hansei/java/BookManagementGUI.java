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

/*
 * ���� ���� �������� ���� class�̴�.
 */

class BookManagementGUI extends JPanel {
	private JTextField textField;
	
	public BookManagementGUI() {
		
		setLayout(new BorderLayout());
		
		String header[] = {"å ��ȣ", "å �̸�", "����", "������", "��ġ", "���ǻ�", "�뿩��","�ݳ� ������", "�뿩 ����"};     //å ������ ���� JTable�� Į�� ��
        String BookInfo[][] = {                                  
              {"1", "�ڹٸ� �ڹٶ�", "������", "1998-11-21", "L-21", "�ڹ����α׷���", "2021-11-21", "2021-11-28", "�뿩 ��"},//�� ���� ���� �ڷ� - ���� DB���� �̾ƴ� �� ����
              {"2", "�ڹ��� ����", "������", "2000-08-21", "L-22", "�ڹ����α׷���", "", "", "�뿩 ����"}
        };
        
        
        JPanel BookManagementButtonG = new JPanel();
        BookManagementButtonG.setBounds(0, 160, 1584, 801);
        add(BookManagementButtonG, BorderLayout.NORTH);
        
        BookManagementButtonG.setLayout(new FlowLayout());
        
        JLabel BookManagement1 = new JLabel("��������");
        BookManagement1.setFont(new Font("����", Font.PLAIN, 30));
        BookManagement1.setHorizontalAlignment(SwingConstants.CENTER);
        BookManagementButtonG.add(BookManagement1);
           
        JButton MoreInfo = new JButton("������ å ���� ��ȸ");
        MoreInfo.setFont(new Font("����", Font.PLAIN, 20));
        BookManagementButtonG.add(MoreInfo);
           
              
        JButton BookAddbtn = new JButton("å �߰�");
        BookAddbtn.setFont(new Font("����", Font.PLAIN, 20));
        BookManagementButtonG.add(BookAddbtn);
              
        JButton BookDelete = new JButton("å ����");
        BookDelete.setFont(new Font("����", Font.PLAIN, 20));
        BookManagementButtonG.add(BookDelete);
              
        JLabel BookSearch = new JLabel("å �˻�");
        BookSearch.setFont(new Font("����", Font.BOLD, 20));
        BookManagementButtonG.add(BookSearch);
        
        JButton BookSearchbtn = new JButton("å �˻�");
        BookSearchbtn.setFont(new Font("����", Font.PLAIN, 20));
        BookManagementButtonG.add(BookSearchbtn);
        
        textField = new JTextField();
        textField.setBounds(1176, 55, 229, 35);
        BookManagementButtonG.add(textField);
        textField.setColumns(10);
        
        JTable BookInfoTable = new JTable(BookInfo, header);   //JTable ����
        JScrollPane BookTableScroll = new JScrollPane(BookInfoTable);
        BookTableScroll.setBounds(37, 106, 1509, 685);
        add(BookTableScroll, BorderLayout.CENTER);   
        
        
	}
	
}