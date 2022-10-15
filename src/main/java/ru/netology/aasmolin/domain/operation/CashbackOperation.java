package ru.netology.aasmolin.domain.operation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashbackOperation extends Operation{
    private int cashbackAmount;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("CashBack: " + cashbackAmount);
    }

//    public CashbackOperation(int amount, int cashbackAmount){
//       super(1, amount, "CREDIT", "RUB", "SBER", LocalDateTime.now());
//       this.cashbackAmount = cashbackAmount;
//    }
}
