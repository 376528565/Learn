package com.designPattern.behavior.other;

/**
 * @Author: LQL
 * @Date: 2024/11/30
 * @Description:
 */
public class SingleLink {

    private SingleLink next;
    private String data;

    public SingleLink(String data){
        this.data = data;
    }

    public SingleLink(){}

    public static void main(String[] args) {
        SingleLink head = new SingleLink();
        SingleLink pre = head;
        for (int i = 0; i < 10; i++){
            pre.next = new SingleLink("alen " + i);
            pre = pre.next;
        }
        System.out.println("the single link last data is : " + pre.data);
    }

}
