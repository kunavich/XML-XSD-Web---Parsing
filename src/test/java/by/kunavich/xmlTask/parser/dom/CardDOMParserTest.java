package by.kunavich.xmlTask.parser.dom;

import by.kunavich.xmlTask.exception.ParserException;
import by.kunavich.xmlTask.parser.XmlParserTest;
import org.junit.Test;

import java.text.ParseException;

public class CardDOMParserTest extends XmlParserTest {

    @Override
    public void setParser() {
        setParser(new CardDOMparser());
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

