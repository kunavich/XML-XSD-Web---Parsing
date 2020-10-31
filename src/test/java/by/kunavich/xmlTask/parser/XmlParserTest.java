package by.kunavich.xmlTask.parser;

import by.kunavich.xmlTask.entity.AdvertisingCard;
import by.kunavich.xmlTask.entity.Cards;
import by.kunavich.xmlTask.entity.GreetingCard;
import by.kunavich.xmlTask.entity.Theme;
import by.kunavich.xmlTask.exception.ParserException;
import org.junit.Assert;
import org.junit.Before;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


public abstract  class XmlParserTest {
    private static final String PATH_TO_XML_FILE = "src/test/resources/test.xml";
    private static final String INCORRECT_FILE_PATH = "NOT EXITING FILE";
    private XmlParser xmlParser;

    @Before
    public void toDoBeforeTest() {
        setParser();
    }

    public abstract void setParser();

    public void setParser(XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    public void testParseReturnListWhenInputIsCorrect() throws ParserException, ParseException {
        //given
        AdvertisingCard advertisingCard = new AdvertisingCard();
        advertisingCard.setAuthor("IVAN");
        advertisingCard.setAuthorId("ID1232534650");
        advertisingCard.setYear(1995);
        advertisingCard.setTheme(Theme.NATURE);
        advertisingCard.setAdvertise("Vary good");
        Cards firstCard = advertisingCard;

        GreetingCard greetingCard = new GreetingCard();
        greetingCard.setAuthor("Paul");
        greetingCard.setAuthorId("ID1233214654");
        greetingCard.setYear(2018);
        greetingCard.setTheme(Theme.RELIGION);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        greetingCard.setGreetingDate(format.parse("2018-02-14"));
        Cards secondCard = greetingCard;

        // when
        List<Cards> actual = xmlParser.parse(PATH_TO_XML_FILE);

        // then
        List<Cards> expected = Arrays.asList(firstCard, secondCard);
        Assert.assertEquals(expected, actual);
    }

    public void testParseExceptionFilePathIsIncorrect() throws ParserException {
        // when
        List<Cards> actual = xmlParser.parse(INCORRECT_FILE_PATH);
    }
}
