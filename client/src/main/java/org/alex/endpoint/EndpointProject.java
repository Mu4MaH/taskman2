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
 * 2019-01-22T14:39:45.640+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.alex.org/", name = "EndpointProject")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointProject {

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointProject/createProjectRequest", output = "http://endpoint.alex.org/EndpointProject/createProjectResponse")
    @RequestWrapper(localName = "createProject", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.CreateProjectResponse")
    public void createProject(
        @WebParam(name = "arg0", targetNamespace = "")
        org.alex.endpoint.Project arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointProject/mergeProjectRequest", output = "http://endpoint.alex.org/EndpointProject/mergeProjectResponse")
    @RequestWrapper(localName = "mergeProject", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.MergeProject")
    @ResponseWrapper(localName = "mergeProjectResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.MergeProjectResponse")
    public void mergeProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<org.alex.endpoint.Project> arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointProject/getProjectRequest", output = "http://endpoint.alex.org/EndpointProject/getProjectResponse", fault = {@FaultAction(className = IllegalArgumentException_Exception.class, value = "http://endpoint.alex.org/EndpointProject/getProject/Fault/IllegalArgumentException"), @FaultAction(className = IllegalStringException_Exception.class, value = "http://endpoint.alex.org/EndpointProject/getProject/Fault/IllegalStringException")})
    @RequestWrapper(localName = "getProject", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetProject")
    @ResponseWrapper(localName = "getProjectResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public org.alex.endpoint.Project getProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws IllegalArgumentException_Exception, IllegalStringException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointProject/getAllProjectRequest", output = "http://endpoint.alex.org/EndpointProject/getAllProjectResponse")
    @RequestWrapper(localName = "getAllProject", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetAllProject")
    @ResponseWrapper(localName = "getAllProjectResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.GetAllProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<org.alex.endpoint.Project> getAllProject();

    @WebMethod
    @Action(input = "http://endpoint.alex.org/EndpointProject/deleteProjectRequest", output = "http://endpoint.alex.org/EndpointProject/deleteProjectResponse", fault = {@FaultAction(className = IllegalArgumentException_Exception.class, value = "http://endpoint.alex.org/EndpointProject/deleteProject/Fault/IllegalArgumentException")})
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://endpoint.alex.org/", className = "org.alex.endpoint.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws IllegalArgumentException_Exception;
}
