package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Superhero;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maik on 12/11/16.
 */
class SuperheroResourceManager {

    private static final String FILE_EXTENSION_JSON = ".json";
    private static final String STRING_MESSAGE_NO_SUPERHEROES_FOUND = "{\"message\":\"No Superheroes found.\"}";
    private final ObjectMapper mapper;

    SuperheroResourceManager() {
        mapper = new ObjectMapper();
    }

    void postSuperhero(Superhero superhero) throws IOException {
        mapper.writeValue(new File(superhero.getName() + FILE_EXTENSION_JSON), superhero);
    }

    String getSuperhero(String superheroName) throws IOException {
        return mapper.readValue(new File(superheroName + FILE_EXTENSION_JSON), Superhero.class).toJson();
    }

    String getAllSuperheroes() throws IOException {
        File dir = new File(".");
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(FILE_EXTENSION_JSON));

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
}
