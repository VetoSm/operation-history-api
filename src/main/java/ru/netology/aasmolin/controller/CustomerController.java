package ru.netology.aasmolin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.aasmolin.controller.dto.CustomerDTO;
import ru.netology.aasmolin.controller.dto.GetClientsRespons;
import ru.netology.aasmolin.domain.Customer;
import ru.netology.aasmolin.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public GetClientsRespons getClients() {
        List<Customer> customers = customerService.getCustomers();

        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer: customers){
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new GetClientsRespons(customerDTOS);
    }

    @GetMapping("api/customers/{customerId}")
    public CustomerDTO getCustomer(@PathVariable int customerId){
        for (Customer customer : customerService.getCustomers()){
            if (customer.getId() == customerId){
                CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
                return customerDTO;
            }
        }

        return null;
    }
}
