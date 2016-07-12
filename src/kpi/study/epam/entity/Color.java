package kpi.study.epam.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for color.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="color">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RED"/>
 *     &lt;enumeration value="BLUE"/>
 *     &lt;enumeration value="GREEN"/>
 *     &lt;enumeration value="BLACK"/>
 *     &lt;enumeration value="ORANGE"/>
 *     &lt;enumeration value="WHITE"/>
 *     &lt;enumeration value="YELLOW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "color")
@XmlEnum
public enum Color {

    RED,
    BLUE,
    GREEN,
    BLACK,
    ORANGE,
    WHITE,
    YELLOW;

}
