
package kpi.study.epam.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
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

    private final static QName _Gems_QNAME = new QName("", "gems");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GemFund }
     * 
     */
    public GemFund createDiamondFundType() {
        return new GemFund();
    }

    /**
     * Create an instance of {@link Gemstone }
     * 
     */
    public Gemstone createGemsone() {
        return new Gemstone();
    }

    /**
     * Create an instance of {@link VisualParameters }
     * 
     */
    public VisualParameters createVisualParameters() {
        return new VisualParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GemFund }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "gems")
    public JAXBElement<GemFund> createGems(GemFund value) {
        return new JAXBElement<GemFund>(_Gems_QNAME, GemFund.class, null, value);
    }

}
