package ru.netology.aasmolin.domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoanOperation extends Operation{
    private int loanId;

    @Override
    public void printToConsole() {
        super.printToConsole();
        System.out.println("loanID: " + loanId);
    }
}
