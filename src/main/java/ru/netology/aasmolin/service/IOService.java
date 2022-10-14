package ru.netology.aasmolin.service;

import java.util.Scanner;

public class IOService {
    private final Scanner scanner = new Scanner(System.in);


    public String getNextInput() {
        return scanner.nextLine();
    }

}
