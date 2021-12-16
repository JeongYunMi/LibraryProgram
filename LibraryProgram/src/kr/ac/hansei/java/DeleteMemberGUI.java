/*
 * class��: DeleteMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi
 * summary : �޴� �� ȸ�� ���� ���� Ŭ������ �� ������ GUI���� ȸ������ ��ư�� Ŭ���ϸ� ȣ��� GUI ���� class
 * */

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
		/*
		 * ȣ��Ǹ� �ش� Ŭ������ GUI�� ���̰��Ѵ�.
		 * �׸��� ���̾ƿ����� ����
		 * */
		setVisible(true);
		setLayout(new GridLayout(3, 1, 10, 0));
		setBounds(0, 0, 400, 200);
		
		/*
		 * LabelDelMember: "��� ����"��� ���ڸ� ����� �� 
		 * */
		JLabel LabelDelMember = new JLabel("��� ����");
		LabelDelMember.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDelMember.setFont(new Font("����", Font.PLAIN, 40));
        add(LabelDelMember);
        
        /*
         * PanelInputNumber: ȸ�� �̸��� �޴� GUI���� ��� �ǳ�, �÷ο� ���̾ƿ����� ����
         * LabelNumber: "������ ����� ȸ�� ��ȣ: " �� 
         * TextMemberNum: ������ ����� ȸ�� ��ȣ�� �Է¹��� JTextField
         * */
        JPanel PanelInputNumber = new JPanel();
        PanelInputNumber.setLayout(new FlowLayout());
        
        JLabel LabelNumber = new JLabel("������ ����� ȸ�� ��ȣ: ");
        LabelNumber.setFont(new Font("����", Font.PLAIN, 24));
        PanelInputNumber.add(LabelNumber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNumber.add(TextMemberNum);  
        add(PanelInputNumber);
        
        
        /*
         * ButtonDelMember: ȸ�� ������ �ϰ��� �� �� Ŭ���� ��ư
         * addActionListener�� �Է��� ������ DbConnection Ŭ������ DeleteMember�� ������.
         * ���� â�� �Ⱥ��̰� ó��
         * */
        JButton ButtonDelMember = new JButton("ȸ�� ����");
        ButtonDelMember.setFont(new Font("����", Font.PLAIN, 24));
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