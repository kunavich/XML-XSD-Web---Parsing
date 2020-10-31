package by.kunavich.xmlTask.validator;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    public static final String SCHEMA_PATH = "src/test/resources/cards.xsd";
    public static final String VALID_XML_PATH = "src/test/resources/test.xml";
    public static final String NOT_VALID_XML_PATH = "src/test/resources/not_valid_cards.xml";

    @Test
    public void testIsValidShouldReturnTrueWhenFileIsValid() {
        ValidatorSAX validator = new ValidatorSAX(SCHEMA_PATH);
        boolean answer = validator.isValid(VALID_XML_PATH);

        Assert.assertTrue(answer);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenFileIsNotValid() {
        ValidatorSAX validator = new ValidatorSAX(SCHEMA_PATH);

        Assert.assertFalse(validator.isValid(NOT_VALID_XML_PATH));
    }
}
