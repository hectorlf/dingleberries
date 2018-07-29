package com.hectorlopezfernandez.dingleberries.tracking;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.mongo.WriteOption;
import io.vertx.ext.web.RoutingContext;

final class TrackerHandler implements Handler<RoutingContext> {

	private final static Logger logger = LoggerFactory.getLogger(TrackerHandler.class);
	
	private final MongoClient mongoClient;
	
	public TrackerHandler(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	@Override
	public void handle(RoutingContext context) {
		final Optional<String> siteId = context.queryParam("siteId").stream().findFirst();
		logger.debug("Page view tracked for site with id '{}'", siteId.orElse("Unknown"));
		mongoClient.saveWithOptions("tracks", new JsonObject(), WriteOption.UNACKNOWLEDGED, result -> { logger.debug("Track saved for site with id '{}'", siteId.orElse("Unknown")); });
		context.response().end();
	}

}
