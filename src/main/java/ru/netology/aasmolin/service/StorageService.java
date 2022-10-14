package ru.netology.aasmolin.service;

import ru.netology.aasmolin.domain.Customer;
import ru.netology.aasmolin.domain.operation.Operation;

public class StorageService {

    public static final int OPERATION_PER_CUSTOMER = 100;
    public static final int MAX_CUSTOMER = 10;

    private final Customer[] customers = new Customer[MAX_CUSTOMER];
    private final Operation[] operations = new Operation[MAX_CUSTOMER * OPERATION_PER_CUSTOMER];
    private final int[][] statement = new int[MAX_CUSTOMER][OPERATION_PER_CUSTOMER];

    public Customer[] getCustomers() {
        return customers;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public int[][] getStatement() {
        return statement;
    }
}
