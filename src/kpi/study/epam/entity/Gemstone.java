
package kpi.study.epam.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;


/**
 * <p>Java class for gemsone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gemsone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[a-zA-Z ]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="preciosness" type="{}preciosnessType"/>
 *         &lt;element name="origin">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[a-zA-Z ]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="visualParameters" type="{}visualParameters"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gemsone", propOrder = {
    "name",
    "preciosness",
    "origin",
    "visualParameters",
    "value"
})
public class Gemstone {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Preciosness preciosness;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(required = true)
    protected VisualParameters visualParameters;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger value;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public Gemstone(){}
    public Gemstone(String name, Preciosness preciosness, String origin, VisualParameters visualParameters, BigInteger value, String id) {
        this.name = name;
        this.preciosness = preciosness;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.value = value;
        this.id = id;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the preciosness property.
     * 
     * @return
     *     possible object is
     *     {@link Preciosness }
     *     
     */
    public Preciosness getPreciosness() {
        return preciosness;
    }

    /**
     * Sets the value of the preciosness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Preciosness }
     *     
     */
    public void setPreciosness(Preciosness value) {
        this.preciosness = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the visualParameters property.
     * 
     * @return
     *     possible object is
     *     {@link VisualParameters }
     *     
     */
    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    /**
     * Sets the value of the visualParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualParameters }
     *     
     */
    public void setVisualParameters(VisualParameters value) {
        this.visualParameters = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    @Override
    public String toString() {
        return "Gemstone{" +
                "name='" + name + '\'' +
                ", preciosness=" + preciosness +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                ", id='" + id + '\'' +
                '}';
    }
}
