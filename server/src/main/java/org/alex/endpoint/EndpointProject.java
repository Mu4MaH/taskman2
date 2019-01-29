package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;
import org.alex.exception.IllegalArgumentException;
import org.alex.exception.IllegalStringException;
import org.alex.service.ProjectService;
import org.jetbrains.annotations.NotNull;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndpointProject{

    private ProjectService projectService;

    public EndpointProject() {
        Endpoint.publish("http://localhost:888/project", this);
    }

    public EndpointProject(Bootstrap bootstrap) {
        Endpoint.publish("http://localhost:888/project?wsdl", this);
        projectService = bootstrap.getProjectService();
    }

    @WebMethod
    public void createProject(@NotNull Project project) {
        if (project == null) return;
        projectService.createProject(project);
    }

    @WebMethod
    public Project getProject(@NotNull String uid) throws IllegalArgumentException, IllegalStringException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return (Project) projectService.getProject(uid);
        }
    }

    @WebMethod
    public void deleteProject(@NotNull String uid) throws IllegalArgumentException {
        //ничего не делает, удаление проектов не разрешено вообще.
    }

    @WebMethod
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @WebMethod
    public void mergeProject(@NotNull List<Project> list) {
        if (list.equals(null)) return;
        projectService.mergeProject(list);
    }

}


