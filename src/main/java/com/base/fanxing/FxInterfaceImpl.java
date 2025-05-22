package com.base.fanxing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: LQL
 * @Date: 2024/09/20
 * @Description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FxInterfaceImpl<T> implements FXInterface<T>{

    private T t;

    @Override
    public T dealData() {
        return this.t;
    }

    public static void main(String[] args) {
        FxInterfaceImpl<String> stringFxInterface = new FxInterfaceImpl<>();
        stringFxInterface.setT("alen");
        System.out.println(stringFxInterface.dealData());
    }
}
