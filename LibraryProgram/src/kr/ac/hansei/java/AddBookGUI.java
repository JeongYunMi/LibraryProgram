package kr.ac.hansei.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class AddBookGUI extends JFrame{
	
	private static DBConnection DbConnection = new DBConnection();
	   
	private static JTextField TextBNumber;
	private static JTextField TextBName;
	private static JTextField TextBAuthor;
	private static JTextField TextReleaseDate;
	private static JTextField TextBPublisher;

	public static void AddBookGUI() {
		
		/*
		 * 호출될시 새 프레임 열기
		 */
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 600, 800);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	     
		/*
		 * TextField과 label을 받을 패널
		 */
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 800);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	   
		/*
		 * 책 정보를 받기위한 텍스트필드
		 */
		TextBNumber = new JTextField();
		TextBNumber.setBounds(159, 206, 242, 21);
		panel.add(TextBNumber);
		TextBNumber.setColumns(10);
	   
		TextBName = new JTextField();
		TextBName.setColumns(10);
		TextBName.setBounds(159, 311, 242, 21);
		panel.add(TextBName);
	   
		TextBAuthor = new JTextField();
		TextBAuthor.setColumns(10);
		TextBAuthor.setBounds(159, 416, 242, 21);
		panel.add(TextBAuthor);
	   
		TextReleaseDate = new JTextField();
		TextReleaseDate.setColumns(10);
		TextReleaseDate.setBounds(159, 504, 242, 21);
		panel.add(TextReleaseDate);
	   
		TextBPublisher = new JTextField();
		TextBPublisher.setColumns(10);
		TextBPublisher.setBounds(159, 602, 242, 21);
		panel.add(TextBPublisher);
	   
		JLabel LabelBNumber = new JLabel("번호");
		LabelBNumber.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBNumber.setBounds(159, 166, 235, 30);
		panel.add(LabelBNumber);
   
		JLabel LabelBName = new JLabel("이름");
		LabelBName.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBName.setBounds(159, 271, 235, 30);
		panel.add(LabelBName);
   
		JLabel LabelBAuthor = new JLabel("저자");
		LabelBAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBAuthor.setBounds(159, 376, 235, 30);
		panel.add(LabelBAuthor);
   
		JLabel LabelBPublishDate = new JLabel("출판일");
		LabelBPublishDate.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBPublishDate.setBounds(159, 464, 235, 30);
		panel.add(LabelBPublishDate);
   
		JLabel LabelBPublisher = new JLabel("출판사");
		LabelBPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBPublisher.setBounds(159, 562, 235, 30);
		panel.add(LabelBPublisher);
   
		JLabel LabelBAdd = new JLabel("책 추가하기");
		LabelBAdd.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBAdd.setFont(new Font("굴림", Font.PLAIN, 30));
		LabelBAdd.setBounds(0, 10, 588, 146);
		panel.add(LabelBAdd);
   
		/*
         * BtnAddBtn: 책 등록 버튼
         * addActionListener로 입력한 정보를 DbConnection 클래스의 AddBook로 보낸다.
         * 이후 창을 안보이게 처리
         * */
		JButton BtnAddBtn = new JButton("추가하기");
		BtnAddBtn.setBounds(159, 674, 242, 67);
		panel.add(BtnAddBtn);
		BtnAddBtn.addActionListener(new ActionListener() { 		
         @Override
         	public void actionPerformed(ActionEvent e) {
        	 if(e.getSource()==BtnAddBtn) {
        		DbConnection.AddBook(TextBNumber.getText(), TextBName.getText(), TextBAuthor.getText(),
        				 TextReleaseDate.getText(),TextBPublisher.getText());
        		frame.setVisible(false);
            }
         }   
      });
   }
}