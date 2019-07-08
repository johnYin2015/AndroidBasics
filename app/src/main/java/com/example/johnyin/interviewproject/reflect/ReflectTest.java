package com.example.johnyin.interviewproject.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Ref;

/**
 * author:johnyin2015
 * time:2019/4/20
 * description:
 */
public class ReflectTest<M> {
    private int a;

    public <M> int getA(M m) {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        try {
            String.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            String string = String.class.getConstructor(String.class).newInstance("observerable");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ReflectTest reflectTest = new ReflectTest();
        Class<? extends ReflectTest> reflectTestClass = reflectTest.getClass();

        try {
            Field fieldA = reflectTestClass.getDeclaredField("a");

            fieldA.setAccessible(true);

            fieldA.set(reflectTest, 7);

            Integer integer = (Integer) fieldA.get(reflectTest);
            System.out.println(integer);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Method methodA = reflectTestClass.getMethod("methodA");
            methodA.invoke(reflectTest);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void methodA() {
        System.out.println("methodA");
    }
}
