package by.kunavich.xmlTask.parser.dom;

import by.kunavich.xmlTask.entity.*;

import by.kunavich.xmlTask.exception.ParserException;
import by.kunavich.xmlTask.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardDOMparser implements XmlParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ADVERTISING_CARD = CardType.Advertising_Card.getTagName();
    private static final String GREETING_CARD = CardType.Greeting_Card.getTagName();
    public static final int FIRST_NODE_INDEX = 0;
   // private Cards card;
    private DocumentBuilder docBuilder;

    public CardDOMparser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Ошибка конфигурации парсера: ", e);
        }
    }

    @Override
    public List<Cards> parse(String path) throws ParserException {
        try {
            Document doc = docBuilder.parse(path);
            Element root = doc.getDocumentElement();
            NodeList cardElementList = root.getChildNodes();
            List<Cards> cards = new ArrayList<>();
            for (int i = 0; i < cardElementList.getLength(); i++) {
                Node node = cardElementList.item(i);
                if (isCardNode(node)) {
                    Element cardElement = (Element) node;
                    Cards card = buildCard(cardElement);
                    cards.add(card);
                }
            }

            return cards;
        } catch (ParseException | IOException | SAXException e) {
            LOGGER.error(e.getMessage());
            throw new ParserException(e);
        }
    }

    private boolean isCardNode(Node node) {
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            return false;
        }

        Element cardElement = (Element) node;
        String name = cardElement.getTagName();
        return ADVERTISING_CARD.equals(name) || GREETING_CARD.equals(name);
    }

    private Cards buildCard(Element depositElement) throws ParseException {
        String name = depositElement.getTagName();
        Cards card = null;
        if (ADVERTISING_CARD.equals(name)) {
            // Demand deposit parameters
            card = new AdvertisingCard();
            String advertise = depositElement.getAttribute(CardParameter.ADVERTISE.getTagName());


            ((AdvertisingCard) card).setAdvertise(advertise);
           // card = advertisingCard;
            //depositBuilder = advertisingCard;
        } else if (GREETING_CARD.equals(name)) {
            // Time deposit parameters
            card = new GreetingCard();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String greetingDateValue = depositElement.getAttribute( CardParameter.GREETING_DATE.getTagName());

            Date greetingDate = format.parse(greetingDateValue);

            ((GreetingCard) card).setGreetingDate(greetingDate);
        }

        // Deposit common parameters
        String year = depositElement.getAttribute(CardParameter.YEAR.getTagName());
        String themeString = depositElement.getAttribute(CardParameter.THEME.getTagName());
        Theme theme = Theme.fromValue(themeString);
        card.setTheme(theme);
        card.setYear(Integer.parseInt(year));

        String authorId = getElementTextContent(depositElement, CardParameter.AUTHOR_ID.getTagName());
        String author = getElementTextContent(depositElement, CardParameter.AUTHOR.getTagName());
        card.setAuthor(author);
        card.setAuthorId(authorId);


        return card;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(FIRST_NODE_INDEX);
        return node.getTextContent();
    }
}