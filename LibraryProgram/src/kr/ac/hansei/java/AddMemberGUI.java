package kr.ac.hansei.java;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddMemberGUI extends JFrame {

	private DBConnection DbConnection = new DBConnection();
	private JTextField TextMemberNum;
	private JTextField TextMemberName;
	private JTextField TextMemberPhone;
	
	public AddMemberGUI() {
		setVisible(true);
		setLayout(new GridLayout(5, 1, 10, 0));
		setBounds(0, 0, 800, 500);
		
		JLabel LabelAddMember = new JLabel("멤버 추가");
		LabelAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAddMember.setFont(new Font("굴림", Font.PLAIN, 40));
        add(LabelAddMember);
        
        JPanel PanelInputName = new JPanel();
        PanelInputName.setLayout(new FlowLayout());
        JLabel LabelName = new JLabel("회원 이름: ");
        LabelName.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputName.add(LabelName);
        
        TextMemberName = new JTextField();
        TextMemberName.setColumns(15);
        PanelInputName.add(TextMemberName);
        
        
        JPanel PanelInputNunber = new JPanel();
        PanelInputNunber.setLayout(new FlowLayout());
        JLabel LabelNunber = new JLabel("회원 번호: ");
        LabelNunber.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputNunber.add(LabelNunber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNunber.add(TextMemberNum);
        
        
        JPanel PanelInputPhone = new JPanel();
        PanelInputPhone.setLayout(new FlowLayout());
        JLabel LabelPhone = new JLabel("전화 번호: ");
        LabelPhone.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputPhone.add(LabelPhone);
        
        TextMemberPhone = new JTextField();
        TextMemberPhone.setColumns(15);
        PanelInputPhone.add(TextMemberPhone);
        
        add(PanelInputName);
        add(PanelInputNunber);
        add(PanelInputPhone);
        
        
        JButton ButtonAddMember = new JButton("회원 등록");
        ButtonAddMember.setFont(new Font("굴림", Font.PLAIN, 24));
        add(ButtonAddMember);
        
        ButtonAddMember.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DbConnection.AddMember(TextMemberNum.getText(), TextMemberName.getText(), TextMemberPhone.getText());
				setVisible(false);
			}
		});
	}

}
