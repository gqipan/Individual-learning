package com.pan.future;

import java.util.concurrent.*;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 11:50
 * Descriptions:
 */

public class UseFuture implements Callable<String>{

    private String para;

    public UseFuture(String para){
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        String result = this.para + " 处理完成";
        return result;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String queryRequest = "query";

//        FutureTask<String> futureTask = new FutureTask<>(new UseFuture(queryRequest));
//        FutureTask<String> futureTask2 = new FutureTask<>(new UseFuture(queryRequest));

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Future future1 = threadPool.submit(new UseFuture(queryRequest));
        Future future2 = threadPool.submit(new UseFuture(queryRequest));

        //submit和execute的区别： 第一点是submit可以传入实现Callable接口的实例对象， 第二点是submit方法有返回值
//        threadPool.execute(futureTask);
//        threadPool.execute(futureTask2);

        System.out.println("请求完毕！");

        try {
            //这里可以做额外的数据操作，也就是主程序执行其他业务逻辑
            System.out.println("处理实际的业务逻辑...");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //调用获取数据方法,如果call()方法没有执行完成,则依然会进行等待
//        System.out.println("数据：" + futureTask.get());
//        System.out.println("数据：" + futureTask2.get());
        System.out.println("数据：" + future1.get());
        System.out.println("数据：" + future2.get());

        threadPool.shutdown();
    }
}
