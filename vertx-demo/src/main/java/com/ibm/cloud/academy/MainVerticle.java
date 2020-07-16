package com.ibm.cloud.academy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

    /**
     * Start the verticle instance.
     * <p>
     * Vert.x calls this method when deploying the instance. You do not call it yourself.
     * <p>
     * A promise is passed into the method, and when deployment is complete the verticle should either call
     * {@link io.vertx.core.Promise#complete} or {@link io.vertx.core.Promise#fail} the future.
     *
     * @param startPromise  the future
     */
    @Override
    public void start(Promise<Void> startPromise) {

        Router router = Router.router(vertx);

        router.get("/hello").handler(request -> {
            request.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x! " + new java.util.Date() + " on " + hostname);
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

