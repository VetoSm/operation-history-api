package ru.netology.aasmolin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.aasmolin.domain.Customer;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class CustomerService {

    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name){
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }

}
