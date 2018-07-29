package com.hectorlopezfernandez.dingleberries;

public final class ConfigurationProperties {

	// Server config

	public final static String HTTP_PORT = "http.port";
	public final static int HTTP_PORT_DEFAULT_VALUE = 8080;

	public final static String TRACKER_INSTANCES = "tracker.instances";
	public final static int TRACKER_INSTANCES_DEFAULT_VALUE = 1;
	
	// MongoDB
	
	public final static String DATABASE_NAME = "mongo.dbname";
	public final static String DATABASE_NAME_DEFAULT_VALUE = "dingleberries";
	public final static String CONNECTION_STRING = "mongo.connectionString";
	public final static String CONNECTION_STRING_DEFAULT_VALUE = "mongodb://localhost:27017";	

}
