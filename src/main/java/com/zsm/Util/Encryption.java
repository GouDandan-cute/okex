package com.zsm.Util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * [加密算法]
 *
 * @author zsm
 * @version [版本号, 2021年10月18日]
 */
public class Encryption
{

    static final String APIKEY ="26fa336d-b406-4692-b118-804bb127945f";
    static final String SECREKEY="26fa336d-b406-4692-b118-804bb127945f";
    static final String PASSPHRASE="990501ABab";

    /**
     * HMACSHA256加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String HMACSHA256(String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(SECREKEY.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();

    }

    public static String Base64(String key){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(key.getBytes());
    }
}
