package data;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Maik on 29/10/16.
 */
public class SuperheroTest {

    @Test
    public void testSuperheroConstructor() {
        Superhero superhero = new Superhero();

        assertNotNull(superhero);
    }

    @Test
    public void testSuperheroNameIsNotEmpty() {
        Superhero superhero = new Superhero();
        String superheroName = "Batman";
        superhero.setName(superheroName);

        assertNotNull(superhero.getName());
        assertEquals(superheroName, superhero.getName());
    }

    @Test
    public void testSuperheroPseudonymIsNotEmpty() {
        Superhero superhero = new Superhero();
        String superHeroPseudonym = "Bruce Wayne";
        superhero.setPseudonym(superHeroPseudonym);

        assertNotNull(superhero.getPseudonym());
        assertEquals(superHeroPseudonym, superhero.getPseudonym());
    }

    @Test
    public void testSuperheroPublisherIsNotNull() {
        Superhero superhero = new Superhero();
        String superheroPublisher = "DC";
        superhero.setPublisher(superheroPublisher);

        assertNotNull(superhero.getPublisher());
        assertEquals(superheroPublisher, superhero.getPublisher());
    }

    @Test
    public void testSuperheroPowersIsNotNull() {
        Superhero superhero = new Superhero();
        List<String> superheroPowers = new ArrayList<>();
        superheroPowers.add("intelligence");
        superheroPowers.add("money");
        superhero.setPowers(superheroPowers);

        assertNotNull(superhero.getPowers());
        assertEquals(superheroPowers, superhero.getPowers());
    }

    @Test
    public void testSuperheroAlliesIsNotNull() {
        Superhero superhero = new Superhero();
        List<String> superheroAllies = new ArrayList<>();
        superheroAllies.add("Robin");
        superhero.setAllies(superheroAllies);

        assertNotNull(superhero.getAllies());
        assertEquals(superheroAllies, superhero.getAllies());
    }

    @Test
    public void testSuperheroDateOfFirstAppearanceIsNotNull() {
        Superhero superhero = new Superhero();
        String dateOfFirstAppearance = "1939-05-01";
        superhero.setDateOfFirstAppearance(dateOfFirstAppearance);

        assertNotNull(superhero.getDateOfFirstAppearance());
        assertEquals(dateOfFirstAppearance, superhero.getDateOfFirstAppearance());
    }

    @Test
    public void testSuperheroObjectToJson() throws JsonProcessingException {
        Superhero superhero = new Superhero();
        superhero.setName("Batman");
        superhero.setPseudonym("Bruce Wayne");
        List<String> superheroAllies = new ArrayList<>();
        superheroAllies.add("Robin");
        superhero.setAllies(superheroAllies);
        superhero.setPowers(new ArrayList<>());
        superhero.setPublisher("DC");
        superhero.setDateOfFirstAppearance("1939-05-01");

        assertNotNull(superhero.toJson());
        assertEquals("{\"name\":\"Batman\",\"pseudonym\":\"Bruce Wayne\",\"publisher\":\"DC\",\"powers\":[],\"allies\":[\"Robin\"],\"dateOfFirstAppearance\":\"1939-05-01\"}", superhero.toJson());
    }
}
