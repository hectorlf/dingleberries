package com.hectorlopezfernandez.dingleberries.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class TrackerHandler implements Handler<RoutingContext> {

	private final static Logger logger = LoggerFactory.getLogger(TrackerHandler.class);
	
	@Override
	public void handle(RoutingContext context) {
		logger.info("Tracking data: path=" + context.normalisedPath() + ", preferredLanguage=" + context.preferredLanguage().tag() + ", cookieCount=" + context.cookieCount());
		context.response().end();
	}

}
