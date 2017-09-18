package com.pan.concurrentUtil;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Author: Qipan.G
 * Date: 2017/9/13
 * Time: 11:30
 * Descriptions:
 */
public class BankWaterService implements Runnable {

    /**
     * 创建 4 个屏障，处理完之后执行当前类的 run 方法,
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    /**
     * 假设只有 4 个 sheet，所以只启动 4 个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个 sheet 计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();


    /**
     * 统计方法
     */
    private void count(){
        for (int i = 0; i < 4; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前 sheet 的银流数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 银流计算完成，插入一个屏障
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e ) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 在线程到达屏障时，优先执行 barrierAction
     */
    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }

        sheetBankWaterCount.put("result", result);
        System.out.println(result);

    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
