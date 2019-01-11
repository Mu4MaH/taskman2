package org.alex.api.service;

import org.alex.entity.Assignment;
import org.alex.exception.IllegalStringException;

import java.util.List;

public interface IAssignmentService {

    void create(Assignment assignment);

    void delete (String fromId, String toId) throws IllegalStringException;

    List<Assignment> getAllById(String id); //Получает все назначения по айдишнику по полю fromId

    void mergeAssignments(List<Assignment> assignments);

    void vacuum (); //Удаляет все записи, у которых один из айдишников "ведёт" на несуществующий объект и дубли

    List<Assignment> getAllAssignments();

}
