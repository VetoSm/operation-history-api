package ru.netology.aasmolin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.aasmolin.configuration.OperationProcessingProperties;
import ru.netology.aasmolin.domain.operation.Operation;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;

@Component
@RequiredArgsConstructor
public class AsyncInputOperationService {

    private  final Queue<Operation> operations = new LinkedList<>();
    private final StatmentService statmentService;
    private final OperationProcessingProperties properties;

    public boolean addOperation(Operation operation){
        System.out.println("Operation added for processing " + operation);
        return operations.offer(operation);
    }


    public void startProcessing(){
        Thread t = new Thread(){

            @Override
            public void run(){
                processQueue();
            }
        };
        t.start();
    }


    private void processQueue() {
        while (true){
            Operation operation = operations.poll();
            if (operation == null){
                try {
                    System.out.println("No operation at the moment...");
                    Thread.sleep(properties.getTimeout());
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                //TODO wait next operation
            }else{
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }

    private void processOperation(Operation operation) {
        statmentService.saveOperation(operation);
    }

    @PostConstruct
    public void init(){
        this.startProcessing();
    }
}
