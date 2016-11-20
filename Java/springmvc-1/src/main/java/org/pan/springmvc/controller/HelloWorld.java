package org.pan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/springmvc")
public class HelloWorld {

    @RequestMapping(value = "/testHelloWorld", method = RequestMethod.GET)
    public String testHelloWorld() {
        System.out.println("Spring-MVC HelloWorld!");
        return "ok";
    }

    /**
     * RequestMapping 中的params， 可以设置请求请求的参数中，那些值是必须的,也可以设置哪些值逻辑判断:
     * 示例： age为必须的，score != 50 可以不存在但是有值不能等于50, 当不满足条件时，会报404错误
     *
     * @return
     */
    @RequestMapping(value = "/testRequestMappingParams", method = RequestMethod.GET, params = {"age", "score!=50"})
    public String testRequestMappingParams() {
        System.out.println("===============testRequestMappingParams!");
        return "ok";
    }

    /**
     * 设置请求头的信息
     *
     * @return
     */
    @RequestMapping(value = "/testRequestMappingHeaders", method = RequestMethod.GET, headers = {"Host=localhost:8081"})
    public String testRequestMappingHeaders() {
        System.out.println("===============testRequestMappingHeaders!");
        return "ok";
    }


    /**
     * 1、 ?  匹配一个字符
     * 2、 *  匹配零个或多个字符
     * 3、 ** 匹配零个或多个路径
     *
     * @return
     */

//    @RequestMapping(value="/testAntStyle*",method=RequestMethod.GET)
//    @RequestMapping(value="/testAntStyle??",method=RequestMethod.GET)
    @RequestMapping(value = "/testAntStyle**/**/q", method = RequestMethod.GET)
    public String testAntStyle() {
        System.out.println("=====testAntStyle");
        return "ok";
    }


    @RequestMapping(value = "/testPathVariable/{orderId}/{bookId}", method = RequestMethod.GET)
    public String testPathVariable(@PathVariable("orderId") Long orderId,
                                   @PathVariable("bookId") Long bookId) {

        System.out.println("=====testPathVariable");
        System.out.println("orderId = "+orderId + " bookId = " +bookId);
        return "ok";
    }
}