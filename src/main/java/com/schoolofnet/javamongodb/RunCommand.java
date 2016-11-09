package com.schoolofnet.javamongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RunCommand {
	
	public void run() {
		MongoClient con = new Connection().createConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		
		MongoCollection<Document> collection = db.getCollection("sectors");
		
		Document command = db.runCommand(new Document("$eval", "function a() { return 5 + 1 } "));
		
		System.out.println(command.toJson());
	}
}
