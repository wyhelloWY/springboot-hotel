package com.jxau.hotelsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxau.hotelsystem.dao.HouseDao;
import com.jxau.hotelsystem.pojo.DO.HouseLayoutList;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.service.HouseService;
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
 * @date 2021/2/8 17:27
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseDao houseDao;
    @Override
    public List<HouseList> listAllHouseList() {
        return houseDao.listAllHouseList();
    }

    @Override
    public List<HouseList> selectPage() {
        List<HouseList> houseLists = houseDao.selectPage();
        for (HouseList houseList : houseLists) {
            if(houseList.getHouseStatus() == 0){
                houseList.setHouseTypeByInt("空房");
            }else if(houseList.getHouseStatus() == 1){
                houseList.setHouseTypeByInt("满房");
            }else{
                houseList.setHouseTypeByInt("空房");
            }
        }
        return houseLists;
    }

    @Override
    public int insertHouseList(HouseList houseList) {
        return houseDao.insertHouseList(houseList);
    }

    @Override
    public int orderHouseList(int houseId, int houseStatus) {

        return houseDao.orderHouseList(houseId,houseStatus);
    }

    @Override
    public int updateHouseListByNumber(int houseNumber, int houseStatus) {
        return houseDao.updateHouseListByNumber(houseNumber,houseStatus);
    }

    @Override
    public int updateHouseList(HouseList houseList) {
        return houseDao.updateHouseList(houseList);
    }

    @Override
    public List<HouseList> listAllHouseListByKey(String key) {
        return houseDao.listAllHouseListByKey(key);
    }

    @Override
    public int deleteHouseList(int houseId) {
        return houseDao.deleteHouseList(houseId);
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
        List<HouseList> sysMenus = houseDao.selectPage();

        return new PageInfo<HouseList>(sysMenus);
    }

    @Override
    public List<HouseList> getHouseList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<HouseList> sysMenus = houseDao.selectPage();
        for (HouseList houseList : sysMenus) {
            if(houseList.getHouseStatus() == 0){
                houseList.setHouseTypeByInt("空房");
            }else if(houseList.getHouseStatus() == 1){
                houseList.setHouseTypeByInt("满房");
            }else{
                houseList.setHouseTypeByInt("空房");
            }
        }
        return sysMenus;
    }

    @Override
    public HouseList selectHouseListInfo(int houseId) {
        return houseDao.selectHouseListInfo(houseId);
    }
}
