package com.example.mvcsampleapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private List<Integer> integerList;

    public Model() {
        integerList = new ArrayList<>(3);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);

    }

    public int getDataAtIndex(int index) {
        return integerList.get(index);
    }

    public void setDataAtIndex(int index) {
        integerList.set(index, integerList.get(index) + 1);
        setChanged();
        notifyObservers();
    }
}
