package data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Created by Maik on 29/10/16.
 */
public class Superhero {
    private String name;
    private String pseudonym;
    private String publisher;
    private List<String> powers;
    private List<String> allies;
    private String dateOfFirstAppearance;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setAllies(List<String> allies) {
        this.allies = allies;
    }

    public List<String> getAllies() {
        return allies;
    }

    public void setDateOfFirstAppearance(String dateOfFirstAppearance) {
        this.dateOfFirstAppearance = dateOfFirstAppearance;
    }

    public String getDateOfFirstAppearance() {
        return dateOfFirstAppearance;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
