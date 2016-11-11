package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Superhero;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Maik on 31/10/16.
 */
@Path("resources")
public class SuperheroResourceImpl implements SuperheroResource {

    private static final String WARNING_NO_FILES = "No superheroes stored yet!";
    private static final String FILE_EXTENSION_JSON = ".json";

    @GET
    @Path("superheroes")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getAllSuperheroes() throws IOException {
        String superheroes = "";
        File dir = new File(".");
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(SuperheroResourceImpl.FILE_EXTENSION_JSON));

        ObjectMapper mapper = new ObjectMapper();
        if (files != null) {
            for (File superheroesFile : files) {
                superheroes += mapper.readValue(superheroesFile, Superhero.class).toJson() + "\n";
            }
        } else {
            return SuperheroResourceImpl.WARNING_NO_FILES;
        }
        return superheroes;
    }

    @GET
    @Path("superheroes/{superheroName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getSuperhero(@PathParam("superheroName") String superheroName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Superhero superheroToReturn = mapper.readValue(new File(superheroName + SuperheroResourceImpl.FILE_EXTENSION_JSON), Superhero.class);
            return superheroToReturn.toJson();
        } catch (Exception e) {
            return "Superhero not found: " + e.getMessage();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("application/x-www-form-urlencoded")
    @Path("superheroes")
    @Override
    public void saveSuperhero(@FormParam("superheroName") String superheroName,
                              @FormParam("superheroPseudonym") String superheroPseudonym,
                              @FormParam("superheroPublisher") String superheroPublisher,
                              @FormParam("superheroDateOfFirstAppearance") String superheroDateOfFirstAppearance,
                              @FormParam("superheroAllies") List<String> superheroAllies,
                              @FormParam("superheroPowers") List<String> superheroPowers) throws IOException, ParseException {

        Superhero superhero = new Superhero();
        superhero.setName(superheroName);
        superhero.setPseudonym(superheroPseudonym);
        superhero.setPublisher(superheroPublisher);
        superhero.setDateOfFirstAppearance(superheroDateOfFirstAppearance);
        superhero.setAllies(superheroAllies);
        superhero.setPowers(superheroPowers);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(superheroName + ".json"), superhero);
    }

}
