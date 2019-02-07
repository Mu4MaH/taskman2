package org.alex.service;

import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.repository.ProjectRepository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@Transactional
public class ProjectService implements IProjectService {

    @Inject
    private ProjectRepository repo;

    public ProjectService() {
    }

    @Override
    public void createProject(@NotNull final Project project) {
        repo.save(project);
    }

    @Override
    @Nullable
    public Project getProject(@NotNull final String uid) {
        if (uid.isEmpty()) {
            return null;
        } else {
            return repo.findBy(uid);
        }
    }

    @Override
    public void deleteProject(@NotNull final String uid) {
        return; //ничего не делает, удаление проектов не разрешено вообще.
    }

    @Override
    @Nullable
    public List<Project> getAllProject() {
        return repo.findAll();
    }

    @Override
    public void mergeProject(@Nullable final List<Project> list) {
        if (list == null) return;
        for (Project p : repo.findAll()) {
            repo.removeAndFlush(p);
        }
        for (Project p : list) {
            repo.save(p);
        }
    }
}



