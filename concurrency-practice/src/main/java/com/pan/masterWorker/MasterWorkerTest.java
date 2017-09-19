package com.pan.masterWorker;

import java.util.Random;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 11:26
 * Descriptions:
 */
public class MasterWorkerTest {
    public static void main(String[] args) {
        Master master = new Master(new Worker(), 20);

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setPrice(random.nextInt(1000));
            master.submit(task);
        }
        master.excute();

        long start = System.currentTimeMillis();

        while (true){
            if (master.isCompile()){
                long end = System.currentTimeMillis() - start;
                int priceResult = master.getResult();
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
                break;
            }
        }

    }
}
