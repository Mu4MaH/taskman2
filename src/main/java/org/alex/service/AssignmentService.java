package org.alex.service;

import org.alex.api.service.IAssignmentService;
import org.alex.entity.Assignment;
import org.alex.repository.AssignmentRepository;

import java.util.List;

public class AssignmentService implements IAssignmentService {

    AssignmentRepository assignmentRepository = new AssignmentRepository();

    @Override
    public void create(Assignment assignment) {
        assignmentRepository.create(assignment);
    }

    @Override
    public void delete(String fromId, String toId) {
        assignmentRepository.delete(fromId, toId);
    }

    @Override
    public List<Assignment> getAllById(String fromId) {
        return assignmentRepository.getAllById(fromId);
    }

    @Override
    public void merge(List<Assignment> assignments) {
        assignmentRepository.merge(assignments);
    }

    @Override
    public void vacuum() {
        assignmentRepository.vacuum();
    }

}
