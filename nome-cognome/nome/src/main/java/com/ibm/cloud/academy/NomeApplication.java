package com.ibm.cloud.academy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

public class NomeApplication extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {

        Router router = Router.router(vertx);

        router.get("/nome").handler(request -> {
            request.response().putHeader("content-type", "text/plain")
                .end("Francesco");
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

