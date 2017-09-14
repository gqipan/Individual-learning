package com.pan.blockingQueue;

import java.util.concurrent.DelayQueue;

/**
 * Author: Qipan.G
 * Date: 2017/9/7
 * Time: 13:52
 * Descriptions: 网吧
 */
public class Wangba implements Runnable {

    private DelayQueue<Wangmin> queue = new DelayQueue<>();

    private boolean yinye = true;


    public void shangji(String name, String id, int money){
        Wangmin man = new Wangmin(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"交钱"+money+"块,开始上机...");
        this.queue.add(man);
    }

    public void xiaji(Wangmin man){
        System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"时间到下机...");
    }


    @Override
    public void run() {
        while (yinye){
            try {
                Wangmin man = queue.take();
                xiaji(man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("网吧开始营业");
        Wangba lisi = new Wangba();
        Thread shangwang = new Thread(lisi);

        shangwang.start();
        lisi.shangji("路人甲", "123", 100);
        lisi.shangji("路人乙", "234", 1000);
        lisi.shangji("路人丙", "345", 500);
    }
}
