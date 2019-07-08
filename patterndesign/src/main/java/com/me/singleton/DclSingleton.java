package com.me.singleton;

public class DclSingleton {

    private static volatile DclSingleton mInstance; //?

    private DclSingleton() {
        if (mInstance == null) {
            synchronized (DclSingleton.class) {
                if (mInstance == null) {
                    mInstance = new DclSingleton();
                }
            }
        }
        return;
    }

}
