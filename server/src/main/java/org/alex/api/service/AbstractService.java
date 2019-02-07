package org.alex.api.service;

import org.alex.api.entity.AbstractEntity;
import org.alex.exception.WrongArgumentTypeException;

import java.util.List;


public abstract class AbstractService <E extends AbstractEntity> {

    public abstract void createProject(E e);

    public abstract E getProject(String uid) throws WrongArgumentTypeException;

    public abstract void deleteProject(String uid) throws WrongArgumentTypeException;

    public abstract void mergeProject(List<E> list);

    public abstract List<E> getAllProject();

}
