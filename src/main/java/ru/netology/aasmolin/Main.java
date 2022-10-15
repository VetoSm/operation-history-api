package ru.netology.aasmolin;

import ru.netology.aasmolin.domain.Customer;
import ru.netology.aasmolin.domain.operation.Currency;
import ru.netology.aasmolin.domain.operation.Operation;
import ru.netology.aasmolin.exception.CurrencyUnknowException;
import ru.netology.aasmolin.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import static ru.netology.aasmolin.utils.Constants.MAX_CUSTOMER;
import static ru.netology.aasmolin.utils.Constants.OPERATION_PER_CUSTOMER;



public class Main {


    public static void main(String[] args) throws Exception {



        IOService ioService = new IOService();

        StorageService<Customer> customerStorageService = new StorageService<>();
        StorageService<Operation> operationStorageService = new StorageService<>();

        CustomerService customerService = new CustomerService(customerStorageService, ioService);
        StatmentService statmentService = new StatmentService();
        OperationService operationService = new OperationService(statmentService, operationStorageService, ioService);

        //TODO remove input logic from customer and operations services
        customerService.fillCustomers(ioService);
        operationService.fillOperations(ioService);

        System.out.println(operationService.getOperations());


    }


}