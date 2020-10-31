package by.kunavich.xmlTask.parser;


import by.kunavich.xmlTask.entity.Cards;
import by.kunavich.xmlTask.exception.ParserException;


import javax.xml.bind.JAXBElement;
import java.util.List;

public interface XmlParser {

    List<Cards> parse(String xmlPath) throws ParserException;

}