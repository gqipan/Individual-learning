package com.pan.jvm;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

class SupClass{
    static {
        System.out.println("SupClass init");
    }
    public static int value = 100;
}

class SubClass extends SupClass{
    static {
        System.out.println("SubClass init");
    }
}