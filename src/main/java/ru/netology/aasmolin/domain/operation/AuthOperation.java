package ru.netology.aasmolin.domain.operation;

import ru.netology.aasmolin.domain.ConsolePrintable;

public class AuthOperation extends BaseOperation implements ConsolePrintable {

    private String ip;

    @Override
    public void printToConsole() {
        System.out.println();
    }
}
