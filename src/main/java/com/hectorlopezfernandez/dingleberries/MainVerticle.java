package com.hectorlopezfernandez.dingleberries;

import com.hectorlopezfernandez.dingleberries.tracker.TrackerVerticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;

public class MainVerticle extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		int trackers = config().getInteger("tracker.instances", 1);
		DeploymentOptions trackerOptions = new DeploymentOptions().setInstances(trackers);
		vertx.deployVerticle(TrackerVerticle.class, trackerOptions);
	}

}
