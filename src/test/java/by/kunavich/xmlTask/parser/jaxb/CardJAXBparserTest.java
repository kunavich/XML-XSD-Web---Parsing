package by.kunavich.xmlTask.parser.jaxb;

import by.kunavich.xmlTask.exception.ParserException;
import by.kunavich.xmlTask.parser.XmlParserTest;
import by.kunavich.xmlTask.parser.dom.CardDOMparser;
import org.junit.Test;

import java.text.ParseException;

public class CardJAXBparserTest extends XmlParserTest {

    @Override
    public void setParser() {
        setParser(new CardJaxbParser());
    }

    @Test
    @Override
    public void testParseReturnListWhenInputIsCorrect() throws ParserException, ParseException {
        super.testParseReturnListWhenInputIsCorrect();
    }

    @Test(expected = ParserException.class)
    @Override
    public void testParseExceptionFilePathIsIncorrect() throws ParserException {
        super.testParseExceptionFilePathIsIncorrect();
    }
}
