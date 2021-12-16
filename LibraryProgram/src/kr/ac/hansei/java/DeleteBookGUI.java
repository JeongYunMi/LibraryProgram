package kr.ac.hansei.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteBookGUI {
	
	private static DBConnection DbConnection = new DBConnection();

	public static void DeleteBookGUI() {
		
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 600, 800);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 800);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("삭제할 책 번호를 적으시오");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 10, 588, 146);
		panel.add(lblNewLabel);
		
		JTextField textBNumber = new JTextField();
		textBNumber.setBounds(159, 166, 196, 23);
		panel.add(textBNumber);
			
		JButton btnNewButton = new JButton("삭제");	
		btnNewButton.setBounds(0, 618, 575, 140);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { 
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            if(e.getSource()==btnNewButton) {
	            	DbConnection.DeleteBook(textBNumber.getText());
	            	frame.setVisible(false);
	            }
	         }   
		});	
	}
}