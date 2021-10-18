package com.zsm.Util;

import org.apache.juli.logging.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * [一句话功能简述]
 *
 * @author zsm
 * @version [版本号, 2021年10月18日]
 */
public class RequestUtil
{
    public static void main(String[] args) {
        System.out.println(getOKTimeStamp());
    }

    public static String postRequest(String url,String body){
        String fullUrl="https://www.okex.com"+url;
        RestTemplate restTemplate = new RestTemplate();
        //请求头
        HttpHeaders headers = new HttpHeaders();
        String timeStamp = getOKTimeStamp();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("OK-ACCESS-KEY",Encryption.APIKEY);
        headers.add("OK-ACCESS-TIMESTAMP",timeStamp);
        headers.add("OK-ACCESS-PASSPHRASE",Encryption.PASSPHRASE);
        String a=timeStamp+"POST"+url+body;
        String sign="";
        try {
             sign=Encryption.Base64(Encryption.HMACSHA256(a));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        headers.add("OK-ACCESS-SIGN",sign);

        String s = restTemplate.postForObject(fullUrl, headers, String.class);
        return s;
    }

    public static String getRequest(String url){
        String fullUrl="https://www.okex.com"+url;
        System.out.println(fullUrl);
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(fullUrl,String.class);
        return s;
    }

    private static String getOKTimeStamp(){
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
        return df1.format(new Date());
    }


}
