package org.alex.repository;

import org.alex.entity.Project;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Project.class)
public interface ProjectRepository extends EntityRepository <Project, String> {

}



