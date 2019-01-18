package org.alex.repository;

import org.alex.api.repository.IAssignmentRepository;
import org.alex.entity.Assignment;

import java.util.*;

public class AssignmentRepository implements IAssignmentRepository {

    private final List<Assignment> assignments = new LinkedList<>();

    @Override
    public void add(Assignment assignment) {
        this.assignments.add(assignment);
    }

    @Override
    public Collection<Assignment> get() {
        return new LinkedList<>(assignments);
    }

    @Override
    public void delete(final String fromId, final String toId) {
        final ListIterator<Assignment> listIterator = this.assignments.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getFromId() == fromId && listIterator.next().getToId() == toId) {
                listIterator.remove();
                return;
            }
        }
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
    public void merge(final List<Assignment> assignments) {
        this.assignments.clear();
    }

    @Override
    public void vacuum() {
//TODO: пробег по листу и удаление записей с ничейными айдишниками и дублей. Сделать метод проверки айдишника на хозяина
    }

    public List<Assignment> getAll() {
        return new ArrayList<>(assignments);
    }

}
