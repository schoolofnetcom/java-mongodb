package com.schoolofnet.javamongodb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class Insert {

	public void insert() {
    	MongoClient con = new Connection().createConnection();
    
    	con.getDatabase("java_mongo").createCollection("person");
    	
    	
    	//BasicDBObject
    	BasicDBObject document = new BasicDBObject();
    	BasicDBObject subDocument = new BasicDBObject();
    	
        document.put("name", "Leonan");
        document.put("age", 20);
        document.put("techs", Arrays.asList("java", "javascript"));
 
        subDocument.put("info", "value");
        
        document.put("sub", subDocument);
        
    	MongoDatabase db = con.getDatabase("java_mongo");
    	MongoCollection<BasicDBObject> personCollection = db.getCollection("person", BasicDBObject.class);

    	personCollection.insertOne(document);
    	
    	// MAP
    	Map<String, Object> mapDocument = new HashMap<String, Object>();
    	
    	mapDocument.put("name", "Luiz Carlos");
    	mapDocument.put("age", 30);
    	mapDocument.put("techs", Arrays.asList("PHP", "javascript"));
    	
    	personCollection.insertOne(new BasicDBObject(mapDocument));

    	// JSON
    	String json = "{'name': 'Wesley', 'age': 32, 'techs': ['python', 'php', 'javascript']}";

    	DBObject dbObject = (DBObject) JSON.parse(json);
//    	MongoCollection<DBObject> personCollection = db.getCollection("person", DBObject.class);

//    	personCollection.insertOne(dbObject);
    	
    	
	}
}
