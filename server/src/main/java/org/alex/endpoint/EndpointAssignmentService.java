package org.alex.endpoint;

import org.alex.api.service.IAssignmentService;
import org.alex.entity.Assignment;
import org.alex.exception.IllegalStringException;
import org.alex.repository.AssignmentRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndpointAssignmentService implements IAssignmentService {

    AssignmentRepository repository = new AssignmentRepository();

    public EndpointAssignmentService() {
//        Endpoint.publish("http://localhost:888/assignment", this);

    }

    @WebMethod
    @Override
    public void create(Assignment assignment) {
        if (assignment == null) {
            throw new NullPointerException();
        } else {
            repository.add(assignment);
        }
    }

    @WebMethod
    @Override
    public List<Assignment> get(String fromId) {
        if (fromId.equals(null) || fromId.isEmpty()) {
            return null;
        } else {
            return repository.getAllById(fromId);
        }
    }

    @WebMethod
    @Override
    public List<Assignment> getAll() {
        return repository.getAll();
    }

    @Override
    public void merge(List<Assignment> assignments) {
        if (assignments == null) return;
        repository.merge(assignments);
    }

    @WebMethod
    @Override
    public void del(String fromId, String toId) throws IllegalStringException {
        if (fromId.equals(null) || toId.equals(null)) {
            return;
        } else {
            repository.delete(fromId, toId);
        }
    }

    @WebMethod
    @Override
    public void vacuum() {
        repository.vacuum();
    }

}
