package com.jxau.hotelsystem.pojo.DO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:35
 */
@Data
public class HouseLayoutList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间类型id
     */
    private Integer houseLayoutId;

    /**
     * 房间类型姓名
     */
    private String houseLayoutName;

    /**
     * 房间床数
     */
    private Integer houseLayoutBed;

    /**
     * 房间人数
     */
    private Integer houseLayoutPeople;

    /**
     * 房间类型说明
     */
    private String houseLayoutExplanation;

    public HouseLayoutList() {
    }

}

