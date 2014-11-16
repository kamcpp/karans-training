package co.karans.session27.client;


import org.glassfish.jersey.client.ClientResponse;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RSClient {
    public static void main(String[] args) {
        Response response = ClientBuilder.
                newClient().
                target("http://ubuntu:8080/rs-services/rs/book").
                queryParam("name", "Book555").
                queryParam("py", "2012").request().get();
        System.out.println(response.readEntity(String.class));
    }
}
