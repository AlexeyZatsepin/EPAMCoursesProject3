
package kpi.study.epam.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preciosnessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="preciosnessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PRECIOUS"/>
 *     &lt;enumeration value="SEMIPRECIOUS"/>
 *     &lt;enumeration value="COMMON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "preciosnessType")
@XmlEnum
public enum Preciosness {

    PRECIOUS,
    SEMIPRECIOUS,
    COMMON;

}
