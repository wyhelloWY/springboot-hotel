package com.jxau.hotelsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxau.hotelsystem.dao.HouseDao;
import com.jxau.hotelsystem.dao.HouseLayoutDao;
import com.jxau.hotelsystem.pojo.DO.HouseLayoutList;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.service.HouseLayoutService;
import com.jxau.hotelsystem.utils.PageRequest;
import com.jxau.hotelsystem.utils.PageResult;
import com.jxau.hotelsystem.utils.PageUtils;
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
 * @date 2021/2/8 16:24
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class HouseLayoutServiceImpl implements HouseLayoutService {
    @Autowired
    private HouseLayoutDao houseLayoutDao;

    @Override
    public List<HouseLayoutList> listAllHouseLayoutList() {
        return houseLayoutDao.listAllHouseLayoutList();
    }

    @Override
    public List<HouseLayoutList> selectPage() {
        return houseLayoutDao.selectPage();
    }

    @Override
    public int insertHouseLayoutList(HouseLayoutList houseLayoutList) {
        return houseLayoutDao.insertHouseLayoutList(houseLayoutList);
    }

    @Override
    public int updateHouseLayoutList(HouseLayoutList houseLayoutList) {
        return houseLayoutDao.updateHouseLayoutList(houseLayoutList);
    }

    @Override
    public int deleteHouseLayoutList(int houseLayoutId) {
        return houseLayoutDao.deleteHouseLayoutList(houseLayoutId);
    }

    @Override
    public HouseLayoutList selectHouseLayoutList(int houseLayoutId) {
        return houseLayoutDao.selectHouseLayoutList(houseLayoutId);
    }

    @Override
    public List<HouseLayoutList> listAllHouseLayoutByKey(String key) {
        return houseLayoutDao.listAllHouseLayoutByKey(key);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }
    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<?> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<HouseLayoutList> sysMenus = houseLayoutDao.selectPage();
        return new PageInfo<HouseLayoutList>(sysMenus);
    }
    @Override
    public List<HouseLayoutList> getHouseLayoutList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<HouseLayoutList> sysMenus = houseLayoutDao.selectPage();
        return sysMenus;
    }
}
