
package kpi.study.epam.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for visualParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="visualParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="color" type="{}color"/>
 *         &lt;element name="transparency">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="verges">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="4"/>
 *               &lt;maxInclusive value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visualParameters", propOrder = {
    "color",
    "transparency",
    "verges"
})
public class VisualParameters {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Color color;
    protected float transparency;
    protected int verges;

    public VisualParameters() {
    }

    public VisualParameters(Color color, float transparency, int verges) {
        this.color = color;
        this.transparency = transparency;
        this.verges = verges;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setColor(Color value) {
        this.color = value;
    }

    /**
     * Gets the value of the transparency property.
     * 
     */
    public float getTransparency() {
        return transparency;
    }

    /**
     * Sets the value of the transparency property.
     * 
     */
    public void setTransparency(float value) {
        this.transparency = value;
    }

    /**
     * Gets the value of the verges property.
     * 
     */
    public int getVerges() {
        return verges;
    }

    /**
     * Sets the value of the verges property.
     * 
     */
    public void setVerges(int value) {
        this.verges = value;
    }

}
