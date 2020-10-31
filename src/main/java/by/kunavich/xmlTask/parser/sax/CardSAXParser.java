package by.kunavich.xmlTask.parser.sax;

import by.kunavich.xmlTask.entity.Cards;

import java.util.List;
import java.io.IOException;

import by.kunavich.xmlTask.parser.XmlParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class CardSAXParser implements XmlParser {
    private CardSAXHandler cardSAXHandler;
    private XMLReader reader;
    public CardSAXParser() {
        // создание SAX-анализатора
        cardSAXHandler = new CardSAXHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(cardSAXHandler);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public List<Cards> parse(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        return cardSAXHandler.cardsList;
    }
}
