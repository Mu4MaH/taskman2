package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.exception.IllegalStringException;
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
    public void createAssignee(@NotNull Assignee assignee) {
        if (assignee == null) {
            return;
        } else {
            bootstrap.getAssigneeService().createAssignee(assignee);
        }
    }

    @WebMethod
    public Assignee getAssigneeByLogin(@NotNull String login) {
        for (Assignee a : bootstrap.getAssigneeService().getAllAssignee()) {
            if (login.equals(a.getLogin())) return a;
        } return null;
    }

    @WebMethod
    public Assignee getAssignee(@NotNull String uid) throws IllegalArgumentException, IllegalStringException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            return bootstrap.getAssigneeService().getAssignee(uid);
        }
    }

    @WebMethod
    public List<Assignee> getAllAssignee() {
        return bootstrap.getAssigneeService().getAllAssignee();
    }

    @WebMethod
    public void mergeAssignee(@NotNull List<Assignee> assignees) {
        if (assignees == null) return;
        bootstrap.getAssigneeService().mergeAssignee(assignees);
    }

    @WebMethod
    public void deleteAssignee(@NotNull String uid) throws IllegalArgumentException, IllegalStringException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            bootstrap.getAssigneeService().deleteAssignee(uid);
        }
    }

    @WebMethod
    public String getAdminGroup() {
        String output = "";
        List<Assignee> helperList = new ArrayList<>(bootstrap.getAssigneeService().getAllAssignee());
        for (Assignee ass : helperList) {
            if ("administrators".equals(ass.getGroup().toLowerCase())) {
                output = output.concat(ass.getUid() + ";");
            }
        }
        return output;
    }

}
