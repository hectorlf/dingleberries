package com.hectorlopezfernandez.dingleberries;

import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.CONNECTION_STRING;
import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.CONNECTION_STRING_DEFAULT_VALUE;
import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.DATABASE_NAME;
import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.DATABASE_NAME_DEFAULT_VALUE;

import io.vertx.core.json.JsonObject;

public final class MongoClientConfiguration {

	private final JsonObject configuration;

	private MongoClientConfiguration() {
		this.configuration = new JsonObject();
	}

	public static MongoClientConfiguration empty() {
		return new MongoClientConfiguration();
	}

	public static MongoClientConfiguration from(JsonObject contextConfig) {
		MongoClientConfiguration clientConfig = new MongoClientConfiguration();
		clientConfig.dbName(contextConfig.getString(DATABASE_NAME, DATABASE_NAME_DEFAULT_VALUE));
		clientConfig.connectionString(contextConfig.getString(CONNECTION_STRING, CONNECTION_STRING_DEFAULT_VALUE));
		return clientConfig;
	}

	public JsonObject build() {
		return configuration;
	}

	public MongoClientConfiguration dbName(String dbName) {
		configuration.put("db_name", dbName);
		return this;
	}

	public MongoClientConfiguration connectionString(String connectionString) {
		configuration.put("connection_string", connectionString);
		return this;
	}

}
