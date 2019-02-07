package org.alex.repository;

import org.alex.entity.Assignment;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ProjectAssigneeAssgnmt implements org.alex.api.service.IAssignment {

    private Connection connection;

    @Override
    public void setConnection(@NotNull Connection connection) {
        this.connection = connection;
    }

    public ProjectAssigneeAssgnmt() {
    }

    @Override
    public void add(@NotNull final Assignment assignment) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("INSERT INTO projectassignee VALUES (? ,?)");
        ps.setString(1, assignment.getAssignmentId());
        ps.setString(2, assignment.getAssigningId());
        ps.execute();
    }

    @Override
    public void delete(@NotNull final Assignment assignment) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("DELETE FROM projectassignee WHERE projectid = ? AND assigneeid = ?");
        ps.setString(1, assignment.getAssignmentId());
        ps.setString(2, assignment.getAssigningId());
        ps.execute();
    }

    @Override
    public List<String> getAssignedFromAssignment(@NotNull final String assignmentId) {
        final List<String> output = new ArrayList<>();
        try {
            final PreparedStatement ps = connection.prepareStatement("SELECT assigneeid FROM projectassignee WHERE projectid = ?");
            ps.setString(1, assignmentId);
            final ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                output.add(rs.getString("assigneeid"));
            }
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getAssignmentFromAssigned(@NotNull final String assignedId) throws SQLException {
        final List<java.lang.String> output = new ArrayList<>();
        final PreparedStatement ps = connection.prepareStatement("SELECT projectid FROM projectassignee WHERE assigneeid = ?");
        ps.setString(1, assignedId);
        final ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            output.add(rs.getString("projectid"));
        }
        return output;
    }

    @Override
    public void merge(@NotNull final List<Assignment> assignments) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("DELETE FROM projectassignee");
        ps.execute();
        for (Assignment ass : assignments) {
            add(ass);
        }
    }

    @Override
    public List<Assignment> getAll() {
        try {
            final List<Assignment> result = new ArrayList<>();
            final PreparedStatement ps;
            final ResultSet rs;
            ps = connection.prepareStatement("SELECT * FROM projectassignee");
            rs = ps.executeQuery();
            while (rs.next()) {
                final Assignment ass = new Assignment();
                ass.setAssigningId(rs.getString("assigneeid"));
                ass.setAssignmentId(rs.getString("projectid"));
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
