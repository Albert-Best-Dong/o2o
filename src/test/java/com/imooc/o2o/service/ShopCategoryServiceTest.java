package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Test
    public void testAGetShopCategoryList() {
        List<ShopCategory> list = null;
        list = shopCategoryService.getShopCategoryList(null);
        Assert.assertEquals(6,list.size());
    }
}
