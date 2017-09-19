package com.pan.future;

/**
 * Author: Qipan.G
 * Date: 2017/9/19
 * Time: 11:03
 * Descriptions:
 */
public class FutureTest {

    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data data = futureClient.request("特殊的请求参数");
        System.out.println("请求发送成功!");
        System.out.println("做其他的事情...");

        String result = data.getRequest();
        System.out.println(result);
    }
}
