package org.alex.api.repository;

import org.alex.api.entity.AbstractEntity;
import org.alex.entity.Assignment;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface IAssignmentRepository {

    void add(Assignment assignment);

    Collection <Assignment> get();

    void delete (String fromId, String toId);

    Collection <Assignment> getAllById(String id); //Получает все назначения по айдишнику по полю fromId

    void merge(List<Assignment> assignments);

    void vacuum (); //Удаляет все записи, у которых один из айдишников "ведёт" на несуществующий объект
}
