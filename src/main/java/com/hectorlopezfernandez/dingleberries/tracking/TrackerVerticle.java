package com.hectorlopezfernandez.dingleberries.tracking;

import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.HTTP_PORT;
import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.HTTP_PORT_DEFAULT_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hectorlopezfernandez.dingleberries.MongoClientConfiguration;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;

public final class TrackerVerticle extends AbstractVerticle {

	private final static Logger logger = LoggerFactory.getLogger(TrackerVerticle.class);

	private MongoClient mongoClient;

	@Override
	public void start() throws Exception {
		logger.info("Starting a tracker verticle");

		JsonObject mongoConfig = MongoClientConfiguration.from(config()).build();
		mongoClient = MongoClient.createShared(vertx, mongoConfig);

		int port = config().getInteger(HTTP_PORT, HTTP_PORT_DEFAULT_VALUE);
		Router router = Router.router(vertx);
		router.get("/track").handler(new TrackerHandler(mongoClient));
		vertx.createHttpServer().requestHandler(router::accept).listen(port);
	}

	@Override
	public void stop() throws Exception {
		mongoClient.close();
		super.stop();
	}

}
