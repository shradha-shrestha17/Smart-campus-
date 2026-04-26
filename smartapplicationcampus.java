package com.smartcampus;
 
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 
/**
 * JAX-RS Application entry point.
 * All API paths are prefixed with /api/v1.
 */
@ApplicationPath("/api/v1")
public class SmartCampusApplication extends Application {
    // Empty — Jersey auto-discovers all @Path classes in the scanned packages.
