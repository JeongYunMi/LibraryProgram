/*
<<<<<<< HEAD
 * class명: DeleteMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi
 * summary : 메뉴 중 회원 관리 탭을 클릭했을 때 나오는 GUI에서 회원삭제 버튼을 클릭하면 호출될 GUI 담은 class
=======
 * class紐�: DeleteMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi
 * summary : 硫붾돱 以� �쉶�썝 愿�由� �꺆�쓣 �겢由��뻽�쓣 �븣 �굹�삤�뒗 GUI�뿉�꽌 �쉶�썝�궘�젣 踰꾪듉�쓣 �겢由��븯硫� �샇異쒕맆 GUI �떞��� class
>>>>>>> Final
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
<<<<<<< HEAD
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
=======
   private DBConnection DbConnection = new DBConnection();
   private JTextField TextMemberNum;
   
   public DeleteMemberGUI() {
      /*
       * �샇異쒕릺硫� �빐�떦 �겢�옒�뒪�쓽 GUI瑜� 蹂댁씠寃뚰븳�떎.
       * 洹몃━�뱶 �젅�씠�븘�썐�쑝濡� �꽑�뼵
       * */
      setVisible(true);
      setLayout(new GridLayout(3, 1, 10, 0));
      setBounds(0, 0, 800, 500);
      
      /*
       * LabelDelMember: "硫ㅻ쾭 �궘�젣"�씪�뒗 湲��옄瑜� 異쒕젰�븷 �씪踰� 
       * */
      JLabel LabelDelMember = new JLabel("硫ㅻ쾭 �궘�젣");
      LabelDelMember.setHorizontalAlignment(SwingConstants.CENTER);
      LabelDelMember.setFont(new Font("援대┝", Font.PLAIN, 40));
        add(LabelDelMember);
        
        /*
         * PanelInputNumber: �쉶�썝 �씠由꾩쓣 諛쏅뒗 GUI�뱾�씠 �떞湲� �뙋�꽟, �뵆濡쒖슦 �젅�씠�븘�썐�쑝濡� �꽕�젙
         * LabelNumber: "�궘�젣�븷 硫ㅻ쾭�쓽 �쉶�썝 踰덊샇: " �씪踰� 
         * TextMemberNum: �궘�젣�븷 硫ㅻ쾭�쓽 �쉶�썝 踰덊샇瑜� �엯�젰諛쏆쓣 JTextField
>>>>>>> Final
         * */
        JPanel PanelInputNumber = new JPanel();
        PanelInputNumber.setLayout(new FlowLayout());
        
<<<<<<< HEAD
        JLabel LabelNumber = new JLabel("삭제할 멤버의 회원 번호: ");
        LabelNumber.setFont(new Font("굴림", Font.PLAIN, 24));
=======
        JLabel LabelNumber = new JLabel("�궘�젣�븷 硫ㅻ쾭�쓽 �쉶�썝 踰덊샇: ");
        LabelNumber.setFont(new Font("援대┝", Font.PLAIN, 24));
>>>>>>> Final
        PanelInputNumber.add(LabelNumber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNumber.add(TextMemberNum);  
        add(PanelInputNumber);
        
        
        /*
<<<<<<< HEAD
         * ButtonDelMember: 회원 삭제를 하고자 할 때 클릭할 버튼
         * addActionListener로 입력한 정보를 DbConnection 클래스의 DeleteMember로 보낸다.
         * 이후 창을 안보이게 처리
         * */
        JButton ButtonDelMember = new JButton("회원 삭제");
        ButtonDelMember.setFont(new Font("굴림", Font.PLAIN, 24));
=======
         * ButtonDelMember: �쉶�썝 �궘�젣瑜� �븯怨좎옄 �븷 �븣 �겢由��븷 踰꾪듉
         * addActionListener濡� �엯�젰�븳 �젙蹂대�� DbConnection �겢�옒�뒪�쓽 DeleteMember濡� 蹂대궦�떎.
         * �씠�썑 李쎌쓣 �븞蹂댁씠寃� 泥섎━
         * */
        JButton ButtonDelMember = new JButton("�쉶�썝 �궘�젣");
        ButtonDelMember.setFont(new Font("援대┝", Font.PLAIN, 24));
>>>>>>> Final
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