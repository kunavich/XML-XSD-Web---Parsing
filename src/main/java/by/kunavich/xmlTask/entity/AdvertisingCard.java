//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.29 at 11:11:18 PM MSK 
//


package by.kunavich.xmlTask.entity;;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


/**
 * <p>Java class for Advertising_Card complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Advertising_Card">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.com/cards}Cards">
 *       &lt;attribute name="Advertise" type="{http://www.w3.org/2001/XMLSchema}string" default="-" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Advertising_Card")
public class AdvertisingCard
    extends Cards
{

    @XmlAttribute(name = "Advertise")
    protected String advertise;

    /**
     * Gets the value of the advertise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvertise() {
        if (advertise == null) {
            return "-";
        } else {
            return advertise;
        }
    }

    /**
     * Sets the value of the advertise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvertise(String value) {
        this.advertise = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvertisingCard)) return false;
        if (!super.equals(o)) return false;
        AdvertisingCard that = (AdvertisingCard) o;
        return Objects.equals(advertise, that.advertise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), advertise);
    }
}