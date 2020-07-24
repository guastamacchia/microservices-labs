package com.ibm.cloud.academy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

import java.util.Random;

public class MainVerticle extends AbstractVerticle {

    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
	private final Random rand = new Random();
	private final int maxint = 100;

    @Override
    public void start(Promise<Void> startPromise) {

        Router router = Router.router(vertx);

        router.get("/random").handler(request -> {
			int value = rand.nextInt( maxint ) + 1;
            request.response().putHeader("content-type", "text/plain")
                .end("Numero random generato: " + value);
        });

        vertx.createHttpServer().requestHandler(router).listen(8080, http -> {
            if (http.succeeded()) {
                startPromise.complete();
                System.out.println("HTTP server started on port 8080");
            } else {
                startPromise.fail(http.cause());
            }
        });
    }
}
