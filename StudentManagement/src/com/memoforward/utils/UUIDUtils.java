package com.memoforward.utils;

import java.util.UUID;

public class UUIDUtils {
    /**
     * 随机生成ID
     * @return
     */

    public static String getId(){
        return UUID.randomUUID().toString();
    }
}
