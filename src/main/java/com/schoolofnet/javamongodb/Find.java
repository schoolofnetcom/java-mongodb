package com.schoolofnet.javamongodb;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Find {
	
	public void find() {
    	MongoClient con = new Connection().createConnection();
        MongoDatabase db = con.getDatabase("java_mongo");
        
        MongoCollection<Document> collection = db.getCollection("person");
        BasicDBObject query = new BasicDBObject();
//        query.append("_id", new ObjectId("58226e29f4c6ac0b60aefd5c"));

        query.put("techs", new BasicDBObject("$regex", Arrays.asList("PHP")));
        
        for (Document doc: collection.find(query)) {
        	System.out.println(doc.toJson());
        }
	}
}
