/*
 * class명: MemberManagementGUI
 * last update: 21.12.03
 * Contributor : kimjaehoon, jeongyunmi
 * summary : 메뉴 중 멤버 관리 탭을 클릭했을 때 나오는 GUI를 담은 class
 * 			 멤버 정보 목록을 가지는 JTable과 멤버 관리 관련 버튼(조회,검색, 등록, 삭제 등)을 가지고 있다.
 * */

package kr.ac.hansei.java;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

class MemberManagementGUI extends JPanel{	
	private DBConnection DbConnection = new DBConnection();
	JTable MemberInfoTable = new JTable();
	  
	public MemberManagementGUI(){
		/*
		 * 기본 레이아웃을 BorderLayout으로 설정
		 * */
		setLayout(new BorderLayout());
	        
		/*
		 * header: 멤버 관리를 위한 JTable의 칼럼 명
		 * MemberInfo: 들어갈 정보 예시 자료 - 차후 DB에서 뽑아다 쓸 예정
		 * */
		String header[] = {"회원번호", "회원 명", "대출 가능 권 수", "회원 상태"};
		String MemberInfo[][] = {
				{"2019XXXXX", "김재훈", "5", "대출 가능"},
				{"201910063", "정윤미", "3", "연체"}
		};
			
		/*
		 * 회원 정보 출력을 위한 JTable
		 * 화면보다 길어지는 것을 처리하기 위해 JScrollPane으로 처리
		 * */
		JTable MemberInfoTable = new JTable(MemberInfo, header);
		JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
		add(MemberTableScroll, BorderLayout.CENTER);
	        
	        
	        
	        
		/*
		 * 멤버 관리에 대한 버튼 그룹을 모아놓은 패널
		 * MemberManagementGUI 패널의 상단에 위치
		 * 한 줄로 표현하기 위해 FlowLayout으로 설정
		 * */
		JPanel MemberManagementButtonG = new JPanel();
		MemberManagementButtonG.setLayout(new FlowLayout());
		add(MemberManagementButtonG, BorderLayout.NORTH);
	        
	        
		/*
		 * 도서관리 메뉴 라벨 명
		 * 회원 추가, 회원 삭제 버튼, 새로고침 버튼
		 * */
		JButton MemberAdd = new JButton("회원 추가");
		MemberManagementButtonG.add(MemberAdd);
	        
		JButton MemberDel = new JButton("회원 삭제");
		MemberManagementButtonG.add(MemberDel);
	        
		JButton MemberRefresh = new JButton("정보 새로고침");
		MemberManagementButtonG.add(MemberRefresh);	        
	        
		/*
		 * db추가
		 */
		DefaultTableModel model = DbConnection.GetMemberData();
		MemberInfoTable.setModel(model);
	        	
	        
	        
		MemberAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddMemberGUI AddMemberGui = new AddMemberGUI();
			}
		});
	        
		MemberDel.addActionListener(new ActionListener() {
				@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteMemberGUI DelMemberGui = new DeleteMemberGUI();
			}
		});
	        
		MemberRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel modelRe = DbConnection.GetMemberData();
				MemberInfoTable.setModel(modelRe);
				updateUI();
			}
		});
	}
}

