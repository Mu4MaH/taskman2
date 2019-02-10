package org.alex.repository;

import org.alex.entity.Assignee;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Assignee.class)
public interface AssigneeRepository extends EntityRepository<Assignee, String> {

}


