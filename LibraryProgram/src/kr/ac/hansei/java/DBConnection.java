package kr.ac.hansei.java;

import javax.swing.table.DefaultTableModel;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DBConnection {
	 MongoClient mongoClient = new MongoClient("localhost", 27017);
  	 DB db = mongoClient.getDB("BookDB");
  	
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
			 
			 cursor.close();
			 mongoClient.close();
			 
			 return model;
			 
	    }finally {
	    	 if(mongoClient!=null)
	    		 mongoClient.close();
	    }
	 }
	
}
