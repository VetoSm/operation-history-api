package ru.netology.aasmolin;
import ru.netology.aasmolin.domain.Currency;
import ru.netology.aasmolin.domain.Customer;
import ru.netology.aasmolin.domain.Operation;
import ru.netology.aasmolin.exception.CurrencyUnknowException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static final int NUMBER_CUSTOMER = 10;
    public static final int OPERATION_PER_CUSTOMER = 100;
    public static final int MAX_OPERATION = NUMBER_CUSTOMER * OPERATION_PER_CUSTOMER;
    public static final String YES = "Y";
    public static final Operation[] operations = new Operation[MAX_OPERATION];
    public static final Customer[] customers = new Customer[NUMBER_CUSTOMER];
    public static final int[][] statement = new int[NUMBER_CUSTOMER][OPERATION_PER_CUSTOMER];

    public static final int[] nextOparetionId = new int[NUMBER_CUSTOMER];
    public static void main(String[] args) throws Exception {



        Scanner scanner = new Scanner(System.in);

        fillCustomers(customers, scanner);
        fillOperations(operations, scanner);

        System.out.println(Arrays.toString(customers));
        System.out.println(Arrays.toString(operations));


    }

    private static void fillCustomers(Customer[] customers, Scanner scanner) {
        for (int j = 0; j < customers.length; j++){
            System.out.println("Введите имя Клиента: ");
            String name = scanner.nextLine();
            Customer customer = new Customer(j, name);
            customers[j] = customer;

            System.out.println("Хотите оставновить: " + YES + "/N");
            String answer = scanner.nextLine();


            if (answer.equals(YES)){
                break;
            } else {
                continue;
            }

        }

    }

    private static void fillOperations(Operation[] operations, Scanner scanner) {
        for (int operationId = 0; operationId < operations.length; operationId++) {

            int customerId = scanner.nextInt();
            if (!isCustomerCanStoreNextOperation(customerId)){
                System.out.println("Operation for customers is not allowed: " + customerId);
                return;
            }

            int id_operation = operationId;
            System.out.println("Введите сумму операции: ");
            int summ_operation = scanner.nextInt();
            System.out.println("Введите тип операции. (CREDIT или DEBIT) ");
            String operationType = scanner.nextLine();

            System.out.println("Введите код валюты:  ");


            Currency codeISO = parseInputCurrency(scanner.nextLine());
            System.out.println("Choose another currency");



            System.out.println("Введите место совершения операции: ");
            String merchant = scanner.nextLine();
            LocalDateTime time = LocalDateTime.now();
            System.out.println("Customer ID: ");

            Operation operation = new Operation(id_operation, summ_operation,
                    operationType, codeISO, merchant, time);
            operations[operationId] = operation;

            int customerNextOperationId = findCustomerNextOperationId(customerId);
            statement[customerId][customerNextOperationId] = operationId;
            nextOparetionId[customerId] = nextOparetionId[customerId] + 1;


            System.out.println("Хотите оставновить: " + YES + "/N");
            String answer = scanner.nextLine();

            if (answer.equals(YES)){
                break;
            } else {
                continue;
            }

        }
    }

    private static boolean isCustomerCanStoreNextOperation(int customerId) {
        return nextOparetionId[customerId] != OPERATION_PER_CUSTOMER;

    }

    private static int findCustomerNextOperationId(int customerId) {
        return nextOparetionId[customerId];
    }

    public static Currency parseInputCurrency(String input) {
        switch (input){
            case "RUB":
                return Currency.RUB;
            case "USD":
                return Currency.USD;
            case "KZT":
                return Currency.KZ;
            default:
                throw new CurrencyUnknowException();

        }
    }

}