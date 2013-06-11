package pl.edu.agh.matp.socialNetwork;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
