package org.alex.api.repository;

import org.alex.entity.Assignment;

import java.util.List;

public interface IAssignmentRepository {

    boolean create(Assignment assignment);

    boolean delete (String fromId, String toId);

    List<Assignment> getAllById(String id); //Получает все назначения по айдишнику по полю fromId

    boolean merge(List<Assignment> assignments);

    void vacuum (); //Удаляет все записи, у которых один из айдишников "ведёт" на несуществующий объект
}
