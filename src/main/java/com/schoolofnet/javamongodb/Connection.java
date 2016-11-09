package com.schoolofnet.javamongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Connection {

	private static final String HOST  = "localhost";
	private static final Integer PORT = 27017;
	private static final String URI   = "mongodb://localhost:27017";
	private MongoClient INSTANCE = null;
	
	public MongoClient createConnection() {
		MongoClientURI con = new MongoClientURI(URI);
		if (INSTANCE == null) {
			INSTANCE = new MongoClient(con);
			
			return INSTANCE;
		}
		
		return getConnection();
	}
	
	public MongoClient getConnection() {
		return INSTANCE;
	}

	public void closeConnection() {
		INSTANCE.close();
	}
	
}
