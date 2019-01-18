package org.alex.service;

import org.alex.api.service.IAssignmentService;
import org.alex.entity.Assignment;
import org.alex.exception.IllegalStringException;
import org.alex.repository.AssignmentRepository;

import java.util.List;

public class AssignmentService implements IAssignmentService {

    AssignmentRepository repository = new AssignmentRepository();

    @Override
    public void create(Assignment assignment) {
        if (assignment == null) {
            throw new NullPointerException();
        } else {
            repository.add(assignment);
        }
    }

    @Override
    public List<Assignment> get(String fromId) {
        if (fromId.equals(null) || fromId.isEmpty()) {
            return null;
        } else {
            return repository.getAllById(fromId);
        }
    }

    @Override
    public List<Assignment> getAll() {
        return repository.getAll();
    }

    @Override
    public void merge(List<Assignment> assignments) {
        if (assignments == null) return;
        repository.merge(assignments);
    }

    @Override
    public void del(String fromId, String toId) throws IllegalStringException {
        if (fromId.equals(null) || toId.equals(null)) {
            repository.delete(fromId, toId);
        } else {
            return;
        }
    }

    @Override
    public void vacuum() {
        repository.vacuum();
    }

}
