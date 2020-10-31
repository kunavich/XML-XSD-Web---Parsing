package by.kunavich.xmlTask.parser.sax;

import by.kunavich.xmlTask.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardSAXHandler extends DefaultHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ADVERTISING_CARD = CardType.Advertising_Card.getTagName();
    private static final String GREETING_CARD = CardType.Greeting_Card.getTagName();
    Cards cards ;
    List<Cards> cardsList;
    private String values;
    private CardParameter cardParameter;

    @Override
    public void startDocument() {
        cardsList =new ArrayList<>();
        LOGGER.info("Parsing started");
    }
    private boolean isNewElement(String localName){
        return ADVERTISING_CARD.equals(localName)||GREETING_CARD.equals(localName);
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if(isNewElement( localName))        {

            if(ADVERTISING_CARD.equals(localName))            {
                cards = new AdvertisingCard();
                String advertise = attributes.getValue(CardParameter.ADVERTISE.getTagName());
                ((AdvertisingCard) cards).setAdvertise(advertise);
            }
            else{
                cards = new GreetingCard();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = attributes.getValue(CardParameter.GREETING_DATE.getTagName());
                try {
                    Date greetingDate = format.parse(date);
                    ((GreetingCard) cards).setGreetingDate(greetingDate);
                } catch (ParseException e) {
                    LOGGER.error("worng date formate "+e.getMessage(),e);
                }
            }
            String year = attributes.getValue(CardParameter.YEAR.getTagName());
            String theme = attributes.getValue(CardParameter.THEME.getTagName());
            cards.setYear(Integer.parseInt(year));
            cards.setTheme(Theme.fromValue(theme));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        values = new String(ch, start, length);
        if (cardParameter != null) {
            switch (cardParameter) {
                case AUTHOR:
                    cards.setAuthor(values);
                    break;
                case AUTHOR_ID:
                    cards.setAuthorId(values);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            cardParameter.getDeclaringClass(), cardParameter.name());
            }
        }
        values ="";
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isNewElement(localName)) {
            cardsList.add(cards);
            cards=null;
        }
        else{
            cardParameter= CardParameter.valueOf(localName);
        }
    }

    @Override
    public void endDocument() {

    }
}