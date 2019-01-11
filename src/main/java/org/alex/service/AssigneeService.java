package org.alex.service;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;

import java.util.ArrayList;
import java.util.List;

public class AssigneeService implements IAssigneeService {

    private final AssigneeRepository assigneeRepository = new AssigneeRepository();

    {
        Assignee admin = new Assignee();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setGroup("Administrators");
        admin.setName("Администратор");
        admin.setAdmin();
        assigneeRepository.addAssignee(admin);

        Assignee odmen = new Assignee();
        odmen.setLogin("odmen");
        odmen.setPassword("odmen");
        odmen.setGroup("Administrators");
        odmen.setName("Одмен");
        odmen.setAdmin();
        assigneeRepository.addAssignee(odmen);

        assigneeRepository.addAssignee(new Assignee("manager", "manager", "manager", "managers", false));
        assigneeRepository.addAssignee(new Assignee("aaa", "aaa", "aaa", "users", false));
        assigneeRepository.addAssignee(new Assignee("bbb", "bb", "bbb", "users", false));
    }

    @Override
    public Assignee getAssigneeByUid(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            return this.assigneeRepository.getAssigneeByUid(uid);
        }
    }

    @Override
    public void deleteAssignee(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            this.assigneeRepository.deleteAssignee(uid);
        }
    }

    @Override
    public void addAssignee(Assignee assignee) {
        if (assignee == null) {
            return;
        } else {
            this.assigneeRepository.addAssignee(assignee);
        }
    }

    @Override
    public List<Assignee> getAllAssignee() {
        return this.assigneeRepository.getAllAssignees();
    }

    @Override
    public String getAdminGroup() {
        String output = "";
        List<Assignee> helperList = new ArrayList<>(assigneeRepository.getAllAssignees());
        for (Assignee ass : helperList) {
            if ("administrators".equals(ass.getGroup().toLowerCase())) {
                output = output.concat(ass.getUid() + ";");
            }
        }
        return output;
    }

    @Override
    public void mergeAssignee(List<Assignee> assignees) {
        if (assignees == null) return;
        assigneeRepository.merge(assignees);
    }

}
