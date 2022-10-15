package ru.netology.aasmolin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.aasmolin.domain.operation.Operation;


import java.util.*;

@Component
@AllArgsConstructor
public class StatmentService {

    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void saveOperation(Operation operation){
        List<Operation> operations = storage.get(operation.getCustomerId());
        if (operations == null){
            List<Operation> customerOperation = new ArrayList<>();
            customerOperation.add(operation);
            storage.put(operation.getCustomerId(), customerOperation);
        } else {
            operations.add(operation);
        }

    }

    public String getOperations(){
        return storage.toString();
    }

}
