package com.hectorlopezfernandez.dingleberries.analytics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;

public final class AnalyticsVerticle extends AbstractVerticle {

	private final static Logger logger = LoggerFactory.getLogger(AnalyticsVerticle.class);
	
    @Override
    public void start() throws Exception {
    	logger.info("Starting an analytics verticle; worker status: {}", context.isWorkerContext());
    }

}
