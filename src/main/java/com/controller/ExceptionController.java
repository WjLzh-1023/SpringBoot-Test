package com.controller;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class ExceptionController {

    //@ResponseBody
    //@ExceptionHandler
    public Map Exception(Exception exception){
        System.out.println(exception.getMessage());
        Map map = new HashMap();
        map.put("msg1","遇到问题了，会尽快解决！此处为全局异常处理,全都有效");
        return map;


    }

}
