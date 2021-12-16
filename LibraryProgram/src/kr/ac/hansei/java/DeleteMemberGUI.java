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

public class DeleteMemberGUI extends JFrame {
	private DBConnection DbConnection = new DBConnection();
	private JTextField TextMemberNum;
	
	public DeleteMemberGUI() {
		setVisible(true);
		setLayout(new GridLayout(3, 1, 10, 0));
		setBounds(0, 0, 400, 200);
		
		JLabel LabelDelMember = new JLabel("멤버 삭제");
		LabelDelMember.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDelMember.setFont(new Font("굴림", Font.PLAIN, 40));
        add(LabelDelMember);
        
        JPanel PanelInputNumber = new JPanel();
        PanelInputNumber.setLayout(new FlowLayout());
        JLabel LabelNumber = new JLabel("삭제할 회원 번호: ");
        LabelNumber.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputNumber.add(LabelNumber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNumber.add(TextMemberNum);  
        add(PanelInputNumber);
        
        JButton ButtonDelMember = new JButton("회원 삭제");
        ButtonDelMember.setFont(new Font("굴림", Font.PLAIN, 24));
        add(ButtonDelMember);
        
        ButtonDelMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DbConnection.DeleteMember(TextMemberNum.getText());
				setVisible(false);
			}
		});
	}
}