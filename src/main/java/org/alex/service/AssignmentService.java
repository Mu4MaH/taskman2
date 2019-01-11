package org.alex.service;

import org.alex.api.service.IAssignmentService;
import org.alex.entity.Assignment;
import org.alex.exception.IllegalStringException;
import org.alex.repository.AssignmentRepository;

import java.util.List;

public class AssignmentService implements IAssignmentService {

    AssignmentRepository assignmentRepository = new AssignmentRepository();

    @Override
    public void create(Assignment assignment) {
        if (assignment == null) {
            throw new NullPointerException();
        } else {
            assignmentRepository.create(assignment);
        }
    }

    @Override
    public void delete(String fromId, String toId) throws IllegalStringException {
        if (fromId.equals(null) || toId.equals(null)) {
            assignmentRepository.delete(fromId, toId);
        } else {
            return;
        }
    }

    @Override
    public List<Assignment> getAllById(String fromId) {
        if (fromId.equals(null) || fromId.isEmpty()) {
            return null;
        } else {
            return assignmentRepository.getAllById(fromId);
        }
    }

    @Override
    public void mergeAssignments(List<Assignment> assignments) {
        if (assignments == null) return;
        assignmentRepository.merge(assignments);
        }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.getAllAssignments();
    }

    @Override
    public void vacuum() {
        assignmentRepository.vacuum();
    }

}
