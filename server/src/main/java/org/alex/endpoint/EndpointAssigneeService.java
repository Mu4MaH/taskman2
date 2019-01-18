package org.alex.endpoint;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class EndpointAssigneeService implements IAssigneeService {

    private final AssigneeRepository repository = new AssigneeRepository();

    public EndpointAssigneeService() {
//        Endpoint.publish("http://localhost:888/assignee", this);
    }

    @Override
    public void create(Assignee assignee) {
        if (assignee == null) {
            return;
        } else {
            this.repository.add(assignee);
        }
    }

    @Override
    public Assignee get(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            return this.repository.getAssigneeByUid(uid);
        }
    }

    @Override
    public List<Assignee> getAll() {
        return this.repository.getAll();
    }

    @Override
    public void merge(List<Assignee> assignees) {
        if (assignees == null) return;
        repository.merge(assignees);
    }

    @Override
    public void delete(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            this.repository.delete(uid);
        }
    }

    @Override
    public String getAdminGroup() {
        String output = "";
        List<Assignee> helperList = new ArrayList<>(repository.getAll());
        for (Assignee ass : helperList) {
            if ("administrators".equals(ass.getGroup().toLowerCase())) {
                output = output.concat(ass.getUid() + ";");
            }
        }
        return output;
    }

}
