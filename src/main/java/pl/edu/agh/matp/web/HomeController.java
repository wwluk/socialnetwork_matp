package pl.edu.agh.matp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.agh.matp.socialNetwork.AuthorPublicationsParser;
import pl.edu.agh.matp.socialNetwork.Publication;
import pl.edu.agh.matp.socialNetwork.PublicationParser;
import pl.edu.agh.matp.utils.AuthorPublicationsEntry;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mjamroz
 * Date: 6/21/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    final String personServiceUrl = "http://dblp.uni-trier.de/pers/xk/";
    final String publicationServiceUrl = "http://dblp.uni-trier.de/rec/bibtex/";
    private AuthorPublicationsParser authorPublicationsParser = new AuthorPublicationsParser();
    private PublicationParser publicationParser = new PublicationParser();

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AuthorPublicationsList search(@RequestParam("search_val")String searchVal){
        return prepareResult(searchVal);
    }

    private AuthorPublicationsList prepareResult(String author){

        String[] nameSurname = author.split(" ");
        String arg = Character.toLowerCase(nameSurname[1].charAt(0)) + "/" + nameSurname[1]+":"+nameSurname[0];
        Map<String,List<Publication>> authorsPublications = new HashMap<String, List<Publication>>();
        AuthorPublicationsList result = null;

        try {
            for (String publication : authorPublicationsParser.parse(new URL(personServiceUrl + arg))){
                result = new AuthorPublicationsList();
                result.setScientist(author);

                Publication p = publicationParser.parse(new URL(publicationServiceUrl+publication+".xml"));
                for (String collaborator : p.getAuthors()){
                    if (!authorsPublications.containsKey(collaborator) && !collaborator.equals(author)){
                        List<Publication> publications = new ArrayList<Publication>();
                        publications.add(p);
                        authorsPublications.put(collaborator,publications);
                    }
                    else if (!collaborator.equals(author)){
                        authorsPublications.get(collaborator).add(p);
                    }
                }
            }
            for (Map.Entry<String,List<Publication>> entry : authorsPublications.entrySet()){
                result.addAuthorPublicationEntry(new AuthorPublicationsEntry(entry.getKey(),entry.getValue()));
            }
            return result;
        } catch (Exception e) {
            return new AuthorPublicationsList(e.toString());
        }

    }

    private String pubToString(Publication p){
        return p.getTitle() + " - " + p.getYear();
    }
}
