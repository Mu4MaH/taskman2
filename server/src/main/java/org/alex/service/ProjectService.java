package org.alex.service;

import org.alex.api.service.AbstractService;
import org.alex.api.service.IProjectService;
import org.alex.entity.Project;
import org.alex.exception.IllegalArgumentException;
import org.alex.repository.ProjectRepository;

import java.util.List;

public class ProjectService extends AbstractService<Project> implements IProjectService {

    ProjectRepository repository = new ProjectRepository();

    /* +++ Отладочные записи +++ */
    {

        repository.add(new Project("proj1"));
        repository.add(new Project("proj2"));
        repository.add(new Project("proj3"));

    }
    /*      ***      */

    @Override
    public void create(Project project) {
        if (project == null) return;
        this.repository.add(project);
    }

    @Override
    public Project get(String uid) throws IllegalArgumentException {
        if (uid.isEmpty() || uid.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            return (Project) this.repository.get(uid);
        }
    }

    @Override
    public void delete(String uid) throws IllegalArgumentException {
        //ничего не делает, удаление проектов не разрешено вообще.
    }

    @Override
    public List<Project> getAll() {
        return this.repository.getAll();
    }

    @Override
    public void merge(List<Project> list) {
        if (list.equals(null)) return;
        this.repository.merge(list);
    }
}


