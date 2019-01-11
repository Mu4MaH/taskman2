package org.alex.repository;

import org.alex.api.repository.IAssignmentRepository;
import org.alex.entity.Assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AssignmentRepository implements IAssignmentRepository {

    private final List<Assignment> assignments = new LinkedList<>();

    @Override
    public boolean create(Assignment assignment) {
        return this.assignments.add(assignment);
    }

    @Override
    public boolean delete(final String fromId, final String toId) {
        final ListIterator<Assignment> listIterator = this.assignments.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getFromId() == fromId && listIterator.next().getToId() == toId) {
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Assignment> getAllById(final String fromId) {
        final List<Assignment> output = new LinkedList<>();
        for (Assignment assignment : this.assignments) {
            if (assignment.getFromId() == fromId) output.add(assignment);
        }
        return output;
    }

    @Override
    public boolean merge(List<Assignment> assignments) {
        this.assignments.clear();
        return this.assignments.addAll(assignments);
    }

    @Override
    public void vacuum() {
//TODO: пробег по листу и удаление записей с ничейными айдишниками и дублей. Сделать метод проверки айдишника на хозяина
    }

    public List<Assignment> getAllAssignments() {
        return new ArrayList<>(assignments);
    }

}
