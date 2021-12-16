/*
 * class명: AddMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi, kimjaehoon
 * summary : 메뉴 중 회원 관리 탭을 클릭했을 때 나오는 GUI에서 회원추가 버튼을 클릭하면 호출될 GUI 담은 class
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

public class AddMemberGUI extends JFrame {

	private DBConnection DbConnection = new DBConnection();
	private JTextField TextMemberNum;
	private JTextField TextMemberName;
	private JTextField TextMemberPhone;
	
	public AddMemberGUI() {
		/*
		 * 호출되면 해당 클래스의 GUI를 보이게한다.
		 * 그리드 레이아웃으로 선언
		 * */
		setVisible(true);
		setLayout(new GridLayout(5, 1, 10, 0));
		setBounds(0, 0, 800, 500);
		
		/*
		 * LabelAddMember: "멤버 추가"라는 글자를 출력할 라벨 
		 * */
		JLabel LabelAddMember = new JLabel("멤버 추가");
		LabelAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAddMember.setFont(new Font("굴림", Font.PLAIN, 40));
        add(LabelAddMember);
        
        /*
         * PanelInputName: 회원 이름을 받는 GUI들이 담길 판넬, 플로우 레이아웃으로 설정
         * LabelName: "회원 이름" 라벨 
         * TextMemberName: 회원 이름을 입력받을 JTextField
         * */
        JPanel PanelInputName = new JPanel();
        PanelInputName.setLayout(new FlowLayout());
        
        JLabel LabelName = new JLabel("회원 이름: ");
        LabelName.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputName.add(LabelName);
        
        TextMemberName = new JTextField();
        TextMemberName.setColumns(15);
        PanelInputName.add(TextMemberName);
        
        /*
         * PanelInputNumber: 회원 번호를 받는 GUI들이 담길 판넬, 플로우 레이아웃으로 설정
         * LabelNumber: "회원 번호" 라벨 
         * TextMemberNum: 회원 번호를 입력받을 JTextField
         * */
        JPanel PanelInputNumber = new JPanel();
        PanelInputNumber.setLayout(new FlowLayout());
        
        JLabel LabelNumber = new JLabel("회원 번호: ");
        LabelNumber.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputNumber.add(LabelNumber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNumber.add(TextMemberNum);
        
        
        /*
         * PanelInputPhone: 회원 전화번호를 받는 GUI들이 담길 판넬
         * LabelPhone: "전화 번호" 라벨 
         * TextMemberPhone: 전화 번호를 입력받을 JTextField
         * */
        JPanel PanelInputPhone = new JPanel();
        PanelInputPhone.setLayout(new FlowLayout());
        JLabel LabelPhone = new JLabel("전화 번호: ");
        LabelPhone.setFont(new Font("굴림", Font.PLAIN, 24));
        PanelInputPhone.add(LabelPhone);
        
        TextMemberPhone = new JTextField();
        TextMemberPhone.setColumns(15);
        PanelInputPhone.add(TextMemberPhone);
        
        add(PanelInputName);
        add(PanelInputNumber);
        add(PanelInputPhone);
        
        /*
         * ButtonAddMember: 회원 등록을 하고자 할 때 클릭할 버튼
         * addActionListener로 입력한 정보를 DbConnection 클래스의 AddMember로 보낸다.
         * 이후 창을 안보이게 처리
         * */
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
