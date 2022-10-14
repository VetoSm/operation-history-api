package ru.netology.aasmolin.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Operation extends BaseOperation{

//    private int id;
    private int sum;
    private String operationCreditType;
    private Currency curency;
    private String merchant;
    private int customerId;
//    private LocalDateTime time;

    public Operation(){

    }
    public Operation(int id, int sum, String operationCreditType,
                     Currency curency, String merchant, LocalDateTime time) {
        super(id, time);
        this.sum = sum;
        this.operationCreditType = operationCreditType;
        this.curency = curency;
        this.merchant = merchant;

    }


    public String toString(){
        return super.getId() + " " + sum + " " + operationCreditType + " "
                + curency + " " + merchant + " " + super.getTime();
    }

    public void printToConsole() {
        System.out.println(super.getId() + " " + sum + " " + operationCreditType + " "
                + curency + " " + merchant + " " + super.getTime());
    }

}
