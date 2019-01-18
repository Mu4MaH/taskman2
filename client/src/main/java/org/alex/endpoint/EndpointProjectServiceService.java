package org.alex.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-18T12:39:46.133+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "EndpointProjectServiceService",
                  wsdlLocation = "http://localhost:888/project?wsdl",
                  targetNamespace = "http://endpoint.alex.org/")
public class EndpointProjectServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.alex.org/", "EndpointProjectServiceService");
    public final static QName EndpointProjectServicePort = new QName("http://endpoint.alex.org/", "EndpointProjectServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:888/project?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndpointProjectServiceService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:888/project?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndpointProjectServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndpointProjectServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndpointProjectServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EndpointProjectServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EndpointProjectServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EndpointProjectServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns EndpointProjectService
     */
    @WebEndpoint(name = "EndpointProjectServicePort")
    public EndpointProjectService getEndpointProjectServicePort() {
        return super.getPort(EndpointProjectServicePort, EndpointProjectService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndpointProjectService
     */
    @WebEndpoint(name = "EndpointProjectServicePort")
    public EndpointProjectService getEndpointProjectServicePort(WebServiceFeature... features) {
        return super.getPort(EndpointProjectServicePort, EndpointProjectService.class, features);
    }

}
