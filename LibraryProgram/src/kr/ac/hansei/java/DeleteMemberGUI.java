/*
<<<<<<< HEAD
 * class¸í: DeleteMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi
 * summary : ¸Þ´º Áß È¸¿ø °ü¸® ÅÇÀ» Å¬¸¯ÇßÀ» ¶§ ³ª¿À´Â GUI¿¡¼­ È¸¿ø»èÁ¦ ¹öÆ°À» Å¬¸¯ÇÏ¸é È£ÃâµÉ GUI ´ãÀº class
=======
 * classëª…: DeleteMemberGUI
 * last update: 21.12.16
 * Contributor : jeongyunmi
 * summary : ë©”ë‰´ ì¤‘ íšŒì› ê´€ë¦¬ íƒ­ì„ í´ë¦­í–ˆì„ ë•Œ ë‚˜ì˜¤ëŠ” GUIì—ì„œ íšŒì›ì‚­ì œ ë²„íŠ¼ì„ í´ë¦­í•˜ë©´ í˜¸ì¶œë  GUI ë‹´ì€ class
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
		 * È£ÃâµÇ¸é ÇØ´ç Å¬·¡½ºÀÇ GUI¸¦ º¸ÀÌ°ÔÇÑ´Ù.
		 * ±×¸®µå ·¹ÀÌ¾Æ¿ôÀ¸·Î ¼±¾ð
		 * */
		setVisible(true);
		setLayout(new GridLayout(3, 1, 10, 0));
		setBounds(0, 0, 400, 200);
		
		/*
		 * LabelDelMember: "¸â¹ö »èÁ¦"¶ó´Â ±ÛÀÚ¸¦ Ãâ·ÂÇÒ ¶óº§ 
		 * */
		JLabel LabelDelMember = new JLabel("¸â¹ö »èÁ¦");
		LabelDelMember.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDelMember.setFont(new Font("±¼¸²", Font.PLAIN, 40));
        add(LabelDelMember);
        
        /*
         * PanelInputNumber: È¸¿ø ÀÌ¸§À» ¹Þ´Â GUIµéÀÌ ´ã±æ ÆÇ³Ú, ÇÃ·Î¿ì ·¹ÀÌ¾Æ¿ôÀ¸·Î ¼³Á¤
         * LabelNumber: "»èÁ¦ÇÒ ¸â¹öÀÇ È¸¿ø ¹øÈ£: " ¶óº§ 
         * TextMemberNum: »èÁ¦ÇÒ ¸â¹öÀÇ È¸¿ø ¹øÈ£¸¦ ÀÔ·Â¹ÞÀ» JTextField
=======
   private DBConnection DbConnection = new DBConnection();
   private JTextField TextMemberNum;
   
   public DeleteMemberGUI() {
      /*
       * í˜¸ì¶œë˜ë©´ í•´ë‹¹ í´ëž˜ìŠ¤ì˜ GUIë¥¼ ë³´ì´ê²Œí•œë‹¤.
       * ê·¸ë¦¬ë“œ ë ˆì´ì•„ì›ƒìœ¼ë¡œ ì„ ì–¸
       * */
      setVisible(true);
      setLayout(new GridLayout(3, 1, 10, 0));
      setBounds(0, 0, 800, 500);
      
      /*
       * LabelDelMember: "ë©¤ë²„ ì‚­ì œ"ë¼ëŠ” ê¸€ìžë¥¼ ì¶œë ¥í•  ë¼ë²¨ 
       * */
      JLabel LabelDelMember = new JLabel("ë©¤ë²„ ì‚­ì œ");
      LabelDelMember.setHorizontalAlignment(SwingConstants.CENTER);
      LabelDelMember.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 40));
        add(LabelDelMember);
        
        /*
         * PanelInputNumber: íšŒì› ì´ë¦„ì„ ë°›ëŠ” GUIë“¤ì´ ë‹´ê¸¸ íŒë„¬, í”Œë¡œìš° ë ˆì´ì•„ì›ƒìœ¼ë¡œ ì„¤ì •
         * LabelNumber: "ì‚­ì œí•  ë©¤ë²„ì˜ íšŒì› ë²ˆí˜¸: " ë¼ë²¨ 
         * TextMemberNum: ì‚­ì œí•  ë©¤ë²„ì˜ íšŒì› ë²ˆí˜¸ë¥¼ ìž…ë ¥ë°›ì„ JTextField
>>>>>>> Final
         * */
        JPanel PanelInputNumber = new JPanel();
        PanelInputNumber.setLayout(new FlowLayout());
        
<<<<<<< HEAD
        JLabel LabelNumber = new JLabel("»èÁ¦ÇÒ ¸â¹öÀÇ È¸¿ø ¹øÈ£: ");
        LabelNumber.setFont(new Font("±¼¸²", Font.PLAIN, 24));
=======
        JLabel LabelNumber = new JLabel("ì‚­ì œí•  ë©¤ë²„ì˜ íšŒì› ë²ˆí˜¸: ");
        LabelNumber.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 24));
>>>>>>> Final
        PanelInputNumber.add(LabelNumber);
        
        TextMemberNum = new JTextField();
        TextMemberNum.setColumns(15);
        PanelInputNumber.add(TextMemberNum);  
        add(PanelInputNumber);
        
        
        /*
<<<<<<< HEAD
         * ButtonDelMember: È¸¿ø »èÁ¦¸¦ ÇÏ°íÀÚ ÇÒ ¶§ Å¬¸¯ÇÒ ¹öÆ°
         * addActionListener·Î ÀÔ·ÂÇÑ Á¤º¸¸¦ DbConnection Å¬·¡½ºÀÇ DeleteMember·Î º¸³½´Ù.
         * ÀÌÈÄ Ã¢À» ¾Èº¸ÀÌ°Ô Ã³¸®
         * */
        JButton ButtonDelMember = new JButton("È¸¿ø »èÁ¦");
        ButtonDelMember.setFont(new Font("±¼¸²", Font.PLAIN, 24));
=======
         * ButtonDelMember: íšŒì› ì‚­ì œë¥¼ í•˜ê³ ìž í•  ë•Œ í´ë¦­í•  ë²„íŠ¼
         * addActionListenerë¡œ ìž…ë ¥í•œ ì •ë³´ë¥¼ DbConnection í´ëž˜ìŠ¤ì˜ DeleteMemberë¡œ ë³´ë‚¸ë‹¤.
         * ì´í›„ ì°½ì„ ì•ˆë³´ì´ê²Œ ì²˜ë¦¬
         * */
        JButton ButtonDelMember = new JButton("íšŒì› ì‚­ì œ");
        ButtonDelMember.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 24));
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