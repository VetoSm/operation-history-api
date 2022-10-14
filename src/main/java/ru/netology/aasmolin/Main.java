package ru.netology.aasmolin;

import ru.netology.aasmolin.domain.Customer;
import ru.netology.aasmolin.domain.operation.Currency;
import ru.netology.aasmolin.domain.operation.Operation;
import ru.netology.aasmolin.exception.CurrencyUnknowException;
import ru.netology.aasmolin.service.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.aasmolin.utils.Constants.YES;


public class Main {


    public static void main(String[] args) throws Exception {

        IOService ioService = new IOService();
        StorageService storageService = new StorageService();
        CustomerService customerService = new CustomerService(storageService, ioService);
        StatmentService statmentService = new StatmentService(storageService);
        OperationService operationService = new OperationService(statmentService, storageService, ioService);

        //TODO remove input logic from customer and operations services
        customerService.fillCustomers(ioService);
        operationService.fillOperations(ioService);

        System.out.println(operationService.getOperations());


    }


}