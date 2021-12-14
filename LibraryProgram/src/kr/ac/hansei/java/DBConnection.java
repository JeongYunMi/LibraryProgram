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
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class DBConnection{
	
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB db = mongoClient.getDB("BookDB");
	/*
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
  */
	public void AddMember(int number, String name, String phone) {
	     try {
	     	
	     	DBCollection collection = db.getCollection("MemberInfo");
	    	
	    	BasicDBObject document = new BasicDBObject();
	        document.put("memberNum", number);
	        document.put("memberName", name);
	        document.put("memberPhone", phone);
	  
	        //Insert Data01
	        collection.insert(document);
	
	    	mongoClient.close();
	    	}finally {
	    		if(mongoClient!=null)
	    			mongoClient.close();
	    }
	 }
	 
	 public void DeleteMember(int number) {
	     try {
	     	
	     	DBCollection collection = db.getCollection("MemberInfo");
	    	
	    	BasicDBObject document = new BasicDBObject();
	        document.put("memberNum", number);
	  
	        //Insert Data01
	        collection.remove(document);
	
	    	mongoClient.close();
	    	}finally {
	    }
	 }
	 
	 public DefaultTableModel GetMemberData() {      
		 try {
			 
			 DBCursor cursor = null;
			 DBCollection coll = db.getCollection("MemberInfo");
			 String[] columnNames = {"회원번호", "회원 명", "전화번호"};
			 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
			 cursor = coll.find();
			 
			 while(cursor.hasNext()) {
		        	DBObject obj = cursor.next();
		            int memberNum = (int)obj.get("memberNum");
		            String memberName = (String)obj.get("memberName");
		            String memberPhone = (String)obj.get("memberPhone");
		            model.addRow(new Object[] { memberNum, memberName, memberPhone });
		     }
			 
			 return model;
			 
	    }finally {
	    }
	 }
	 
	 public String GetRentalMember(int number) {
		 DBCursor cursor = null;
		 DBCollection coll = db.getCollection("MemberInfo");
		 
		 BasicDBObject whereQuery = new BasicDBObject();
		 whereQuery.put("memberNum", number);
		 cursor = coll.find(whereQuery);
		 
		 String rentalMemberStr = "";
		 
		 while (cursor.hasNext()) {
			 DBObject obj = cursor.next();
			 rentalMemberStr += String.valueOf(obj.get("memberNum"));
			 rentalMemberStr += "," + (String)obj.get("memberName");
			 rentalMemberStr += "," + (String)obj.get("memberPhone");
		 }
		 
		 return rentalMemberStr;
	 }

}