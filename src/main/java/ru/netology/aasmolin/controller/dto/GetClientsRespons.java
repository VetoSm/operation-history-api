package ru.netology.aasmolin.controller.dto;

import lombok.Data;

import java.util.List;


@Data
public class GetClientsRespons {
    private final List<CustomerDTO> clients;
}
