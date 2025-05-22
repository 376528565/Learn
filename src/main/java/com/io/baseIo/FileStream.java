package com.io.baseIo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author: LQL
 * @Date: 2024/07/31
 * @Description:
 */
public class FileStream {

    public static void main(String[] args) {
        String tempPath = "D:\\Project_Code\\JAVA\\LearnJava\\src\\main\\resources\\temporary\\alen.txt";
        try (
//                FileOutputStream fos = new FileOutputStream(tempPath);
                FileInputStream fis = new FileInputStream(tempPath)){
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int length;
            while ((length = fis.read(bytes)) != -1){
                stringBuilder.append(new String(bytes,0,length, StandardCharsets.UTF_8));
            }
            String string = stringBuilder.toString();
            System.out.println(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
