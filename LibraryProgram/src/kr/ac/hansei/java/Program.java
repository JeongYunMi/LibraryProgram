/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import java.util.Vector;
import javax.swing.JFrame;

/*
 * Book클래스에는 책시리얼넘버, 책이름, 저자,출판일, 위치, 출판사, 대여일, 반납예정일, 대여유무가 담겨있습니다
 */

class Book {
	
	public static Vector<Book> BookVec = new Vector<Book>(30); //Vector 선언
	private String bookNum; // 책시리얼넘버
	private String bookName; // 책이름
	private String bookWriter; //저자
	private String bookBorn; // 출판일
	private String bookLocation; // 위치
	private String bookPublisher; //출판사
	private String loanDate; //대여일
	private String loanDdate; //반납예정일
	private String loanState; //대여유무
	
	public Book(String bookNum, String bookName, String bookWriter, String bookBorn, String bookLocation,
			String bookPublisher, String loanDate, String loanDdate, String loanState) { 
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookBorn = bookBorn;
		this.bookLocation = bookLocation;
		this.bookPublisher = bookPublisher;
		this.loanDate = loanDate;
		this.loanDdate = loanDdate;
		this.loanState = loanState;
	}
	
	public Book() {	} //생성자
	
	public String getbookNum() { //책시리얼넘버, 책이름, 저자, 출판일, 위치, 출판사는 변하지 않는 내용이니 get 메소드 사용
		return this.bookNum;
	}
	
	public String getBookWriter() {
		return this.bookWriter;
	}

	public String getBookBorn() {
		return this.bookBorn;
	}
	
	public String getBookLocation() {
		return this.bookLocation;
	}

	public String getBookPublisher() {
		return this.bookPublisher;
	}

	public String getLoanDate() { //대여일, 대여 반납일, 대여유무는 변하기 때문에 set메소드를 써준다.
		return this.loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getLoanDdate() {
		return loanDdate;
	}
	
	public void setLoanDdate(String loanDdate) {
		this.loanDdate = loanDdate;
	}

	public String getLoanState() {
		return loanState;
	}
	
	public void setLoanState(String loanState) {
		this.loanState = loanState;
	}
}

public class Program {
	public static void main(String[] args) {
		
		JFrame GuiFrame = new JFrame(); //JFrame 객체 생성(도서관리 프로그램의 가장 큰 틀)
		GuiFrame.setTitle("LibraryProgram"); //Title 이름 정하기
		GuiFrame.setSize(1600, 1000); // 프레임 크기
		GuiFrame.setVisible(true); //프레임 출력
	}
}
