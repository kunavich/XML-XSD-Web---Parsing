package by.kunavich.xmlTask.parser.jaxb;

import by.kunavich.xmlTask.entity.Cards;
import by.kunavich.xmlTask.entity.OldCards;
import by.kunavich.xmlTask.exception.ParserException;
import by.kunavich.xmlTask.parser.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class CardJaxbParser implements XmlParser {
    @Override
    public List<Cards> parse(String xmlPath) throws ParserException {
        try {
            JAXBContext jc = JAXBContext.newInstance(OldCards.class);
            Unmarshaller um = jc.createUnmarshaller();
            File xmlFile = new File(xmlPath);
            OldCards oldCards = (OldCards) um.unmarshal(xmlFile);

            return oldCards.getCards();
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            throw new ParserException(e);
        }
    }
}