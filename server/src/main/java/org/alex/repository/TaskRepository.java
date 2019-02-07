package org.alex.repository;

import org.alex.entity.Task;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository

public interface TaskRepository extends EntityRepository <Task, String> {

}
