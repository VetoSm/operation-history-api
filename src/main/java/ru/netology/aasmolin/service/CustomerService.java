package ru.netology.aasmolin.service;

import lombok.AllArgsConstructor;
import ru.netology.aasmolin.domain.Customer;

import java.util.Scanner;

import static ru.netology.aasmolin.service.StorageService.MAX_CUSTOMER;
import static ru.netology.aasmolin.utils.Constants.YES;

@AllArgsConstructor
public class CustomerService {

    private final StorageService storageService;
    private final IOService ioService;
    public void fillCustomers(IOService ioService) {
        for (int j = 0; j < storageService.getCustomers().length; j++){
            System.out.println("Введите имя Клиента: ");
            String name = ioService.getNextInput();
            Customer customer = new Customer(j, name);
            storageService.getCustomers()[j] = customer;

            System.out.println("Хотите оставновить: " + YES + "/N");
            String answer = ioService.getNextInput();


            if (answer.equals(YES)){
                break;
            } else {
                continue;
            }

        }

    }

}
