package pl.edu.agh.matp.socialNetwork;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Lukasz
 * Date: 11.06.13
 * Time: 00:37
 */
class AuthorPublicationsParser {
    public List<String> parse(URL url) {

        SAXBuilder builder = new SAXBuilder();

        try {
            Document document = builder.build(url);
            Element rootNode = document.getRootElement();
            List<Element> list = rootNode.getChildren("dblpkey");

            List<String> publications = new ArrayList<String>();
            for (Element elem : list) {
                if (elem.getAttributes().size() == 0) {
                    publications.add(elem.getText());
                }
            }

            return publications;

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return null;
    }

}
