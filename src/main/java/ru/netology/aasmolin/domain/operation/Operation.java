package ru.netology.aasmolin.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
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

    public void printToConsole() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return sum == operation.sum && customerId == operation.customerId && Objects.equals(operationCreditType, operation.operationCreditType) && curency == operation.curency && Objects.equals(merchant, operation.merchant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, operationCreditType, curency, merchant, customerId);
    }
}
