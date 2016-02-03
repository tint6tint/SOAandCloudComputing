
package fi.jyu.it.ties456.week38.services.people;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PeopleRegistryService", targetNamespace = "http://week38.ties456.jyu.fi/", wsdlLocation = "http://ub1.ad.jyu.fi/people?wsdl")
public class PeopleRegistryService
    extends Service
{

    private final static URL PEOPLEREGISTRYSERVICE_WSDL_LOCATION;
    private final static WebServiceException PEOPLEREGISTRYSERVICE_EXCEPTION;
    private final static QName PEOPLEREGISTRYSERVICE_QNAME = new QName("http://week38.ties456.jyu.fi/", "PeopleRegistryService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://ub1.ad.jyu.fi/people?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PEOPLEREGISTRYSERVICE_WSDL_LOCATION = url;
        PEOPLEREGISTRYSERVICE_EXCEPTION = e;
    }

    public PeopleRegistryService() {
        super(__getWsdlLocation(), PEOPLEREGISTRYSERVICE_QNAME);
    }

    public PeopleRegistryService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PEOPLEREGISTRYSERVICE_QNAME, features);
    }

    public PeopleRegistryService(URL wsdlLocation) {
        super(wsdlLocation, PEOPLEREGISTRYSERVICE_QNAME);
    }

    public PeopleRegistryService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PEOPLEREGISTRYSERVICE_QNAME, features);
    }

    public PeopleRegistryService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PeopleRegistryService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PeopleRegistry
     */
    @WebEndpoint(name = "PeopleRegistryPort")
    public PeopleRegistry getPeopleRegistryPort() {
        return super.getPort(new QName("http://week38.ties456.jyu.fi/", "PeopleRegistryPort"), PeopleRegistry.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PeopleRegistry
     */
    @WebEndpoint(name = "PeopleRegistryPort")
    public PeopleRegistry getPeopleRegistryPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://week38.ties456.jyu.fi/", "PeopleRegistryPort"), PeopleRegistry.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PEOPLEREGISTRYSERVICE_EXCEPTION!= null) {
            throw PEOPLEREGISTRYSERVICE_EXCEPTION;
        }
        return PEOPLEREGISTRYSERVICE_WSDL_LOCATION;
    }

}
