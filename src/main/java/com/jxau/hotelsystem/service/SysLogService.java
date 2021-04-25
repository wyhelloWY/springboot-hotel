package com.jxau.hotelsystem.service;



import com.jxau.hotelsystem.pojo.DO.ZpSysLog;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/11 16:35
 */
public interface SysLogService {
    /**
     * 查询所有记录
     * @return
     */
    List<ZpSysLog> listAllLog();

    /**
     * 插入日志
     * @param zpSysLog
     * @return
     */
    int insertLog(ZpSysLog zpSysLog);
}
