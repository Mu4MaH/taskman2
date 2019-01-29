package org.alex.api.repository;

import org.alex.entity.Assignment;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IAssignmentRepository {

    void add(Assignment assignment) throws SQLException;

    Collection <Assignment> get();

    void delete (String fromId, String toId) throws SQLException;

    Collection <Assignment> getAllById(String id); //Получает все назначения по айдишнику по полю fromId

    void merge(List<Assignment> assignments) throws SQLException;

//    void vacuum (); //Удаляет все записи, у которых один из айдишников "ведёт" на несуществующий объект
}
