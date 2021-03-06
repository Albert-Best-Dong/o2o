package com.imooc.o2o.enums;

import com.imooc.o2o.entity.Product;

public enum ProductStateEnum {
    SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY_LIST(-1002, "添加数少于1"),
    EMPTY(0,"参数为空");


    private int state;

    private String stateInfo;


    ProductStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }


    public String getStateInfo() {
        return stateInfo;
    }

    public static ProductStateEnum stageOf(int state) {
        for (ProductStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
