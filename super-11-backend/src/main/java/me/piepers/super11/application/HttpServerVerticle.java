package me.piepers.super11.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * Verticle that handles incoming calls from the UI. 
 * 
 * @author Bas Piepers (bas@piepers.me)
 *
 */
public class HttpServerVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerVerticle.class);
	
	public static final String CONFIG_HTTP_SERVER_PORT = "http.server.port";
	
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		HttpServer server = vertx.createHttpServer();
		
		Router router = Router.router(vertx);
		
		int portNumber = config().getInteger(CONFIG_HTTP_SERVER_PORT);
		
		server.requestHandler(router::accept)
		.listen(portNumber, ar -> {
			if (ar.succeeded()) {
				LOGGER.info("HTTP server running on port {}", portNumber);
				startFuture.complete();
			} else {
				LOGGER.error("Could not start a HTTP server", ar.cause());
				startFuture.fail(ar.cause());
			}
		});
	}
}
