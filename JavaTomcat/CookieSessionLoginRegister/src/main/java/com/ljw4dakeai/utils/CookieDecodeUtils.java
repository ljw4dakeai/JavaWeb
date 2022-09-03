package com.ljw4dakeai.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author ljw4dakeai
 * @description: 对cookie中的数据解码
 * @title: CookieDecodeUtils
 * @package com.ljw4dakeai.com.ljw4dakeai.utils
 * @date 2022/8/28 4:06 下午
 */
public class CookieDecodeUtils {
    public static String decode(String cookieName){
        String decodeString = "";
        try {
            decodeString =  URLDecoder.decode(cookieName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodeString;
    }
}
