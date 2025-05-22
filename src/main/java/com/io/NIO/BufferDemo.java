package com.io.NIO;

import java.io.*;

/**
 * @Author: LQL
 * @Date: 2024/11/04
 * @Description:
 */
public class BufferDemo {

    public static void main(String[] args) {
        File file = new File("D:\\Project_Code\\JAVA\\LearnJava\\src\\main\\resources\\temporary\\alen.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("ending");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
