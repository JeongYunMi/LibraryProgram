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


public class Program {
	public static void main(String[] args) {
		JFrame GuiFrame = new JFrame(); //JFrame 객체 생성(도서관리 프로그램의 가장 큰 틀)
		
		JPanel TopMenuName = new JPanel();
		
		JLabel menuName = new JLabel("회원 관리");	
		TopMenuName.add(menuName); //여기까지 메뉴 이름 나타내는 칸
		
		
		
		
		GuiFrame.setLayout(new BorderLayout());
		GuiFrame.add(TopMenuName, BorderLayout.NORTH);
		
		
		GuiFrame.setTitle("LibraryProgram"); //Title 이름 정하기
		GuiFrame.setSize(1600, 1000); // 프레임 크기
		GuiFrame.setVisible(true); //프레임 출력
		GuiFrame.setLocationRelativeTo(null); // 가운데에서 실행되도록
		GuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 껐을 때 알아서 종료
	}
}
