package com.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle());
    }

    public static class MyVerticle extends AbstractVerticle {

        private AsyncHttpClient asyncHttpClient;

        @Override
        public void start(Promise<Void> startPromise) {
            Router router = Router.router(vertx);

            router.get("/").handler(this::handleGetResource);

            // Initialize AsyncHttpClient
            AsyncHttpClientConfig config = Dsl.config().build();
            asyncHttpClient = Dsl.asyncHttpClient(config);

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
            Vertx vertx = routingContext.vertx();
            vertx.<String>executeBlocking(promise -> {
                try {
                    String response = fetchApiData().join(); // Use CompletableFuture's join
                    promise.complete(response);
                } catch (Exception e) {
                    promise.fail(e);
                }
            }, res -> {
                if (res.succeeded()) {
                    routingContext.response().setStatusCode(200).end(res.result());
                } else {
                    routingContext.response().setStatusCode(500).end("Failed to fetch data");
                }
            });
        }

        private CompletableFuture<String> fetchApiData() {
            CompletableFuture<String> future = new CompletableFuture<>();

            asyncHttpClient.prepareGet("https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/summary/")
                    .setHeader("x-rapidapi-key", "14afbecc82mshc0bf7999f7591d4p1e2789jsna173467eac5b")
                    .setHeader("x-rapidapi-host", "forecast9.p.rapidapi.com")
                    .execute()
                    .toCompletableFuture()
                    .thenAccept(response -> {
                        if (response.getStatusCode() == 200) {
                            future.complete(response.getResponseBody());
                        } else {
                            future.completeExceptionally(new RuntimeException("Failed to fetch data"));
                        }
                    }).exceptionally(ex -> {
                        future.completeExceptionally(ex);
                        return null;
                    });

            return future;
        }

        @Override
        public void stop(Promise<Void> stopPromise) throws IOException {
            asyncHttpClient.close();
            stopPromise.complete();
        }
    }
}
