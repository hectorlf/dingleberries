package com.hectorlopezfernandez.dingleberries;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
    	Router router = Router.router(vertx);
    	router.route("/index.html").handler(routingContext -> {
    		routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
    	});
    	vertx.createHttpServer().requestHandler(router::accept).listen(8080);
        System.out.println("HTTP server started on port 8080");
    }

    public static void main(String[] args) throws InterruptedException {
    	BlockingQueue<AsyncResult<String>> q = new ArrayBlockingQueue<>(1);
    	Vertx.vertx().deployVerticle(new MainVerticle(), q::offer);
    	AsyncResult<String> result = q.take();
    	if (result.failed()) {
    		throw new RuntimeException(result.cause());
    	}
	}

}
