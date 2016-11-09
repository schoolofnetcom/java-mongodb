package com.schoolofnet.javamongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException, ExecutionException {
    	MongoClient conAsync = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));
    	MongoDatabase db = conAsync.getDatabase("java_mongo");
    	MongoCollection<Document> collection = db.getCollection("sectors", Document.class);
    	
    	CompletableFuture<List> result = new CompletableFuture<>();
    	
//    	collection.find().into(new ArrayList<Document>(), 
//    			new SingleResultCallback<List<Document>>() {
//    				@Override
//    				public void onResult(List<Document> list, Throwable tr) {
//    					result.complete(list);
//    				}
//				});
//    	
//    	for (Object obj : result.get()) {
//    		System.out.println(obj);
//    	}
    	
    	Document document = new Document();
    	
        document.put("name", "Leonan");
        document.put("company", "C1");

    	collection.insertOne(document, new SingleResultCallback<Void>() {
    		@Override
    		public void onResult(Void r, Throwable tr) {
    			System.out.println("Inserted");
    		}
		});
    	
    	result.get();
    }
}
