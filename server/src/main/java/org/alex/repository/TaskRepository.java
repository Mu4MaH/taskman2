package org.alex.repository;

import org.alex.api.repository.ITaskRepository;
import org.alex.entity.Task;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements ITaskRepository {

    private Connection connection;

    public void setConnection(@NotNull Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(@NotNull final Task task) {
        try {
            final PreparedStatement ps = connection.prepareStatement("INSERT INTO task VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, task.getUid());
            ps.setString(2, task.getName());
            ps.setInt(3, task.getHours());
            ps.setString(4, String.valueOf(task.getState()));
            ps.setString(5, String.valueOf(task.getPriority()));
            ps.setString(6, task.getOwnerId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    public Task get(@NotNull final String uid) {
        try {
            Task task = new Task();
            final ResultSet rs;
            final PreparedStatement ps = connection.prepareStatement("SELECT uid, name, hours, state, priority, ownerid FROM task WHERE uid = ?");
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                task.setUid(rs.getString("uid"));
                task.setName(rs.getString("name"));
                task.setHours(rs.getInt("hours"));
                task.setState(rs.getString("state"));
                task.setPriority(rs.getString("priority"));
                task.setOwnerId(rs.getString("ownerid"));
            }
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateTask(@NotNull final String uid, Task task) {
        try {
            final ResultSet rs;
            final PreparedStatement ps = connection.prepareStatement("UPDATE task SET name = ?, hours = ?, state = ?, priority = ? WHERE uid = ?");
            ps.setString(1, task.getName());
            ps.setInt(2, task.getHours());
            ps.setString(3, String.valueOf(task.getState()));
            ps.setString(4, String.valueOf(task.getPriority()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(@NotNull final String uid) {
        try {
            final PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM task WHERE uid = ?;");
            ps.setString(1, uid);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getAll() {
        try {
            final List<Task> tasks = new ArrayList<>();
            final PreparedStatement ps;
            final ResultSet rs;
            ps = connection.prepareStatement("SELECT * FROM task");
            rs = ps.executeQuery();
            while (rs.next()) {
                final Task task = new Task();
                task.setUid(rs.getString("uid"));
                task.setName(rs.getString("name"));
                task.setHours(rs.getInt("hours"));
                task.setState(rs.getString("state"));
                task.setPriority(rs.getString("priority"));
                task.setOwnerId(rs.getString("ownerid"));
                tasks.add(task);
            }
            ps.close();
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void merge(@NotNull final List<Task> tasks) {
        try {
            final PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM task");
            ps.execute();
            for (Task task : tasks) {
                add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
