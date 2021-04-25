package com.jxau.hotelsystem.pojo.DO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/11 16:27
 */
@Data
public class ZpSysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long loggerId;

    /**
     * 用户名
     */
    private String loggerUsername;

    /**
     * 操作
     */
    private String loggerOperation;

    /**
     * 方法名
     */
    private String loggerMethod;

    /**
     * 参数
     */
    private String loggerParams;

    /**
     * ip地址
     */
    private String loggerIp;

    /**
     * 操作时间
     */
    private Date loggerDate;

    public ZpSysLog() {
    }

}

