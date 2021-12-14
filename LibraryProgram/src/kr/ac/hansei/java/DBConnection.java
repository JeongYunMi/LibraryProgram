package kr.ac.hansei.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

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
	 
	 public String GetRentalBook(String number) {
		 DBCursor cursor = null;
		 DBCollection coll = db.getCollection("BookInfo");
		 
		 BasicDBObject whereQuery = new BasicDBObject();
		 whereQuery.put("BookNumber", number);
		 cursor = coll.find(whereQuery);
		 
		 String rentalBookStr = "";
		 
		 while (cursor.hasNext()) {
			 DBObject obj = cursor.next();
			 rentalBookStr += (String)obj.get("title");
			 rentalBookStr += "," + (String)obj.get("BookNumber");
			 rentalBookStr += "," + (String)obj.get("author");
			 rentalBookStr += "," + (String)obj.get("releasedate");
			 rentalBookStr += "," + (String)obj.get("publisher");
			 rentalBookStr += "," + String.valueOf(obj.get("loanPerson"));
		 }
		 
		 return rentalBookStr;
	 }
	 
	 public void AddRentalBook(String Booknumber, int memberNumber) throws ParseException {
		 DBCursor cursor = null;
		 DBCollection coll = db.getCollection("BookInfo");
		 
		 Date now = new Date();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Calendar cal = Calendar.getInstance(); 
		 cal.setTime(now);
		 cal.add(Calendar.DATE, 7);
		 
		 
		 BasicDBObject updateQuery = new BasicDBObject();
		 BasicDBObject updateList = new BasicDBObject();
		 updateList.append("loanPerson", memberNumber);
		 updateList.append("loanDate", format.format(now));
		 updateList.append("returnDate", format.format(cal.getTime()));
		 /*
		 updateQuery.append("$set", new BasicDBObject().append("loanPerson", memberNumber));
		 updateQuery.append("$set", new BasicDBObject().append("loanDate", format.format(now)));
		 updateQuery.append("$set", new BasicDBObject().append("returnDate", format.format(cal.getTime())));
		 */
		 updateQuery.append("$set", updateList);
	     BasicDBObject searchQuery = new BasicDBObject().append("BookNumber", Booknumber);
	     coll.update(searchQuery, updateQuery);
	     
 
		 JOptionPane.showMessageDialog(null, "성공적으로 대여하였습니다. 반납일은"+format.format(cal.getTime())+"입니다.");
	 }

}