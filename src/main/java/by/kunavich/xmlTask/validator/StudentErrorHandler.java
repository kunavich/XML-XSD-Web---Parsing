package by.kunavich.xmlTask.validator;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class StudentErrorHandler extends DefaultHandler {
    // создание регистратора ошибок для пакета by.bsu.valid
    private Logger logger = LogManager.getLogger();
    public StudentErrorHandler(String log) throws IOException {
// установка файла и формата вывода ошибок
       // logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }
    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }
    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
    }
    private String getLineAddress(SAXParseException e) {
        // определение строки и столбца ошибки
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}