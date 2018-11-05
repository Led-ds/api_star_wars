package com.api.starwars.common;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;;

public class BancoDadosConn {

	private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "darthvader";
    private static BancoDadosConn conn;
    private MongoClient mongo;
    private Datastore datastore;
    
    private BancoDadosConn(){
    	super();
    }
    
    public static synchronized BancoDadosConn getInstance() {
        if (conn == null) {
            conn = new BancoDadosConn();
        }
        return conn;
    }
    
	public MongoClient getMongo() {
        if (mongo == null) {
            try {
            	mongo = new MongoClient(HOST);           
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        return mongo;
    }
	
	public Datastore getDatastore() {
        if (datastore == null) {
            datastore = new Morphia().createDatastore(getMongo(), DB_NAME);
        }
        return datastore;
    }
    
}
