package ru.netology.aasmolin.service;

import lombok.AllArgsConstructor;

import static ru.netology.aasmolin.service.StorageService.MAX_CUSTOMER;
import static ru.netology.aasmolin.service.StorageService.OPERATION_PER_CUSTOMER;

@AllArgsConstructor
public class StatmentService {

    private final StorageService storageService;
    private static final int[] nextOparetionId = new int[MAX_CUSTOMER];


    public void saveOperationToStatment(int customerId, int operationId){
        int customerNextOperationId = findCustomerNextOperationId(customerId);
        storageService.getStatement()[customerId][customerNextOperationId] = operationId;
        nextOparetionId[customerId] = nextOparetionId[customerId] + 1;

    }
    public boolean isCustomerCanStoreNextOperation(int customerId) {
        return nextOparetionId[customerId] != OPERATION_PER_CUSTOMER;

    }

    private int findCustomerNextOperationId(int customerId) {
        return nextOparetionId[customerId];
    }

}
