/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* 회원정보를 담는 클래스입니다.*/
class Member{
	private int memberNum;   		//회원 고유 번호
	private String memberName;  	//회원 이름
	private int rentalBook;    		//빌린 권 수
	private int totalRentalBook;   	//전체 대여 가능 권 수
	private String memberState;		//회원 상태
	private String rentalBookName = "";  //빌린 책 이름
	
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


public class Program {
	public static void main(String[] args) {
		JFrame GuiFrame = new JFrame(); //JFrame 객체 생성(도서관리 프로그램의 가장 큰 틀)
		
		JPanel TopMenuName = new JPanel();
		
		JLabel menuName = new JLabel("회원 관리");	
		TopMenuName.add(menuName, BorderLayout.NORTH);
		
		GuiFrame.setLayout(new BorderLayout());
		GuiFrame.add(TopMenuName);
		
		
		GuiFrame.setTitle("LibraryProgram"); //Title 이름 정하기
		GuiFrame.setSize(1600, 1000); // 프레임 크기
		GuiFrame.setVisible(true); //프레임 출력
	}
}
