package kr.ac.hansei.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBConnection{
	
	 MongoClient mongoClient = new MongoClient("localhost", 27017);
	 DB db = mongoClient.getDB("LibraryProgram");
	 
	 /*
	  * TextField에서 값을 받아와 DB에 저장한다
	  */
	 public void AddBook( String number, String name, String author,
			 String releaseDate, String publisher ) {
        
		 DBCollection coll = db.getCollection("BookInfo");
	      
		 String BookNumber      = number;
		 String BookName        = name;
		 String BookAuthor      = author;
		 String BookReleaseDate = releaseDate;
		 String BookPublisher   = publisher;
		 String loanDate        = "";
		 String returnDate      = "";
		 String loanPerson      = "";
	      
		 BasicDBObject documentDetail = new BasicDBObject();
		 documentDetail.put("BookNumber",BookNumber);
		 documentDetail.put("title",BookName);
		 documentDetail.put("author",BookAuthor);
		 documentDetail.put("releasedate",BookReleaseDate);
		 documentDetail.put("publisher",BookPublisher);
		 documentDetail.put("loanDate", loanDate);
		 documentDetail.put("returnDate", returnDate);
		 documentDetail.put("loanPerson", loanPerson);

		 coll.insert(documentDetail);
		 JOptionPane.showMessageDialog(null, "추가했습니다");
	 }


	 /*
	  * JTable에 DB연동하기
	  */
	 public DefaultTableModel GetBookData() {
		 try {

			 DBCursor cursor = null;

			 DBCollection coll = db.getCollection("BookInfo");
			 String[] columnNames = {"책번호", "책이름", "저자", "출시일", 
					"출판사","대여일","반납일","빌려간회원번호"};
			 DefaultTableModel model = new DefaultTableModel(columnNames, 0);
			 cursor = coll.find();
			
			 while(cursor.hasNext()) {
				 DBObject obj = cursor.next();
				 String bookNumber = (String)obj.get("BookNumber");
				 String title = (String)obj.get("title");
				 String author = (String)obj.get("author");
				 String releaseDate = (String)obj.get("releasedate");
				 String publisher = (String)obj.get("publisher");
				 String loanDate = (String)obj.get("loanDate");
				 String returnDate = (String)obj.get("returnDate");
				 String loanPerson = (String) obj.get("loanPerson");

				 model.addRow(new Object[] { bookNumber, title, author, releaseDate, 
                		publisher, loanDate, returnDate, loanPerson
                });
			}
			return model;
		}finally {		
		}
	}
	 
	 /*
	  * TextField로부터 값을 받아서 삭제
	  */
	 public void DeleteBook(String number) {
		 try {
			 DBCollection collection = db.getCollection("BookInfo");	

			 BasicDBObject query = new BasicDBObject();
			 query.put("BookNumber",number);
			 collection.remove(query);
			   
			 JOptionPane.showMessageDialog(null, "삭제했습니다");
			 
		 }finally {
		 }  
	 }	
	 
	 public void AddMember(String number, String name, String phone) {
		 try {
		     	
			 DBCollection collection = db.getCollection("MemberInfo");
		    	
			 BasicDBObject document = new BasicDBObject();
			 document.put("memberNum", number);
			 document.put("memberName", name);
			 document.put("memberPhone", phone);
		  
			 //Insert Data01
			 collection.insert(document);
		
			
		 }finally {
		 }

	 }
		 
	 public void DeleteMember(String number) {
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
				 String memberNum = (String)obj.get("memberNum");
				 String memberName = (String)obj.get("memberName");
				 String memberPhone = (String)obj.get("memberPhone");
				 model.addRow(new Object[] { memberNum, memberName, memberPhone });
			 } 
			 return model;			 
		 }finally { 	   
		 }
	 }
	 public String GetRentalMember(String number) {
		 DBCursor cursor = null;
		 DBCollection coll = db.getCollection("MemberInfo");
			 
		 BasicDBObject whereQuery = new BasicDBObject();
		 whereQuery.put("memberNum", number);
		 cursor = coll.find(whereQuery);
			 
		 String rentalMemberStr = "";
			 
		 while (cursor.hasNext()) {
			 DBObject obj = cursor.next();
			 rentalMemberStr += (String)obj.get("memberNum");
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
			 rentalBookStr += "," + (String)obj.get("loanPerson");
		 }		 
		 return rentalBookStr;
	 }
		 
	 public void AddRentalBook(String Booknumber, String memberNumber) throws ParseException {
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
		 updateQuery.append("$set", updateList);
		 BasicDBObject searchQuery = new BasicDBObject().append("BookNumber", Booknumber);
		 coll.update(searchQuery, updateQuery);		     
	 
		 JOptionPane.showMessageDialog(null, "성공적으로 대여하였습니다. 반납일은"+format.format(cal.getTime())+"입니다.");
	 }

	 
	/*
	 *TextField로부터 회원번호를 받아
	 *해당 책 정보를 반환시켜준다
	 */
	 public String GetReturnBook(String number) {
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
			 rentalBookStr += "," + (String)obj.get("loanPerson");
		 }		 
		 return rentalBookStr;
	 }
		 
	 /*
	  * BookNum을 받아 해당 DB를 업데이트
	  */
	 public void AddReturnBook(String BookNum) {
		 DBCursor cursor = null;
		 DBCollection coll = db.getCollection("BookInfo");
		 
		 BasicDBObject updateQuery = new BasicDBObject();;
		 BasicDBObject updateList = new BasicDBObject();
		 updateList.append("loanDate", "");
		 updateList.append("returnDate", "");
		 updateList.append("loanPerson", "");
		 
		 updateQuery.append("$set", updateList);
		 BasicDBObject searchQuery = new BasicDBObject().append("BookNumber", BookNum);
		 coll.update(searchQuery, updateQuery); 		 
	 }
}

	

