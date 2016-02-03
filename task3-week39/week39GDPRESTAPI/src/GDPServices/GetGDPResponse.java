
package GDPServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getGDPResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getGDPResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GDP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGDPResponse", propOrder = {
    "gdp"
})
public class GetGDPResponse {

    @XmlElement(name = "GDP")
    protected Double gdp;

    /**
     * Obtiene el valor de la propiedad gdp.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGDP() {
        return gdp;
    }

    /**
     * Define el valor de la propiedad gdp.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGDP(Double value) {
        this.gdp = value;
    }

}
