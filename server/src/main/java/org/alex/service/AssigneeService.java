package org.alex.service;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AssigneeService implements IAssigneeService {

    public AssigneeService() {

    }

    private final AssigneeRepository repository = new AssigneeRepository();

    public void createAssignee(@NotNull final Assignee assignee) {
        if (assignee == null) {
            return;
        } else {
            this.repository.add(assignee);
        }
    }

    @Override
    public Assignee getAssignee(@NotNull final String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            return this.repository.getAssigneeByUid(uid);
        }
    }

    public void setConnection(@NotNull final Connection connection) {
        repository.setConnection(connection);
    }

    @Override
    public Assignee getAssigneeByLogin(@NotNull final String login) {
        for (Assignee a : repository.getAll()) {
            if (login.equals(a.getLogin())) return a;
        } return null;
    }

    @Override
    public List<Assignee> getAllAssignee() {
        return repository.getAll();
    }

    @Override
    public void mergeAssignee(@NotNull final List<Assignee> assignees) {
        if (assignees == null) return;
        repository.merge(assignees);
    }

    @Override
    public void deleteAssignee(@NotNull final String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid == null) {
            throw new IllegalArgumentException();
        } else {
            this.repository.delete(uid);
        }
    }

    @Override
    public String getAssigneeAdminGroup() {
        String output = "";
        final List<Assignee> helperList = new ArrayList<>(repository.getAll());
        for (Assignee ass : helperList) {
            if ("administrators".equals(ass.getGroup().toLowerCase())) {
                output = output.concat(ass.getUid() + ";");
            }
        }
        return output;
    }

}
