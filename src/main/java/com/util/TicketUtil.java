package com.util;

import cn.hutool.crypto.SecureUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 登录Ticket工具类，使用hutool 5.4.1 进行加解密
 * 1. 拼接登录名和超时时间戳，中间使用分隔符分隔
 * 2. 使用AES加密
 */
public class TicketUtil {

    /**
     * AES加密key
     */
    final static String KEY = "fBjFyY09ZizruJAdqwOJBQ==";

    /**
     * 超时时长，单位秒
     */
    final static int DEFAULT_TIMEOUT_IN_SECONDS = 150;

    final static String SEPARATOR = ":";

    /**
     * 拼接登录名和超时时间戳，中间使用分隔符分隔
     *
     * @param ptId 统一平台登录名
     * @return 登录Ticket
     */
    public static String genLoginTicket(String ptId) throws UnsupportedEncodingException {
        return encodeAscii(genLoginTicket(ptId, DEFAULT_TIMEOUT_IN_SECONDS));
    }

    public static String genLoginTicket(String ptId, int timeoutInSeconds) throws UnsupportedEncodingException {
        long expireTime = System.currentTimeMillis() + timeoutInSeconds * 1000L;
        return encodeAscii(SecureUtil.aes(KEY.getBytes()).encryptBase64(ptId + SEPARATOR + expireTime));
    }

    public static String encodeAscii(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8");
    }

    /**
     * 解析登录Ticket
     *
     * @param loginTicket 登录Ticket
     * @return 统一平台登录名
     * @throws RuntimeException Ticket解析失败
     */
    public static String parseLoginTicket(String loginTicket) {
        String decrypted;
        try {
            decrypted = SecureUtil.aes(KEY.getBytes()).decryptStr(loginTicket);
        } catch (Exception e) {
            throw new RuntimeException("Ticket invalid");
        }

        String[] result = decrypted.split(SEPARATOR);
        if (result.length != 2) {
            throw new RuntimeException("Ticket format error");
        }

        long expireTime = Long.parseLong(result[1]);
        if (expireTime < System.currentTimeMillis()) {
            throw new RuntimeException("Ticket expired");
        }
        return result[0];
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String loginTicket = genLoginTicket("admin", 2 * 24 * 60 * 60);
        System.out.println("loginTicket: " + loginTicket);
        try {
            String loginId = parseLoginTicket(URLDecoder.decode(loginTicket, "UTF-8"));
            System.out.println("loginId: " + loginId);
        } catch (Exception e) {
            System.err.println("解析失败" + e.getMessage());
        }
    }
}
