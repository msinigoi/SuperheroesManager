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

    private static final String FILE_EXTENSION_JSON = ".json";
    private static final String STRING_MESSAGE_NO_SUPERHEROES_FOUND = "{\"message\":\"No Superheroes found.\"}";
    private static final String STRING_MESSAGE = "{\"message\":\" ";
    private static final String STRING_NOT_FOUND = " not found.\"}";
    private final ObjectMapper mapper;

    public SuperheroResource() {
        mapper = new ObjectMapper();
    }

    @GET
    @Path("superheroes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSuperheroes() throws IOException {
        File dir = new File(".");
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(SuperheroResource.FILE_EXTENSION_JSON));

        List<Superhero> superheroesList = new ArrayList<>();
        if (files != null) {
            for (File superheroesFile : files) {
                superheroesList.add(mapper.readValue(superheroesFile, Superhero.class));
            }
        } else {
            return STRING_MESSAGE_NO_SUPERHEROES_FOUND;
        }
        return mapper.writeValueAsString(superheroesList);
    }

    @GET
    @Path("superheroes/{superheroName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSuperhero(@PathParam("superheroName") String superheroName) {
        try {
            Superhero superheroToReturn = mapper.readValue(new File(superheroName + SuperheroResource.FILE_EXTENSION_JSON), Superhero.class);
            return superheroToReturn.toJson();
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
                              @FormParam("superheroPowers") List<String> superheroPowers) throws IOException, ParseException {

        Superhero superhero = new Superhero();
        superhero.setName(superheroName);
        superhero.setPseudonym(superheroPseudonym);
        superhero.setPublisher(superheroPublisher);
        superhero.setDateOfFirstAppearance(superheroDateOfFirstAppearance);
        superhero.setAllies(superheroAllies);
        superhero.setPowers(superheroPowers);
        mapper.writeValue(new File(superheroName + ".json"), superhero);
    }

}
