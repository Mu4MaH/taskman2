package org.alex.service;

import org.alex.api.service.IWorkerService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;

import java.util.List;

public class AssigneeService implements IWorkerService {
    private final AssigneeRepository stuff = new AssigneeRepository();

    public Assignee getAssigneeByUid(String uid) {
        return stuff.getAssigneeByUid(uid);
    }

    public void deleteAssignee(String uid) {
        stuff.deleteAssignee(uid);
    }

    public void addAssignee(Assignee assignee) {
        stuff.addAssignee(assignee);
    }

    public List<Assignee> getAllAssignee() {
        return stuff.getAllAssignees();
    }

}
