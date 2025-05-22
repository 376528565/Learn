package com.io.baseIo;

import java.io.*;

/**
 * @Author: LQL
 * @Date: 2024/07/31
 * @Description:
 */
public class SerializableStream {

    public static void main(String[] args) {
        A a = new A("alen",2);
        String tempPath = "D:\\Project_Code\\JAVA\\LearnJava\\src\\main\\resources\\temporary\\";
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                        tempPath + a.getClass().getSimpleName()
                ));
        ){
            oos.writeObject(a);
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(tempPath + A.class.getSimpleName()))){
                A a1 = (A) ois.readObject();
                System.out.println(a1.getName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            new File(tempPath + A.class.getSimpleName()).deleteOnExit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
