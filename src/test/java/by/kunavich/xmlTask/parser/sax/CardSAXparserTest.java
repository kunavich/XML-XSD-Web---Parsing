package by.kunavich.xmlTask.parser.sax;

import by.kunavich.xmlTask.exception.ParserException;
import by.kunavich.xmlTask.parser.XmlParserTest;
import by.kunavich.xmlTask.parser.dom.CardDOMparser;
import org.junit.Test;

import java.text.ParseException;

public class CardSAXparserTest extends XmlParserTest {

    @Override
    public void setParser() {
        setParser(new CardSAXParser());
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
