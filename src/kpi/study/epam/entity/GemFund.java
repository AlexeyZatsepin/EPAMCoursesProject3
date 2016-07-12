
package kpi.study.epam.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for diamondFundType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="diamondFundType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gemstone" type="{}gemsone" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "gems")
@XmlType(name = "diamondFundType", propOrder = {
    "gemstone"
})
public class GemFund {

    @XmlElement(required = true)
    protected List<Gemstone> gemstone;

    /**
     * Gets the value of the gemstone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gemstone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGemstone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Gemstone }
     * 
     * 
     */
    public List<Gemstone> getGemstone() {
        if (gemstone == null) {
            gemstone = new ArrayList<>();
        }
        return this.gemstone;
    }

    public void setGemstone(List<Gemstone> gemstone) {
        this.gemstone = gemstone;
    }

    public void add(Gemstone gem){
        if (gemstone == null) {
            gemstone = new ArrayList<>();
        }
        gemstone.add(gem);
    }

    @Override
    public String toString() {
        return "GemFund{" +
                "gemstone=" + gemstone.toString() +
                '}';
    }
}
