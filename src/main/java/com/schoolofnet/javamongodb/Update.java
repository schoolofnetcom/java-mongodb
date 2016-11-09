package com.schoolofnet.javamongodb;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Update {
	public void update() {
    	MongoClient con = new Connection().createConnection();
        MongoDatabase db = con.getDatabase("java_mongo");
        
        MongoCollection<Document> collection = db.getCollection("person");
        
        Bson query = new Document("_id", new ObjectId("58226f7ef4c6ac1dd80869c5"));
        Bson update = new Document("age", 31);
        
        collection.updateOne(query, new Document("$set", update));
        
        collection.findOneAndUpdate(query, new Document("$set", update));
	}
}
