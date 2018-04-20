package com.pan.jvm;

class ConstClass {

    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLO = "Hello";
}

public class Test{
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO);
    }
}


