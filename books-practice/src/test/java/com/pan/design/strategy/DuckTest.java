package com.pan.design.strategy;

import org.junit.Test;

import java.util.*;

/**
 * Created by Pan on 2017/6/4.
 */
public class DuckTest {

    @Test
    public void testMiniDuckSimulator(){
        Duck duck = new ModelDuck(new FlyWithWings(), new MuteQuack());

        duck.preFormFly();
        duck.preFormQuack();


        duck.setFlyBehavior(new FlyNoWay());
        duck.setQuackBehavior(new Squeak());

        duck.preFormFly();
        duck.preFormQuack();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(4);
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = list.subList(2, 3);
        Integer[] integers = {1, 2, 3};
        List<Integer> list2 = Arrays.asList(integers);
        list2.add(4);

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : map.keySet()) {

        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {

        }
    }

}
