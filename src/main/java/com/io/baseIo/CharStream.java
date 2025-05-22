package com.io.baseIo;

import java.io.*;

/**
 * @Author: LQL
 * @Date: 2024/07/30
 * @Description:
 */
public class CharStream {


    public static void main(String[] args) {
        String tempDir = "D:\\Project_Code\\JAVA\\LearnJava\\src\\main\\resources\\temporary";
        File file = new File(tempDir);
        if (file.isDirectory()){
            System.out.println("is dir");
            File[] files = file.listFiles();
            for (File file1 : files){
                if (file1.isFile()){
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)))){
                        String str = null;
                        while ((str = bufferedReader.readLine()) != null){
                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

}
