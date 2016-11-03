package logic;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Maik on 03/11/16.
 */
public interface SuperheroResource {

    String getAllSuperheroes() throws IOException;

    String getSuperhero(String superheroName);

    void saveSuperhero(String superheroName,
                       String superheroPseudonym,
                       String superheroPublisher,
                       String superheroDateOfFirstAppearance,
                       List<String> superheroAllies,
                       List<String> superheroPowers) throws IOException, ParseException;
}
