package org.alex.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-18T12:39:44.848+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.alex.org/", name = "EndpointAssignmentService")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointAssignmentService {

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointAssignmentService/delRequest", output = "http://endpoint.alex.org/EndpointAssignmentService/delResponse", fault = {@FaultAction(className = IllegalStringException_Exception.class, value = "http://endpoint.alex.org/EndpointAssignmentService/del/Fault/IllegalStringException")})
    @RequestWrapper(localName = "del", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.Del")
    @ResponseWrapper(localName = "delResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.DelResponse")
    public void del(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IllegalStringException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointAssignmentService/createRequest", output = "http://endpoint.alex.org/EndpointAssignmentService/createResponse")
    @RequestWrapper(localName = "create", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.CreateResponse")
    public void create(
        @WebParam(name = "arg0", targetNamespace = "")
        org.alex.endpoint.Task arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointAssignmentService/getAllRequest", output = "http://endpoint.alex.org/EndpointAssignmentService/getAllResponse")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<org.alex.endpoint.Task> getAll();

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointAssignmentService/getRequest", output = "http://endpoint.alex.org/EndpointAssignmentService/getResponse")
    @RequestWrapper(localName = "get", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetResponse")
    @WebResult(name = "return", targetNamespace = "")
    public org.alex.endpoint.Task get(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointAssignmentService/mergeRequest", output = "http://endpoint.alex.org/EndpointAssignmentService/mergeResponse")
    @RequestWrapper(localName = "merge", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.Merge")
    @ResponseWrapper(localName = "mergeResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.MergeResponse")
    public void merge(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<org.alex.endpoint.Task> arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointAssignmentService/vacuumRequest", output = "http://endpoint.alex.org/EndpointAssignmentService/vacuumResponse")
    @RequestWrapper(localName = "vacuum", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.Vacuum")
    @ResponseWrapper(localName = "vacuumResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.VacuumResponse")
    public void vacuum();
}
