
package fi.jyu.it.ties456.week38.services.people;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PeopleRegistry", targetNamespace = "http://week38.ties456.jyu.fi/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PeopleRegistry {


    /**
     * 
     * @param searchString
     * @return
     *     returns java.util.List<fi.jyu.it.ties456.week38.services.people.PersonInfoType>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchForPerson", targetNamespace = "http://week38.ties456.jyu.fi/", className = "fi.jyu.it.ties456.week38.services.people.SearchForPerson")
    @ResponseWrapper(localName = "searchForPersonResponse", targetNamespace = "http://week38.ties456.jyu.fi/", className = "fi.jyu.it.ties456.week38.services.people.SearchForPersonResponse")
    public List<PersonInfoType> searchForPerson(
        @WebParam(name = "searchString", targetNamespace = "")
        String searchString);

}
