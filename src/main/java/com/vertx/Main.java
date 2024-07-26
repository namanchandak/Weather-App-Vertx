package com.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle());
    }

    public static class MyVerticle extends AbstractVerticle {
        @Override
        public void start(Promise<Void> startPromise) {
            Router router = Router.router(vertx);

            router.get("/").handler(this::handleGetResource);

            vertx.createHttpServer()
                    .requestHandler(router)
                    .listen(8080, ar -> {
                        if (ar.succeeded()) {
                            System.out.println("Server started on port 8080");
                            startPromise.complete();
                        } else {
                            System.out.println("Server start failed: " + ar.cause());
                            startPromise.fail(ar.cause());
                        }
                    });
        }

        private void handleGetResource(RoutingContext routingContext) {
            routingContext.response().setStatusCode(200).end("yo");
        }
    }
}
