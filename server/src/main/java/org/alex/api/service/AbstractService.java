package org.alex.api.service;

import org.alex.api.entity.AbstractEntity;
import org.alex.exception.IllegalArgumentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class AbstractService <E extends AbstractEntity> {

    public abstract void create(E e);

    public abstract E get(String uid) throws IllegalArgumentException;

    public abstract void delete(String uid) throws IllegalArgumentException;

    public abstract void merge(List<E> list);

    public abstract List<E> getAll();

}
