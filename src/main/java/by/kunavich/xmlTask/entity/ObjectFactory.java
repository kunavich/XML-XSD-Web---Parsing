//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.29 at 11:11:18 PM MSK 
//


package by.kunavich.xmlTask.entity;;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.cards package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GreetingCard_QNAME = new QName("http://www.example.com/cards", "Greeting-Card");
    private final static QName _Cards_QNAME = new QName("http://www.example.com/cards", "Cards");
    private final static QName _AdvertisingCard_QNAME = new QName("http://www.example.com/cards", "Advertising-Card");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.cards
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdvertisingCard }
     * 
     */
    public AdvertisingCard createAdvertisingCard() {
        return new AdvertisingCard();
    }

    /**
     * Create an instance of {@link Cards }
     * 
     */
    public Cards createCards() {
        return new Cards();
    }

    /**
     * Create an instance of {@link GreetingCard }
     * 
     */
    public GreetingCard createGreetingCard() {
        return new GreetingCard();
    }

    /**
     * Create an instance of {@link OldCards }
     * 
     */
    public OldCards createOldCards() {
        return new OldCards();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetingCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/cards", name = "Greeting-Card", substitutionHeadNamespace = "http://www.example.com/cards", substitutionHeadName = "Cards")
    public JAXBElement<GreetingCard> createGreetingCard(GreetingCard value) {
        return new JAXBElement<GreetingCard>(_GreetingCard_QNAME, GreetingCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/cards", name = "Cards")
    public JAXBElement<Cards> createCards(Cards value) {
        return new JAXBElement<Cards>(_Cards_QNAME, Cards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdvertisingCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/cards", name = "Advertising-Card", substitutionHeadNamespace = "http://www.example.com/cards", substitutionHeadName = "Cards")
    public JAXBElement<AdvertisingCard> createAdvertisingCard(AdvertisingCard value) {
        return new JAXBElement<AdvertisingCard>(_AdvertisingCard_QNAME, AdvertisingCard.class, null, value);
    }

}
