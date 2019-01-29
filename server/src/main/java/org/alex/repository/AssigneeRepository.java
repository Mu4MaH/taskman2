package org.alex.repository;

import org.alex.entity.Assignee;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssigneeRepository {

    private Connection connection;

    public void setConnection(@NotNull Connection connection) {
        this.connection = connection;
    }


    public void add(@NotNull final Assignee assignee) {

        final List<Assignee> assignees = getAll();
        for (int i = 0; i < getAll().size(); i++) {
            if (assignee.getLogin().equals(assignees.get(i).getLogin())) {
                System.out.println("DEBUG ass.add: ЕСТЬ ТАКАЯ БУКВА!!!" );
                return;
            }
        }
        try {
//            SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//            Session session = sessionFactory.openSession();
            final PreparedStatement ps = connection.prepareStatement("INSERT INTO assignee VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, assignee.getUid());
            ps.setString(2, assignee.getName());
            ps.setString(3, assignee.getLogin());
            ps.setInt(4, assignee.getPassword());
            ps.setString(5, assignee.getGroup());
            ps.setBoolean(6, assignee.getAdmin());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Assignee getAssigneeByUid(@NotNull final String uid) {
        try {
            Assignee assignee = new Assignee();
            PreparedStatement ps;
            ResultSet rs;
            ps = connection.prepareStatement("SELECT uid, name, login, pass, grp, isadmin FROM assignee WHERE uid = ?");
            ps.setObject(1, uid);
            rs = ps.executeQuery();
            assignee.setUid(rs.getString("uid"));
            assignee.setName(rs.getString("name"));
            assignee.setLogin(rs.getString("login"));
            assignee.setPassword(rs.getInt("pass"));
            assignee.setGroup(rs.getString("grp"));
            if (rs.getBoolean("isadmin")) assignee.setAdmin();
            ps.close();
            return assignee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(@NotNull final String uid) {
        try {
            final PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM assignee WHERE uid = ?;");
            ps.setString(1, uid);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Assignee> getAll() {
        try {
            final List<Assignee> stuff = new ArrayList<>();
            final PreparedStatement ps;
            final ResultSet rs;
            ps = connection.prepareStatement("SELECT * FROM assignee");
            rs = ps.executeQuery();
            int j = 0;
            while (rs.next()) {
                final Assignee assignee = new Assignee();
                assignee.setUid(rs.getString("uid"));
                assignee.setName(rs.getString("name"));
                assignee.setLogin(rs.getString("login"));
                assignee.setPassword(rs.getInt("pass"));
                assignee.setGroup(rs.getString("grp"));
                if (rs.getBoolean("isadmin")) assignee.setAdmin();
                stuff.add(assignee);
            }
            ps.close();
            return stuff;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void merge(@NotNull final List<Assignee> assignees) {
        try {
            final PreparedStatement ps;
            ps = connection.prepareStatement("DELETE FROM assignee");
            ps.execute();
            for (Assignee assignee : assignees) {
                add(assignee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


