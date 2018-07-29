package com.hectorlopezfernandez.dingleberries;

import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.TRACKER_INSTANCES;
import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.TRACKER_INSTANCES_DEFAULT_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hectorlopezfernandez.dingleberries.analytics.AnalyticsVerticle;
import com.hectorlopezfernandez.dingleberries.tracking.TrackerVerticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;

public final class MainVerticle extends AbstractVerticle {

	private final static Logger logger = LoggerFactory.getLogger(MainVerticle.class);
	
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		logger.info("Starting the main verticle");

		int trackers = config().getInteger(TRACKER_INSTANCES, TRACKER_INSTANCES_DEFAULT_VALUE);
		DeploymentOptions trackerOptions = new DeploymentOptions().setInstances(trackers);
		vertx.deployVerticle(TrackerVerticle.class, trackerOptions);

		DeploymentOptions analyzerOptions = new DeploymentOptions().setWorker(true);
		vertx.deployVerticle(AnalyticsVerticle.class, analyzerOptions);
		
		super.start(startFuture);
	}

}
