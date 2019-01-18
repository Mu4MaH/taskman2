package org.alex.service;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;

import java.util.ArrayList;
import java.util.List;

public class AssigneeService implements IAssigneeService {

    private final AssigneeRepository repository = new AssigneeRepository();

    {
        Assignee admin = new Assignee();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setGroup("Administrators");
        admin.setName("Администратор");
        admin.setAdmin();
        repository.add(admin);

        Assignee odmen = new Assignee();
        odmen.setLogin("odmen");
        odmen.setPassword("odmen");
        odmen.setGroup("Administrators");
        odmen.setName("Одмен");
        odmen.setAdmin();
        repository.add(odmen);

        repository.add(new Assignee("manager", "manager", "manager", "managers", false));
        repository.add(new Assignee("aaa", "aaa", "aaa", "users", false));
        repository.add(new Assignee("bbb", "bb", "bbb", "users", false));
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
