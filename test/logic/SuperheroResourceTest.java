package logic;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.FormParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Maik on 02/11/16.
 */
public class SuperheroResourceTest {

    /*private static final String BASE_URI = "http://localhost:8080/rest/resources/";
    private static HttpServer server;
    private static Client client;
    private static WebTarget target;

    private static HttpServer startServer() {
        final ResourceConfig resourceConfig = new ResourceConfig()
                .packages("logic")
                .register(SuperheroResourceImpl.class);
        // normally the resource class would not be in the unit test class
        // and would be in the `where.my.resources.are` package pr sub package
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    @BeforeClass
    public static void setUpClass() {
        server = startServer();
        client = ClientBuilder.newClient();
        target = client.target(BASE_URI).path("resources");
    }

    @AfterClass
    public static void tearDownClass() {
        server.shutdown();
    }
    */

    @Test
    public void testGetAllSuperheroes() throws IOException {
        SuperheroResource superheroResource = new SuperheroResourceStub();

        assertNull(superheroResource.getAllSuperheroes());
    }

    @Test
    public void testGetSuperhero() {
        SuperheroResource superheroResource = new SuperheroResourceStub();

        assertEquals("peppegino", superheroResource.getSuperhero("peppe"));
    }

    private class SuperheroResourceStub implements SuperheroResource {
        @Override
        public String getAllSuperheroes() throws IOException {
            return null;
        }

        @Override
        public String getSuperhero(String superheroName) {
            return "peppegino";
        }

        @Override
        public void saveSuperhero(@FormParam("superheroName") String superheroName,
                                  @FormParam("superheroPseudonym") String superheroPseudonym,
                                  @FormParam("superheroPublisher") String superheroPublisher,
                                  @FormParam("superheroDateOfFirstAppearance") String superheroDateOfFirstAppearance,
                                  @FormParam("superheroAllies") List<String> superheroAllies,
                                  @FormParam("superheroPowers") List<String> superheroPowers) throws IOException, ParseException {

        }
    }
}
