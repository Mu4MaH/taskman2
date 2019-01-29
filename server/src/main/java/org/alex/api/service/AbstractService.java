package org.alex.api.service;

import org.alex.api.entity.AbstractEntity;
import org.alex.exception.IllegalArgumentException;

import java.util.List;


public abstract class AbstractService <E extends AbstractEntity> {

    public abstract void createProject(E e);

    public abstract E getProject(String uid) throws IllegalArgumentException;

    public abstract void deleteProject(String uid) throws IllegalArgumentException;

    public abstract void mergeProject(List<E> list);

    public abstract List<E> getAllProject();

}
