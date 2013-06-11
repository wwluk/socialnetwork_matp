package pl.edu.agh.matp.socialNetwork;

import pl.edu.agh.matp.socialNetwork.AuthorPublicationsParser;
import pl.edu.agh.matp.socialNetwork.Publication;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * User: Lukasz
 * Date: 11.06.13
 * Time: 00:52
 */
public class Main {
    public static void main(String args[]) throws MalformedURLException, URISyntaxException {
        AuthorPublicationsParser authorPublicationsParser = new AuthorPublicationsParser();
        PublicationParser publicationParser = new PublicationParser();

        final String person = "b/Bubak:Marian";
        for (String publication : authorPublicationsParser.parse(new URL("http://dblp.uni-trier.de/pers/xk/" + person))) {
            System.out.println(publication);
            Publication p = publicationParser.parse(new URL("http://dblp.uni-trier.de/rec/bibtex/" + publication + ".xml"));
            System.out.println(p);
        }


    }
}
