package com.jxau.hotelsystem.dao;

import com.jxau.hotelsystem.pojo.DO.HouseLayoutList;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:37
 */
@Mapper
public interface HouseLayoutDao {
    /**
     * 查询所有房型
     * @return
     */
    List<HouseLayoutList> listAllHouseLayoutList();

    /**
     * 查询key
     * @param key
     * @return
     */
    List<HouseLayoutList> listAllHouseLayoutByKey(String key);


    /**
     * 查询所有房型
     * @return
     */
    List<HouseLayoutList> selectPage();

    /**
     * 插入房型
     * @param houseLayoutList
     * @return
     */
    int insertHouseLayoutList(HouseLayoutList houseLayoutList);
    /**
     * 修改房源
     * @param houseLayoutList
     * @return
     */
    int updateHouseLayoutList(HouseLayoutList houseLayoutList);

    /**
     * 删除房源
     * @param houseLayoutId
     * @return
     */
    int deleteHouseLayoutList(int houseLayoutId);
    /**
     * 查询单个房型号
     * @param houseLayoutId
     * @return
     */
    HouseLayoutList selectHouseLayoutList(int houseLayoutId);
}
