package com.wanxp.task;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;
import static org.toilelibre.libe.curl.Curl.curl;

/**
 * Created by w9777 on 2017/12/23.
 */
public class Task {
static   String rl = "https://m.meipu.cn/mobile/promotion/batchReceiveCoupon/new -H 'access-token: _v2NWI4MDRlZTYjMTUxNjUzMDE2NCMxIzI3IzI3MmNjMWMyYTA5MjkyNGRmMjlkNjNkYWFhYWY0OTFkOTAjI0JKX1NIIzVhM2NkY2Y0' -H 'Content-Type: application/json;charset=UTF-8' -d '{\"uniqueCodeList\":[\"cc8d6518d0d14fc7abacb15015b19a59\"]}\'";

    static String urlStr = "http://localhost:8880";
    static String urlStrReal = "https://m.meipu.cn/mobile/promotion/batchReceiveCoupon/new";
    static Map<String, String> params = new HashMap<String, String>();
    public String setPost(){
        return new String();
    }
    public String setHttpPost(){
//        HttpClientTool.sendPost(urlStr, params);
        return new  String();
    }

    public static void main(String[] args) throws IOException {
            curlTask();
    }

    /**
     * 调用curl
     */
    public  static void curlTask()  {
        HttpResponse response = curl(rl);
        org.apache.http.HttpEntity entity = response.getEntity();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            entity.writeTo(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = baos.toString();
        try {
            System.out.println(new String(str.getBytes("gbk"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
