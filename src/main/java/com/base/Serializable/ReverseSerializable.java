package com.base.Serializable;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: LQL
 * @Date: 2024/07/15
 * @Description:
 */
public class ReverseSerializable {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SerializableDemo serializableDemo = new SerializableDemo("alen","nanjing");
        /**
         * 先序列化，再反序列化获取实例对象中的数据，由于address被transient修饰，因此无法通过反序列化获取它的值
         */
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                ){
            oos.writeObject(serializableDemo);
            oos.flush();
            byte[] byteArray = bos.toByteArray();
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArray))){
                SerializableDemo serializableDemo1 = (SerializableDemo) ois.readObject();
                System.out.println(serializableDemo1.getAddress());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
