package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Superhero;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Maik on 31/10/16.
 */
@Path("resources")
public class SuperheroResource {

    private static final String WARNING_NO_FILES = "No superheroes stored yet!";
    private static final String FILE_EXTENSION_JSON = ".json";

    @GET
    @Path("superheroes")
    @Produces(MediaType.APPLICATION_JSON)
    public static String getAllSuperHeroes() throws IOException {
        String superheroes = "";
        File dir = new File(".");
        File [] files = dir.listFiles((dir1, name) -> name.endsWith(FILE_EXTENSION_JSON));

        ObjectMapper mapper = new ObjectMapper();
        if (files != null) {
            for (File superheroesFile : files) {
                superheroes += mapper.readValue(superheroesFile, Superhero.class).toJson() + "\n";
            }
        } else {
            return WARNING_NO_FILES;
        }
        return superheroes;
    }

    @GET
    @Path("/superhero")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSuperHero(@QueryParam("superheroName") String superheroName) {
        /*
        Superhero superhero = new Superhero();
        superhero.setName(superheroName);
        superhero.setPseudonym("Bruce Wayne");
        List<String> superheroAllies = new ArrayList<>();
        superheroAllies.add("Robin");
        superheroAllies.add("Qui");
        superheroAllies.add("Quo");
        superheroAllies.add("Qua");
        superhero.setAllies(superheroAllies);
        superhero.setPowers(new ArrayList<>());
        superhero.setPublisher("DC");
        superhero.setDateOfFirstAppearance("1939-05-01");
        */
        ObjectMapper mapper = new ObjectMapper();
        //mapper.writeValue(new File(superheroName + ".json"), superhero);
        try {
            Superhero superheroToReturn = mapper.readValue(new File(superheroName + FILE_EXTENSION_JSON), Superhero.class);
            return superheroToReturn.toJson();
        } catch (Exception e) {
            return "Superhero not found: " + e.getMessage();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes("application/x-www-form-urlencoded")
    @Path("save")
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
