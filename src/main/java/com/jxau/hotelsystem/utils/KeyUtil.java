package com.jxau.hotelsystem.utils;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description: 生成订单唯一主键，纯数字
 * @date 2021/2/4 11:32
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class KeyUtil {
    /**
     * 生成主键id
     * 时间+随机数
     * @return
     */
    public static synchronized String generateUniqueKey(){
        Random random = new Random();
        // 随机数的量 自由定制，这是4位随机数
        Integer r = random.nextInt(900) + 100;

        // 返回  13位时间
        Long timeMillis = System.currentTimeMillis();

        // 返回  17位时间
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStr = sdf.format(new Date());

        // 13位毫秒+4位随机数
        return  timeMillis + String.valueOf(r);
        // 17位时间+4位随机数
//        return  timeStr + r;
    }
}
