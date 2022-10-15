package ru.netology.aasmolin.service;

import ru.netology.aasmolin.domain.Customer;
import ru.netology.aasmolin.domain.operation.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorageService <T> {

    private final List<T> storage = new ArrayList<>();


    public void setElement (T element){
        storage.add(element);
    }

    public T getElement(int position){
        return storage.get(position);
    }

    public int getLength(){
        return storage.size();
    }

    public String toString(){
        return storage.toString();
    }


}
