//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.11.23 at 08:00:11 AM CET 
//


package generisano;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for tipGoriva.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="tipGoriva"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="fuel"/&gt;
 *     &lt;enumeration value="hybrid"/&gt;
 *     &lt;enumeration value="electric"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipGoriva")
@XmlEnum
public enum TipGoriva {

    @XmlEnumValue("fuel")
    FUEL("fuel"),
    @XmlEnumValue("hybrid")
    HYBRID("hybrid"),
    @XmlEnumValue("electric")
    ELECTRIC("electric");
    private final String value;

    TipGoriva(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipGoriva fromValue(String v) {
        for (TipGoriva c: TipGoriva.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
