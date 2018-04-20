package org.qipan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: Qipan.G
 * Date: 2018/4/11
 * Time: 14:31
 * Descriptions:
 */
@Controller
public class HelloWorld {


    @ResponseBody
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "hello world";
    }

}
