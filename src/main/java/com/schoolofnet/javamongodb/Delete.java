package com.schoolofnet.javamongodb;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Delete {

	public void delete() {
    	MongoClient con = new Connection().createConnection();
        MongoDatabase db = con.getDatabase("java_mongo");
        
        MongoCollection<Document> collection = db.getCollection("person");
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId("58227274f4c6ac2b302b10b4"));
        
        collection.deleteOne(query);
	}
}
