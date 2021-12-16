/*
 * class명: DeleteMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi
 * summary : 메뉴 중 회원 관리 탭을 클릭했을 때 나오는 GUI에서 회원삭제 버튼을 클릭하면 호출될 GUI 담은 class
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
		 * 호출되면 해당 클래스의 GUI를 보이게한다.
		 * 그리드 레이아웃으로 선언
		 * */
		setVisible(true);
		setLayout(new GridLayout(3, 1, 10, 0));
		setBounds(0, 0, 400, 200);
		
		/*
		 * LabelDelMember: "멤버 삭제"라는 글자를 출력할 라벨 
		 * */
		JLabel LabelDelMember = new JLabel("멤버 삭제");
		LabelDelMember.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDelMember.setFont(new Font("굴림", Font.PLAIN, 40));
        add(LabelDelMember);
        
        /*
         * PanelInputNumber: 회원 이름을 받는 GUI들이 담길 판넬, 플로우 레이아웃으로 설정
         * LabelNumber: "삭제할 멤버의 회원 번호: " 라벨 
         * TextMemberNum: 삭제할 멤버의 회원 번호를 입력받을 JTextField
         * */
        JPanel PanelInputNumber = new JPanel();
        PanelInputNumber.setLayout(new FlowLayout());
        
        JLabel LabelNumber = new JLabel("삭제할 멤버의 회원 번호: ");
        LabelNumber.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputNumber.add(LabelNumber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNumber.add(TextMemberNum);  
        add(PanelInputNumber);
        
        
        /*
         * ButtonDelMember: 회원 삭제를 하고자 할 때 클릭할 버튼
         * addActionListener로 입력한 정보를 DbConnection 클래스의 DeleteMember로 보낸다.
         * 이후 창을 안보이게 처리
         * */
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