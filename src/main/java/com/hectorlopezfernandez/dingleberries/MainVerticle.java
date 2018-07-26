package com.hectorlopezfernandez.dingleberries;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
    	Router router = Router.router(vertx);
    	router.route("/index.html").handler(routingContext -> {
    		routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
    	});
    	vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

}
