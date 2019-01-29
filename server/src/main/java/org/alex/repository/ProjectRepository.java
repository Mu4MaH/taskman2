package org.alex.repository;

import org.alex.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectRepository {

    String add = "INSERT INTO project (uid, name, ownerid) VALUES (#{uid}, #{name}, #{ownerId})";
    String get = "SELECT project uid, name, ownerid FROM project WHERE uid = #{uid}";
    String getAll = "SELECT * FROM project";
    String wipe = "DELETE FROM project";

    @Select(getAll)
    @Results(value = {
            @Result(property = "uid", column ="uid"),
            @Result(property = "name", column = "name"),
            @Result(property = "ownerId", column = "ownerid")
    })
    List<Project> getAll();

    @Select(get)
    @Results(value = {
            @Result(property = "uid", column ="uid"),
            @Result(property = "name", column = "name"),
            @Result(property = "ownerId", column = "ownerid")
    })
    Project get(String uid);

    @Insert(add)
    void add(Project project);

    @Delete(wipe)
    void wipe();


//    public void merge(final List<Project> projects) {
//        try {
//            final PreparedStatement ps;
//            ps = connection.prepareStatement("DELETE FROM project");
//            ps.executeUpdate();
//            for (Project project : projects) {
//                add(project);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


//    @Override
//    public void add(final Project project) {
//
//        session.getConfiguration().addMapper(ProjectMapper.class);
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        mapper.add(project);
//        session.commit();
//        session.close();
//
////        try {
////            final PreparedStatement ps = connection.prepareStatement("INSERT INTO project (uid, name, ownerid) VALUES (?, ?, ?)");
////            ps.setString(1, project.getUid());
////            ps.setString(2, project.getName());
////            ps.setString(3, project.getOwnerId());
////            ps.execute();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @Override
//    public Project get(final String uid) {
//        session.getConfiguration().addMapper(ProjectMapper.class);
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        Project output = mapper.get(uid);
//        session.commit();
//        session.close();
//        return output;
////
////        try {
////            final Project project = new Project();
////            final ResultSet rs;
////            final PreparedStatement ps = connection.prepareStatement("SELECT project uid, name, ownerid FROM project WHERE uid = ?");
////            ps.setString(1, uid);
////            rs = ps.executeQuery();
////            project.setUid(rs.getString("uid"));
////            project.setName(rs.getString("name"));
////            project.setOwnerId(rs.getString("ownerid"));
////            return project;
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return null;
////        }
//    }
//
//    @Override
//    public List<Project> getAll() {
//        session.getConfiguration().addMapper(ProjectMapper.class);
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        List<Project> output =  mapper.getAll();
//        session.commit();
//        session.close();
//        return output;
////
////        try {
////            final List<Project> projects = new ArrayList<>();
////            final PreparedStatement ps;
////            final ResultSet rs;
////            ps = connection.prepareStatement("SELECT * FROM project");
////            rs = ps.executeQuery();
////            while (rs.next()) {
////                final Project project = new Project();
////                project.setUid(rs.getString("uid"));
////                project.setName(rs.getString("name"));
////                project.setOwnerId(rs.getString("ownerid"));
////                projects.add(project);
////            }
////            return projects;
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return null;
////        }


}




