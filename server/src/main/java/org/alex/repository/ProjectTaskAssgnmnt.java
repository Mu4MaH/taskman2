package org.alex.repository;

import org.alex.api.service.IAssignment;
import org.alex.entity.Assignment;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProjectTaskAssgnmnt implements IAssignment {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ProjectTaskAssgnmnt() {
    }

    @Override
    public void add(@NotNull final Assignment assignment) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("INSERT INTO projecttask VALUES (? ,?)");
        ps.setString(1, assignment.getAssignmentId());
        ps.setString(2, assignment.getAssigningId());
        ps.execute();
    }

    @Override
    public void delete(@NotNull final Assignment assignment) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("DELETE FROM projecttask WHERE projectid = ? AND taskid = ?");
        ps.setString(1, assignment.getAssignmentId());
        ps.setString(2, assignment.getAssigningId());
        ps.execute();
    }

    @Override
    public List<String> getAssignmentFromAssigned(@NotNull String assignedId) throws SQLException {
        final List<String> output = new ArrayList<>();
        final PreparedStatement ps = connection.prepareStatement("SELECT projectid FROM projecttask WHERE taskid = ?");
        ps.setString(1, assignedId);
        final ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            output.add(rs.getString("projectid"));
        }
        return output;
    }

    @Override
    public List<String> getAssignedFromAssignment(@NotNull final String assignmentId) {
        final List<String> output = new ArrayList<>();
        try {
            final PreparedStatement ps = connection.prepareStatement("SELECT taskid FROM projecttask WHERE projectid = ?");
            ps.setString(1, assignmentId);
            final ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                output.add(rs.getString("taskid"));
            }
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void merge(@NotNull final List<Assignment> assignments) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement("DELETE FROM projecttask");
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
            ps = connection.prepareStatement("SELECT * FROM projecttask");
            rs = ps.executeQuery();
            while (rs.next()) {
                final Assignment ass = new Assignment();
                ass.setAssigningId(rs.getString("taskid"));
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
