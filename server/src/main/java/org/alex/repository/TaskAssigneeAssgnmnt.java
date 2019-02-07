package org.alex.repository;

import org.alex.api.service.IAssignment;
import org.alex.entity.Assignment;
import org.alex.entity.Task;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TaskAssigneeAssgnmnt implements IAssignment {

    private Connection connection;

    public void setConnection(@NotNull Connection connection) {
        this.connection = connection;
    }

    public TaskAssigneeAssgnmnt() {
    }

    @Override
    public void add(@NotNull final Assignment assignment) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("INSERT INTO taskassignee VALUES (? ,?)");
        ps.setString(1, assignment.getAssignmentId());
        ps.setString(2, assignment.getAssigningId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(final Assignment assignment) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("DELETE FROM taskassignee WHERE taskid = ? AND assigneeid = ?");
        ps.setString(1, assignment.getAssignmentId());
        ps.setString(2, assignment.getAssigningId());
        ps.execute();
        ps.close();
    }

    @Override
    public List<String> getAssignedFromAssignment(@NotNull final String taskId) {
        final List<String> output = new ArrayList<>();
        try {
            final PreparedStatement ps = connection.prepareStatement("SELECT assigneeid FROM taskassignee WHERE taskid = ?");
            ps.setString(1, taskId);
            final ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                final Task task = new Task();
                output.add(rs.getString("assigneeid"));
            }
            ps.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getAssignmentFromAssigned(@NotNull final String assignedId) {
        final List<String> output = new ArrayList<>();
        try {
            final PreparedStatement ps = connection.prepareStatement("SELECT taskid FROM taskassignee WHERE assigneeid = ?");
            ps.setString(1, assignedId);
            final ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                final Task task = new Task();
                output.add(rs.getString("taskid"));
            }
            ps.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void merge(@NotNull final List<Assignment> assignments) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("DELETE FROM taskassignee");
        ps.execute();
        for (Assignment ass : assignments) {
            add(ass);
        }
        ps.close();
    }

    @Override
    public List<Assignment> getAll() {
        try {
            final List<Assignment> result = new ArrayList<>();
            final PreparedStatement ps;
            final ResultSet rs;
            ps = connection.prepareStatement("SELECT * FROM taskassignee");
            rs = ps.executeQuery();
            while (rs.next()) {
                final Assignment ass = new Assignment();
                ass.setAssigningId(rs.getString("assigneeid"));
                ass.setAssignmentId(rs.getString("taskid"));
                result.add(ass);
            }
            ps.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
