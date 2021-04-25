package com.jxau.hotelsystem.service.impl;


import com.jxau.hotelsystem.dao.SysLogDao;
import com.jxau.hotelsystem.pojo.DO.ZpSysLog;
import com.jxau.hotelsystem.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/11 16:35
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public List<ZpSysLog> listAllLog() {
        return sysLogDao.listAllLog();
    }

    @Override
    public int insertLog(ZpSysLog zpSysLog) {
        return sysLogDao.insertLog(zpSysLog);
    }
}
