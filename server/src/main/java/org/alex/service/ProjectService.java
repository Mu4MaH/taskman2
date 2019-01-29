package org.alex.service;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.exception.IllegalArgumentException;
import org.alex.repository.ProjectRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class ProjectService implements IProjectService {

    SqlSessionFactory sqlSessionFactory;
    private ProjectRepository repo;

    public ProjectService() throws IOException {
    }

    @Override
    public void createProject(@NotNull final Project project) {
        SqlSession session = sqlSessionFactory.openSession();
        repo = session.getMapper(ProjectRepository.class);
        if (project == null) return;
        repo.add(project);
        session.commit();
        session.close();
    }

    @Override
    public void setSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;

    }

    @Override
    @NotNull
    public Project getProject(@NotNull final String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            SqlSession session = sqlSessionFactory.openSession();
            repo = session.getMapper(ProjectRepository.class);
            final Project output = repo.get(uid);
            session.commit();
            session.close();
            return output;
        }
    }

    @Override
    public void deleteProject(@NotNull final String uid) {
        return; //ничего не делает, удаление проектов не разрешено вообще.
    }

    @Override
    @Nullable
    public List<Project> getAllProject() {
        SqlSession session = sqlSessionFactory.openSession();
        repo = session.getMapper(ProjectRepository.class);
        final List<Project> output = repo.getAll();
        session.commit();
        session.close();
        return output;
    }

    @Override
    public void mergeProject(@Nullable final List<Project> list) {
        if (list.equals(null)) return;
        repo.wipe();
        for (Project project : list) {
            repo.add(project);
        }
    }
}


