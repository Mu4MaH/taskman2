package org.alex.service;

import org.alex.api.service.IAssigneeService;
import org.alex.entity.Assignee;
import org.alex.repository.AssigneeRepository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class AssigneeService implements IAssigneeService {

    public AssigneeService() {}

    @Inject
    private AssigneeRepository repository;

    public Assignee createAssignee(@NotNull final Assignee assignee) {
        final List<Assignee> assignees = repository.findAll();
        for (int i = 0; i < repository.findAll().size(); i++) {
            if (assignee.getLogin().equals(assignees.get(i).getLogin())) {
                System.out.println("DEBUG ass.add: ЕСТЬ ТАКАЯ БУКВА!!!");
                return null;
            }
        }
        repository.save(assignee);
        return assignee;
    }


    @Override
    public Assignee getAssignee(@NotNull final String uid) {
        return this.repository.findBy(uid);
    }

    @Override
    public Assignee getAssigneeByLogin(@NotNull final String login) {
        for (Assignee a : repository.findAll()) {
            if (login.equals(a.getLogin())) return a;
        }
        return null;
    }

    @Override
    public List<Assignee> getAllAssignee() {
        return repository.findAll();
    }

    @Override
    public void mergeAssignee(@NotNull final List<Assignee> assignees) {
        final List<Assignee> helperList = repository.findAll();
        for (Assignee a: helperList) {
            repository.remove(a);
        }
        for (Assignee a: assignees) {
            repository.save(a);
        }
    }

    @Override
    public void deleteAssignee(@NotNull final String uid) {
        final Assignee a = repository.findBy(uid);
        repository.remove(a);
    }

    @Override
    @NotNull
    public String getAssigneeAdminGroup() {
        String output = "";
        @NotNull final List<Assignee> helperList = new ArrayList<>(repository.findAll());
        for (Assignee ass : helperList) {
            if ("administrators".equals(ass.getGroup().toLowerCase())) {
                output = output.concat(ass.getUid() + ";");
            }
        }
        return output;
    }

}
