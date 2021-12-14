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
import javax.swing.table.DefaultTableModel;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBConnection{
	
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB db = mongoClient.getDB("BookDB");
	
	public void AddBook() {
					
		DBCollection coll = db.getCollection("BookInfo");
		
		String BookNumber      =  TextBNumber.getText();
		String BookName        =  TextBName.getText();
		String BookAuthor      =  TextBAuthor.getText();
		String BookReleaseDate =  TextReleaseDate.getText();
		String BookPublisher   =  TextBPublisher.getText();
	
		
		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("BookNumber",BookNumber);
		documentDetail.put("title",BookName);
		documentDetail.put("author",BookAuthor);
		documentDetail.put("releasedate",BookReleaseDate);
		documentDetail.put("publisher", BookPublisher);

		coll.insert(documentDetail);
		JOptionPane.showMessageDialog(null, "추가했습니다");
	}
	
	public void DeleteBook() {
		
		DBCollection coll = db.getCollection("BookInfo");
		
	}

}