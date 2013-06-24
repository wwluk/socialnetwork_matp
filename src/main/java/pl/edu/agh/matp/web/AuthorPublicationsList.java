package pl.edu.agh.matp.web;

import org.codehaus.jackson.annotate.JsonProperty;
import pl.edu.agh.matp.utils.AuthorPublicationsEntry;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mjamroz
 * Date: 6/23/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthorPublicationsList {

    private String scientist;
    private List<AuthorPublicationsEntry> authorPublicationsList = new LinkedList<AuthorPublicationsEntry>();

    public AuthorPublicationsList() {
    }

    @JsonProperty(value = "scientist")
    public String getScientist() {
        return scientist;
    }

    public void setScientist(String scientist) {
        this.scientist = scientist;
    }

    @JsonProperty(value = "collaborators")
    public List<AuthorPublicationsEntry> getAuthorPublicationsList() {
        return authorPublicationsList;
    }

    public void setAuthorPublicationsList(List<AuthorPublicationsEntry> authorPublicationsList) {
        this.authorPublicationsList = authorPublicationsList;
    }

    public void addAuthorPublicationEntry(AuthorPublicationsEntry entry){
        authorPublicationsList.add(entry);
    }
}
