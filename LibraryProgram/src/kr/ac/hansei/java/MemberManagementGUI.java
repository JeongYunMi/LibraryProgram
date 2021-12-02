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
	        
	        String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};  	//회원 관리를 위한 JTable의 칼럼 명
			String MemberInfo[][] = {										 	//들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
					{"2019XXXXX", "김재훈", "5", "대출 가능"},
					{"201910063", "정윤미", "3", "연체"}
			};
	        
	        JTable MemberInfoTable = new JTable(MemberInfo, header);   //JTable 생성
	        
	        JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
	        add(MemberTableScroll, BorderLayout.CENTER);
	        
	        JPanel MemberManagementButtonG = new JPanel();
	        MemberManagementButtonG.setLayout(new FlowLayout());
	        add(MemberManagementButtonG, BorderLayout.NORTH);
	        
	        
	        
	        JButton MemberAdd = new JButton("회원 추가");
	        MemberManagementButtonG.add(MemberAdd);
	        
	        JButton MemberDetail = new JButton("선택한 회원정보 조회");
	        MemberManagementButtonG.add(MemberDetail);
	        
	        JButton MemberDel = new JButton("회원 삭제");
	        MemberManagementButtonG.add(MemberDel);
	        
	        JLabel MemberSearchLabel = new JLabel("회원 검색");
	        MemberSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        MemberManagementButtonG.add(MemberSearchLabel);
	        
	        SearchtextField = new JTextField();
	        SearchtextField.setColumns(10);
	        MemberManagementButtonG.add(SearchtextField);
	        
	        JButton SearchButton = new JButton("검색");
	        MemberManagementButtonG.add(SearchButton);
	  }
	}