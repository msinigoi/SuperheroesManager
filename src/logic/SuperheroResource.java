package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Superhero;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maik on 31/10/16.
 */
@Path("resources")
public class SuperheroResource {

    private static final String STRING_MESSAGE = "{\"message\":\" ";
    private static final String STRING_NOT_FOUND = " not found.\"}";
    private final SuperheroResourceManager resourceManager;

    public SuperheroResource() {
        resourceManager = new SuperheroResourceManager();
    }

    @GET
    @Path("superheroes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSuperheroes() throws IOException {
        return resourceManager.getAllSuperheroes();
    }

    @GET
    @Path("superheroes/{superheroName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSuperhero(@PathParam("superheroName") String superheroName) {
        try {
            return resourceManager.getSuperhero(superheroName);
        } catch (Exception e) {
            return STRING_MESSAGE + superheroName + STRING_NOT_FOUND;
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("application/x-www-form-urlencoded")
    @Path("superheroes")
    public void saveSuperhero(@FormParam("superheroName") String superheroName,
                              @FormParam("superheroPseudonym") String superheroPseudonym,
                              @FormParam("superheroPublisher") String superheroPublisher,
                              @FormParam("superheroDateOfFirstAppearance") String superheroDateOfFirstAppearance,
                              @FormParam("superheroAllies") List<String> superheroAllies,
                              @FormParam("superheroPowers") List<String> superheroPowers) throws IOException {

        Superhero superhero = new Superhero();
        superhero.setName(superheroName);
        superhero.setPseudonym(superheroPseudonym);
        superhero.setPublisher(superheroPublisher);
        superhero.setDateOfFirstAppearance(superheroDateOfFirstAppearance);
        superhero.setAllies(superheroAllies);
        superhero.setPowers(superheroPowers);
        resourceManager.postSuperhero(superhero);
    }

}
