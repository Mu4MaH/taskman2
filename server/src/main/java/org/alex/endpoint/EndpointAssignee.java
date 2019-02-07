package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.jetbrains.annotations.NotNull;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class EndpointAssignee{

    Bootstrap bootstrap;

    public EndpointAssignee() {
        Endpoint.publish("http://localhost:888/assignee?wsdl", this);
    }

    public EndpointAssignee(@NotNull Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
        Endpoint.publish("http://localhost:888/assignee?wsdl", this);
    }

    @WebMethod
    public Assignee createAssignee(@NotNull Assignee assignee) {
            return bootstrap.getAssigneeService().createAssignee(assignee);
    }

    @WebMethod
    public Assignee getAssigneeByLogin(@NotNull String login) {
        for (Assignee a : bootstrap.getAssigneeService().getAllAssignee()) {
            if (login.equals(a.getLogin())) return a;
        } return null;
    }

    @WebMethod
    @NotNull public Assignee getAssignee(@NotNull String uid){
            return bootstrap.getAssigneeService().getAssignee(uid);
        }


    @WebMethod
    @NotNull public List<Assignee> getAllAssignee() {
        return bootstrap.getAssigneeService().getAllAssignee();
    }

    @WebMethod
    public void mergeAssignee(@NotNull List<Assignee> assignees) {
        bootstrap.getAssigneeService().mergeAssignee(assignees);
    }

    @WebMethod
    public void deleteAssignee(@NotNull String uid){
            bootstrap.getAssigneeService().deleteAssignee(uid);
    }

    @WebMethod
    @NotNull public String getAdminGroup() {
        String output = "";
        final List<Assignee> helperList = new ArrayList<>(bootstrap.getAssigneeService().getAllAssignee());
        for (Assignee ass : helperList) {
            if ("administrators".equals(ass.getGroup().toLowerCase())) {
                output = output.concat(ass.getUid() + ";");
            }
        }
        return output;
    }

}
