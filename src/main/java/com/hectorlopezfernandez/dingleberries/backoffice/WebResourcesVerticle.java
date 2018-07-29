package com.hectorlopezfernandez.dingleberries.backoffice;

import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.HTTP_PORT;
import static com.hectorlopezfernandez.dingleberries.ConfigurationProperties.HTTP_PORT_DEFAULT_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public final class WebResourcesVerticle extends AbstractVerticle {

	private final static Logger logger = LoggerFactory.getLogger(WebResourcesVerticle.class);

	@Override
	public void start() throws Exception {
		logger.info("Starting the resources verticle");

		int port = config().getInteger(HTTP_PORT, HTTP_PORT_DEFAULT_VALUE);
		Router router = Router.router(vertx);
		StaticHandler handler = StaticHandler.create();
		router.get("/index.html").handler(handler);
		router.get("/resources/*").handler(handler);
		vertx.createHttpServer().requestHandler(router::accept).listen(port);
	}

}
