package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Project;
import org.alex.service.ProjectService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        projectService.createProject(project);
    }

    @WebMethod
    @Nullable public Project getProject(@NotNull String uid){
        if (uid.isEmpty()) {
            return null;
        } else {
            return (Project) projectService.getProject(uid);
        }
    }

    @WebMethod
    public void deleteProject(@NotNull String uid) {
        //ничего не делает, удаление проектов не разрешено вообще.
    }

    @WebMethod
    @Nullable public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @WebMethod
    public void mergeProject(@NotNull List<Project> list) {
        projectService.mergeProject(list);
    }

}


