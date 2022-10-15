package ru.netology.aasmolin.service;

import lombok.AllArgsConstructor;
import ru.netology.aasmolin.domain.operation.Currency;
import ru.netology.aasmolin.domain.operation.Operation;
import ru.netology.aasmolin.exception.CurrencyUnknowException;

import java.time.LocalDateTime;

import static ru.netology.aasmolin.utils.Constants.YES;

@AllArgsConstructor
public class OperationService {

    private final StatmentService statmentService;
    private final StorageService<Operation> operationStorageService;

    private final IOService ioService;

    public void fillOperations(IOService ioService) {
        for (int operationId = 0; operationId < operationStorageService.getLength(); operationId++) {

            System.out.println("Customer ID: ");
            int customerId = Integer.parseInt(ioService.getNextInput());
            if (!statmentService.isCustomerCanStoreNextOperation(customerId)) {
                System.out.println("Operation for customers is not allowed: " + customerId);
                return;
            }

            int id_operation = operationId;
            System.out.println("Введите сумму операции: ");
            int summ_operation = Integer.parseInt(ioService.getNextInput());
            System.out.println("Введите тип операции. (CREDIT или DEBIT) ");
            String operationType = ioService.getNextInput();

            System.out.println("Введите код валюты:  ");


            Currency codeISO = parseInputCurrency(ioService.getNextInput());
            System.out.println("Choose another currency");


            System.out.println("Введите место совершения операции: ");
            String merchant = ioService.getNextInput();
            LocalDateTime time = LocalDateTime.now();


            Operation operation = new Operation(id_operation, summ_operation,
                    operationType, codeISO, merchant, time);
            operationStorageService.setElement(operation);
            statmentService.saveOperationToStatment(customerId, operationId);

            System.out.println("Хотите оставновить: " + YES + "/N");
            String answer = ioService.getNextInput();

            if (answer.equals(YES)) {
                break;
            } else {
                continue;
            }

        }
    }

    public String getOperations() {
        return operationStorageService.toString();
    }


    private static Currency parseInputCurrency(String input) {
        return switch (input) {
            case "RUB" -> Currency.RUB;
            case "USD" -> Currency.USD;
            case "KZT" -> Currency.KZ;
            default -> throw new CurrencyUnknowException();
        };
    }

}
