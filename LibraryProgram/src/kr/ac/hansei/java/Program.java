/*
 * class��: Program
 * last update: 21.11.12
 * Contributor : kimjaehoon, jeongyunmi
 * summary : It's a class that will contain a large GUI frame.
 * */

package kr.ac.hansei.java;

import javax.swing.JFrame;

public class Program {
	public static void main(String[] args) {
		
		JFrame GuiFrame = new JFrame(); //JFrame 객체 생성(도서관리 프로그램의 가장 큰 틀)
		GuiFrame.setTitle("LibraryProgram"); //Title 이름 정하기
		GuiFrame.setSize(1600, 1000); // 프레임 크기
		GuiFrame.setVisible(true); //프레임 출력
	}
}
