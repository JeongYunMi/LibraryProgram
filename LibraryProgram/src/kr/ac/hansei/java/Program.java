/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;

/*ȸ�������� ��� Ŭ�����Դϴ�.*/
class Member{
	private int memberNum;   		//ȸ�� ������ȣ
	private String memberName;  	//ȸ�� �̸�
	private int rentalBook;    		//���� �� ��
	private int totalRentalBook;   	//��ü �뿩���� �Ǽ�
	private String memberState;		//ȸ�� ����
	private String rentalBookName = "";  //���� å �̸�
	
	public Member(int memberNum, String memberName, int rentalBook, int totalRentalBook, String memberState) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.rentalBook = rentalBook;
		this.totalRentalBook = totalRentalBook;
		this.memberState = memberState;
	}
	
	public int getMemberNum() {
		return this.memberNum;
	}
	
	public String getMemberName() {
		return this.memberName;
	}
	
	public int getRentalBook() {
		return this.rentalBook;
	}
	
	public int getTotalRentalBook() {
		return this.totalRentalBook;
	}
	
	public String getMemberState() {
		return this.memberState;
	}
	
	public void setRentalBook(int rentalBook) {
		this.rentalBook = rentalBook;
	}
	
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}

	public String getRentalBookName() {
		return rentalBookName;
	}

	public void setRentalBookName(String rentalBookName) {
		this.rentalBookName = rentalBookName;
	}
}

class MemberManagementGUI {

	private JFrame frame;
	private JTextField SearchtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagementGUI window = new MemberManagementGUI();
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
	public MemberManagementGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();									//�⺻ ������
		frame.setBounds(100, 100, 880, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//GUI â�� ���� ��� �˾Ƽ� ���α׷� ����
		frame.getContentPane().setLayout(null);
		 
		String header[] = {"ȸ����ȣ", "ȸ�� ��", "���� ���� �� ��", "ȸ�� ����"};  	//ȸ�� ������ ���� JTable�� Į�� ��
		String MemberInfo[][] = {										 	//�� ���� ���� �ڷ� - ���� DB���� �̾ƴ� �� ����
				{"2019XXXXX", "������", "5", "���� ����"},
				{"201910063", "������", "3", "��ü"}
		};
		
		JPanel MemberManagementPane = new JPanel();
		MemberManagementPane.setBounds(0, 40, 864, 461);
		frame.getContentPane().add(MemberManagementPane);
		MemberManagementPane.setLayout(null);								//ȸ������ �޴� ���� ���õ� ��� Ȱ��ȭ�� panel
		
		JTable MemberInfoTable = new JTable(MemberInfo, header);
		JScrollPane MemberTableScroll = new JScrollPane(MemberInfoTable);
		MemberTableScroll.setBounds(0, 92, 864, 380);
		MemberManagementPane.add(MemberTableScroll);						//ȸ������ ����� ���� JTable
		
		JLabel MenuLabelMM = new JLabel("ȸ������");
		MenuLabelMM.setBounds(0, 10, 99, 34);
		MenuLabelMM.setFont(new Font("Dialog", Font.BOLD, 24));
		MemberManagementPane.add(MenuLabelMM);								//��������� ǥ���� �޴� �̸�
		
		JPanel MemberManagementButtonG = new JPanel();
		MemberManagementButtonG.setBounds(0, 49, 864, 34);
		MemberManagementPane.add(MemberManagementButtonG);
		MemberManagementButtonG.setLayout(null);							//ȸ�� ������ ���� ��ư�� ��Ƶ� ��
		
		JLabel MemberSearchLabel = new JLabel("ȸ�� �˻�");						
		MemberSearchLabel.setBounds(572, 2, 78, 32);
		MemberSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MemberManagementButtonG.add(MemberSearchLabel);						//ȸ�� �˻� ��
		
		SearchtextField = new JTextField();
		SearchtextField.setBounds(644, 2, 128, 32);
		SearchtextField.setColumns(10);
		MemberManagementButtonG.add(SearchtextField);						//ȸ�� �˻��� ���� �ؽ�Ʈ�ʵ�
		
		JButton SearchButton = new JButton("�˻�");
		SearchButton.setBounds(784, 3, 68, 31);
		MemberManagementButtonG.add(SearchButton);							//�˻� Ȯ�� ��ư
		
		JButton MemberAdd = new JButton("ȸ�� �߰�");
		MemberAdd.setBounds(161, -4, 85, 38);
		MemberManagementButtonG.add(MemberAdd);								//ȸ�� �߰� ��ư
		
		JButton MemberDetail = new JButton("������ ȸ������ ��ȸ");
		MemberDetail.setBounds(0, 0, 149, 34);
		MemberManagementButtonG.add(MemberDetail);							//Table���� ���õ� ȸ���� ���� ������ ��ȸ ��ư
		
		JButton MemberDel = new JButton("ȸ�� ����");
		MemberDel.setBounds(258, -1, 85, 35);
		MemberManagementButtonG.add(MemberDel);								//ȸ�� ���� ��ư
	}

}
