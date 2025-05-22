package com.designPattern.create.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LQL
 * @Date: 2025/01/08
 * @Description:
 */
@Data
@AllArgsConstructor
public class Users {

    private String address;
    private User1 user1;

    /**
     * 通过构造函数构建新的类实例，实现原型模式，而非通过实现clone接口实现
     * @param users
     */
    public Users(Users users){
        this.address = users.address;
        this.user1 = new User1();
        this.user1.setName(users.user1.getName());
        this.user1.setAge(users.user1.getAge());
    }

}
