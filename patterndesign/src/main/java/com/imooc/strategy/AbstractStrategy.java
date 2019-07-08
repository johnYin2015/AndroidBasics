package com.imooc.strategy;

//抽象决策类
public interface AbstractStrategy {
    //按距离来计算价格 算法
    int calculatePrice(int km);
}
