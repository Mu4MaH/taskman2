package org.alex.service;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;

import java.util.List;

public class AssigneeService implements IAssigneeService {

    private final AssigneeRepository stuff = new AssigneeRepository();

    {
        Assignee admin = new Assignee();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setGroup("Administrators");
        admin.setName("Администратор");
        admin.setAdmin();
        stuff.addAssignee(admin);
    }

    public Assignee getAssigneeByUid(String uid) {
        return this.stuff.getAssigneeByUid(uid);
    }

    public void deleteAssignee(String uid) {
        this.stuff.deleteAssignee(uid);
    }

    public void addAssignee(Assignee assignee) {
        this.stuff.addAssignee(assignee);
    }

    public List<Assignee> getAllAssignee() {
        return this.stuff.getAllAssignees();
    }

}
