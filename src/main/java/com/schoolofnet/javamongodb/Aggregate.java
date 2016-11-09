package com.schoolofnet.javamongodb;

import java.util.Arrays;

import javax.print.Doc;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Aggregate {

	public void setUp() {
    	MongoClient con = new Connection().createConnection();
        MongoDatabase db = con.getDatabase("java_mongo");		
        
        MongoCollection<BasicDBObject> collection = db.getCollection("sectors", BasicDBObject.class);
        
        BasicDBObject document1 = new BasicDBObject();
        BasicDBObject document2 = new BasicDBObject();
        BasicDBObject document3 = new BasicDBObject();
        BasicDBObject document4 = new BasicDBObject();
        BasicDBObject document5 = new BasicDBObject();
        
        document1.put("name", "IT");
        document1.put("company", "C1");
        
        document2.put("name", "Financial");
        document2.put("company", "C1");
        
        document3.put("name", "Cleaning");
        document3.put("company", "C2");
        
        document4.put("name", "Directors");
        document4.put("company", "C2");
        
        document5.put("name", "Driver");
        document5.put("company", "C3"); 
        
        collection.insertOne(document1);
        collection.insertOne(document2);
        collection.insertOne(document3);
        collection.insertOne(document4);
        collection.insertOne(document5);
	}
	
	public void aggregate() {
    	MongoClient con = new Connection().createConnection();
        MongoDatabase db = con.getDatabase("java_mongo");
       
        MongoCollection<Document> collection = db.getCollection("sectors");
        
        AggregateIterable<Document> it = collection.aggregate(Arrays.asList(
        		new Document("$group", new Document("_id", "$company"))
        		));
        
        it.forEach(new Block<Document>() {
        	public void apply(Document doc) {
        		System.out.println(doc.toJson());
        	}
		});
	}
	
	public void count() {
    	MongoClient con = new Connection().createConnection();
        MongoDatabase db = con.getDatabase("java_mongo");
       
        MongoCollection<Document> collection = db.getCollection("sectors");
        
        System.out.println(collection.count());
	}
}
