package com.pan.java8;

//import java.util.function.BinaryOperator;
//import java.util.stream.Stream;
//
//public class ReduceTest {
//
//    public static void main(String[] args) {
//        Integer result = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
//        System.out.println(result);
//
//        // 展开
//        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
//        int count =accumulator.apply(
//                accumulator.apply(
//                        accumulator.apply(0, 1),2
//                ), 3
//        );
//
//    }
//}
