package ru.netology.aasmolin.service;

import static ru.netology.aasmolin.utils.Constants.MAX_CUSTOMER;
import static ru.netology.aasmolin.utils.Constants.OPERATION_PER_CUSTOMER;

public class StatmentStorageService {

    private static final int[][] statement = new int[MAX_CUSTOMER][OPERATION_PER_CUSTOMER];

    public static int[][] getStatement() {
        return statement;
    }
}
