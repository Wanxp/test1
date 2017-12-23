package com.wanxp.controller;


import com.wanxp.task.Task;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Calendar;
import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by w9777 on 2017/10/13.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public  String testGet() {
        //调用线程当时间到达开调用
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Calendar calendar = Calendar.getInstance();
                    int seconds = calendar.getTime().getSeconds();
                    int minutes =calendar.getTime().getMinutes();
                    int hours = calendar.getTime().getHours();
                    if ((58 < seconds && minutes == 47  && hours == 2) || (minutes == 48 && hours == 2)) {
                        Task.curlTask();
                        System.out.println(hours + ":" + minutes + ":" + seconds);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  String testPost() {
        return "index";
    }
}
