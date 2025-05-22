package com.designPattern.create.prototype.demo2;

import com.designPattern.create.prototype.User1;
import com.designPattern.create.prototype.Users;

/**
 * @Author: LQL
 * @Date: 2025/01/13
 * @Description:
 */
public class PrototypeDemo {

    public static void main(String[] args) {
        Users users = new Users("beijing", new User1("alen", 12));
        Users users1 = new Users(users); //通过构造函数clone对象，跟实现cloneable接口重写clone方法类似的功能，且不会抛出异常
        System.out.println(users1 == users);
    }

}
