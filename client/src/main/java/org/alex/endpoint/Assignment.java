
package org.alex.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assignment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fromId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignment", propOrder = {
    "fromId",
    "toId"
})
public class Assignment {

    protected String fromId;
    protected String toId;

    /**
     * Gets the value of the fromId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromId() {
        return fromId;
    }

    /**
     * Sets the value of the fromId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromId(String value) {
        this.fromId = value;
    }

    /**
     * Gets the value of the toId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToId() {
        return toId;
    }

    /**
     * Sets the value of the toId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToId(String value) {
        this.toId = value;
    }

}
