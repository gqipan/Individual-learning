package org.pan.struts2.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Pan on 2016/11/26.
 */
@Data
@Builder
public class User {

    private String username;

    private String address;


    public static String sayHello(String username){
        System.out.println(username + "，你好！");

        return username + "Hello";
    }


    public String title = "擎天柱";

    public String sayYou(String username){
        System.out.println(username + "，你好！");

        return username + "Hello";
    }
}
