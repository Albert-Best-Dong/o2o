package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.LocalAuthExecution;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.enums.LocalAuthStateEnum;
import com.imooc.o2o.enums.WechatAuthStateEnum;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest {

    @Autowired
    private LocalAuthService localAuthService;

    @Test
    public void testABindLocalAuth() {

        LocalAuth localAuth = new LocalAuth();
        PersonInfo personInfo = new PersonInfo();
        String username = "testusername";
        String password = "testpassword";

        personInfo.setUserId(1L);

        localAuth.setUsername(username);
        localAuth.setPassword(password);
        localAuth.setPersonInfo(personInfo);

        LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
        Assert.assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());

        localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
        System.out.println("用户昵称：" + localAuth.getPersonInfo().getName());
        System.out.println("平台账户密码：" + localAuth.getPassword());
    }

    @Test
    public void testBModifyLocalAuth() {

        //设置账号信息
        long userId = 1;
        String username = "testusername";
        String password = "testpassword";
        String newPassword = "testnewpassword";

        //修改对应账号的密码
        LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
        Assert.assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
        //通过账号密码找到修改后的账户
        LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, newPassword);
        System.out.println(localAuth.getPersonInfo().getName());
    }
}
