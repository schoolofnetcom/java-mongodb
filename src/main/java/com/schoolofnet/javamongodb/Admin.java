package com.schoolofnet.javamongodb;

import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class Admin {

	public void admin() {
    	// < 2.10
//    	Mongo mongo_old = new Mongo("localhost", 27017);
//    	DB db = mongo_old.getDB("java_mongo");
    	
    	MongoClient mongo = null;
    	MongoDatabase db = null;
    	MongoCredential credential = MongoCredential.createMongoCRCredential("root" , "java_mongo", "123".toCharArray());
		MongoClientURI con = new MongoClientURI("mongodb://localhost:27017");
        	MongoClient mongoReplicaSet = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
        			new ServerAddress("localhost", 27018),
        			new ServerAddress("")
        			));
//        	MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
		mongo = new MongoClient(con);
		
		for (String database : mongo.listDatabaseNames()) {
			System.out.println(database);
		}
		
		db = mongo.getDatabase("java_mongo");    
		db.createCollection("test");
		db.createCollection("test_2");
		
		for (String col : db.listCollectionNames()) {
			System.out.println(col);
		}
		
//		System.out.println(db);
	}
}
