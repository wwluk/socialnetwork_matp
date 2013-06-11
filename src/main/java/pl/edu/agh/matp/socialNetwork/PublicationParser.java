package pl.edu.agh.matp.socialNetwork;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import pl.edu.agh.matp.socialNetwork.Publication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Lukasz
 * Date: 11.06.13
 * Time: 08:28
 */
public class PublicationParser {
    public Publication parse(URL url){
        SAXBuilder builder = new SAXBuilder();

        try {
            Document document = builder.build(url);
            Element rootNode = (Element)document.getRootElement().getChildren().get(0);
            List<Element> authorElements = rootNode.getChildren("author");

            List<String> authors = new ArrayList<String>();
            for (Element author : authorElements) {
                authors.add(author.getText());
            }

            int year = Integer.parseInt(rootNode.getChild("year").getText());
            String title = rootNode.getChild("title").getText();

            Publication p = new Publication();
            p.setAuthors(authors);
            p.setYear(year);
            p.setTitle(title);

            return p;

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return null;
    }
}
