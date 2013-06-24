package pl.edu.agh.matp.utils;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mjamroz
 * Date: 6/23/13
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthorPublicationsEntry {

    private String author;
    private List<String> publications = new LinkedList<String>();

    public AuthorPublicationsEntry() {
    }

    public AuthorPublicationsEntry(String author, List<String> publications) {
        this.author = author;
        this.publications = publications;
    }

    @JsonProperty(value = "collaborator")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty(value = "publications")
    public List<String> getPublications() {
        return publications;
    }

    public void setPublications(List<String> publications) {
        this.publications = publications;
    }

    public void addPublicationAsString(String publication){
        publications.add(publication);
    }
}
