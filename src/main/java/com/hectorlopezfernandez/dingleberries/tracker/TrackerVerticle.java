package com.hectorlopezfernandez.dingleberries.tracker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public class TrackerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
    	int port = config().getInteger("http.port", 8080);
    	Router router = Router.router(vertx);
    	router.route(HttpMethod.GET, "/track").handler(new TrackerHandler());
    	vertx.createHttpServer().requestHandler(router::accept).listen(port);
    }

}
