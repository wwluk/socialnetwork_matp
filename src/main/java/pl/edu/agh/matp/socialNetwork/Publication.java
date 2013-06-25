package pl.edu.agh.matp.socialNetwork;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Lukasz
 * Date: 11.06.13
 * Time: 08:30
 */
public class Publication {
    private int year;
    private List<String> authors = new ArrayList<String>();
    private String title;

    @JsonProperty(value = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @JsonIgnore
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @JsonProperty(value = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnore
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Publication \"");
        sb.append(title).append("\" (").append(year).append("):")
            .append(System.getProperty("line.separator"));
        for(String author : authors){
            sb.append("- ").append(author).append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
