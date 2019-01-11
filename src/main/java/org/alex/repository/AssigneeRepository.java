package org.alex.repository;

import org.alex.entity.Assignee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssigneeRepository {

    private final Map<String, Assignee> stuff = new HashMap<>();

    public void addAssignee(Assignee assignee) {
        stuff.put(assignee.getUid(), assignee);
    }

    public Assignee getAssigneeByUid(String uid) {
        return stuff.get(uid);
    }

    public void deleteAssignee(String uid) {
        stuff.remove(uid);
    }

    public List<Assignee> getAllAssignees() {
        return new ArrayList<Assignee>(stuff.values());
    }

    public void merge(final List<Assignee> assignees) {
        for (Assignee assignee : assignees) {
            stuff.put(assignee.getUid(),assignee);
        }
    }

}


