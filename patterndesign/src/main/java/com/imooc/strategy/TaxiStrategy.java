package com.imooc.strategy;

public class TaxiStrategy implements AbstractStrategy {
    @Override
    public int calculatePrice(int km) {
        return km * 2;
    }
}
