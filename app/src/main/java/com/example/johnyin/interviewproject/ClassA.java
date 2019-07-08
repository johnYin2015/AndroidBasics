package com.example.johnyin.interviewproject;

/**
 * author:johnyin2015
 * time:2019/3/2
 * description:
 */
public class ClassA {
    class ClassB {
        private int b = age;

        void methodB() {
            //this.age = 8;
        }
    }

    private transient int age;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        final int c = 0;
        class ClassC {
            void methodC() {
                System.out.println(c);
                //goto
                //const
                String a1 = "";
                String b1 = "";
                here:
                for (int i = 1; i <= 4; i++) {
                    a1 = "外层循环第"+i+"层";
                    for (int j = 1; j <= 4; j++) {
                        b1 = "内层循环第"+j+"层";
                        if (2 == j & 2 == i) {
                            break here;
                        }
                    }
                }
                System.out.println(a1+b1);
                //float f = 3.4;
                short s1 = 1; s1 += 1;
                Integer.valueOf("1");
                //new StringBuffer("observerable").reverse()
            }
        }

    }

    public static void main(String args[]) {
        ClassA objA = new ClassA();
        Class<? extends ClassA> clazz = objA.getClass();
//        clazz.

        ClassB classB = objA.new ClassB();

        new ClassA() {

        };
    }
}
