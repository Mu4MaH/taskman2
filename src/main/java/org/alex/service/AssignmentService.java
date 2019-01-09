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
        if (fromId != null && toId != null) {
            assignmentRepository.delete(fromId, toId);
        } else {
            throw new IllegalStringException();
        }
    }

    @Override
    public List<Assignment> getAllById(String fromId) {
        if (fromId == null || fromId == "") {
            throw new NullPointerException();
        } else {
            return assignmentRepository.getAllById(fromId);
        }
    }

    @Override
    public void merge(List<Assignment> assignments) {
        if (assignments == null) {
            throw new NullPointerException();
        } else {
            assignmentRepository.merge(assignments);
        }
    }

    @Override
    public void vacuum() {
        assignmentRepository.vacuum();
    }

}
