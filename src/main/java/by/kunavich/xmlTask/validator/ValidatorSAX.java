package by.kunavich.xmlTask.validator;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidatorSAX {
    private static final String SCHEMA_LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private final String schemaPath;


    public ValidatorSAX(String schemaPath) {
        this.schemaPath = schemaPath;
    }

    boolean isValid(String path) {
        SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_LANGUAGE);
        File schemaFile = new File(schemaPath);
        try {
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(path);
            validator.validate(source);

            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }
}