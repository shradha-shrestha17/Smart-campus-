package com.smartcampus;
 
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
 
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;
 
/**
 * Main entry point. Starts the embedded Grizzly HTTP server.
 */
public class Main {
 
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static final String BASE_URI = "http://0.0.0.0:8080/";
 
    public static void main(String[] args) throws IOException {
        // Build ResourceConfig by scanning all packages under com.smartcampus
        final ResourceConfig config = new ResourceConfig()
                .packages("com.smartcampus");
 
        // Start the embedded Grizzly server
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                URI.create(BASE_URI), config);
 
        LOGGER.info("=======================================================");
        LOGGER.info(" Smart Campus API started.");
        LOGGER.info(" Base URL : http://localhost:8080/api/v1");
        LOGGER.info(" Press CTRL+C to stop.");
        LOGGER.info("=======================================================");
 
        // Keep running until CTRL+C
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("Shutting down Smart Campus API...");
            server.shutdownNow();
        }));
 
        Thread.currentThread().join();
    }
}