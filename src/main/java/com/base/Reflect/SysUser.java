package com.base.Reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LQL
 * @Date: 2024/10/24
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alen(key = "2")
public class SysUser {

    private String name;
    private String address;
    private int id;

}
