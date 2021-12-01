package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class MemberManagementGUI extends JPanel{
		private JTextField SearchtextField;
	  
	  public MemberManagementGUI(){
		  
	        setLayout(new BorderLayout());
	        
	        String header[] = {"ȸ����ȣ", "ȸ�� ��", "���� ���� �� ��", "ȸ�� ����"};  	//ȸ�� ������ ���� JTable�� Į�� ��
			String MemberInfo[][] = {										 	//�� ���� ���� �ڷ� - ���� DB���� �̾ƴ� �� ����
					{"2019XXXXX", "������", "5", "���� ����"},
					{"201910063", "������", "3", "��ü"}
			};
	        
	        JTable MemberInfoTable = new JTable(MemberInfo, header);   //JTable ����
	        
	        JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
	        add(MemberTableScroll, BorderLayout.CENTER);
	        
	        JPanel MemberManagementButtonG = new JPanel();
	        MemberManagementButtonG.setLayout(new FlowLayout());
	        add(MemberManagementButtonG, BorderLayout.NORTH);
	        
	        
	        
	        JButton MemberAdd = new JButton("ȸ�� �߰�");
	        MemberManagementButtonG.add(MemberAdd);
	        
	        JButton MemberDetail = new JButton("������ ȸ������ ��ȸ");
	        MemberManagementButtonG.add(MemberDetail);
	        
	        JButton MemberDel = new JButton("ȸ�� ����");
	        MemberManagementButtonG.add(MemberDel);
	        
	        JLabel MemberSearchLabel = new JLabel("ȸ�� �˻�");
	        MemberSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        MemberManagementButtonG.add(MemberSearchLabel);
	        
	        SearchtextField = new JTextField();
	        SearchtextField.setColumns(10);
	        MemberManagementButtonG.add(SearchtextField);
	        
	        JButton SearchButton = new JButton("�˻�");
	        MemberManagementButtonG.add(SearchButton);
	  }
	}