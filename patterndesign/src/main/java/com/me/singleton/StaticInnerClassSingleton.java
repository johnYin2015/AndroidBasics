package com.me.singleton;

public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance(){
        return SingletonHolder.mInstance;
    }

    private static class SingletonHolder{
        private static final StaticInnerClassSingleton mInstance = new StaticInnerClassSingleton();//?
    }
}
