package com.smartcampus.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
import java.util.Map;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource {

    @GET
    public Response discover() {
        Map<String, Object> meta = new LinkedHashMap<>();
        meta.put("api", "Smart Campus Sensor & Room Management API");
        meta.put("version", "1.0.0");
        meta.put("status", "running");

        Map<String, String> contact = new LinkedHashMap<>();
        contact.put("team", "Campus Facilities Engineering");
        contact.put("email", "smartcampus@westminster.ac.uk");
        meta.put("contact", contact);

        Map<String, String> links = new LinkedHashMap<>();
        links.put("rooms", "/api/v1/rooms");
        links.put("sensors", "/api/v1/sensors");
        meta.put("resources", links);

        return Response.ok(meta).build();
    }
}
