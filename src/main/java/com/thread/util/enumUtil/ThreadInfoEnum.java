package com.thread.util.enumUtil;

/**
 * @Author: LQL
 * @Date: 2024/06/28
 * @Description:
 */
public enum ThreadInfoEnum {

    MAIN_THREAD("alen",2),
    USER_THREAD("userName",1);

    private final String threadName;
    private final int addValue;

    ThreadInfoEnum(String threadName,int addValue){
        this.threadName = threadName;
        this.addValue = addValue;
    }

    public static int getValueByThreadName(String threadName){
        for (ThreadInfoEnum item : values()){
            if (item.threadName.equals(threadName))
                return item.addValue;
        }
        return 0;
    }

}
