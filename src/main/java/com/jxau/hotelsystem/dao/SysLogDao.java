package com.jxau.hotelsystem.dao;

import com.jxau.hotelsystem.pojo.DO.ZpSysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/11 16:30
 */
@Mapper
@Component(value = "SysLogDao")
public interface SysLogDao {
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
