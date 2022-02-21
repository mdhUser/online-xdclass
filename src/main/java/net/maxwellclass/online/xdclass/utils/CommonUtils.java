package net.maxwellclass.online.xdclass.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: 通用工具类
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 19:30
 */
public class CommonUtils {

    /**
     * MD5加密工具
     * @param data
     * @return
     */
    public static String MD5(String data) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0X100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
