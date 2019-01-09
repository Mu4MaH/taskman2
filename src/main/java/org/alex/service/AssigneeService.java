package org.alex.service;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.exception.IllegalStringException;
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

    public Assignee getAssigneeByUid(String uid) throws IllegalStringException {
        if (uid != "" && uid != null) {
            return this.stuff.getAssigneeByUid(uid);
        } else {
            throw new IllegalStringException();
        }
    }

    public void deleteAssignee(String uid) throws IllegalStringException {
        if (uid != "" && uid != null) {
            this.stuff.deleteAssignee(uid);
        } else {
            throw new IllegalStringException();
        }
    }

    public void addAssignee(Assignee assignee) {
        if (assignee == null) {
            throw new NullPointerException();
        } else {
            this.stuff.addAssignee(assignee);
        }
    }

    public List<Assignee> getAllAssignee() {
        return this.stuff.getAllAssignees();
    }

}
