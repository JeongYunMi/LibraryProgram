package kr.ac.hansei.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class AddBookGUI extends JFrame{
	
	public void AddBookGUI() {
		
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 600, 800);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 800);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		JTextField TextBNumber = new JTextField();
		TextBNumber.setBounds(159, 206, 242, 21);
		panel.add(TextBNumber);
		TextBNumber.setColumns(10);
	
		JTextField TextBName = new JTextField();
		TextBName.setColumns(10);
		TextBName.setBounds(159, 311, 242, 21);
		panel.add(TextBName);
	
		JTextField TextBAuthor = new JTextField();
		TextBAuthor.setColumns(10);
		TextBAuthor.setBounds(159, 416, 242, 21);
		panel.add(TextBAuthor);
	
		JTextField TextReleaseDate = new JTextField();
		TextReleaseDate.setColumns(10);
		TextReleaseDate.setBounds(159, 504, 242, 21);
		panel.add(TextReleaseDate);
	
		JTextField TextBPublisher = new JTextField();
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
	
		JLabel lblNewLabel = new JLabel("책 추가하기");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 10, 588, 146);
		panel.add(lblNewLabel);
	
		JButton BtnAddBtn = new JButton("추가하기");
		BtnAddBtn.setBounds(159, 674, 242, 67);
		panel.add(BtnAddBtn);
		BtnAddBtn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==BtnAddBtn) {
					
				}
			}	
		});
	}
}