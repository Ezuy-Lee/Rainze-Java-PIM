package com.liyuze.pim.controller.mybatis;

import com.liyuze.pim.dao.UserMapper;
import com.liyuze.pim.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LYZ
 * @version 1.0
 * @description
 * @projectName ProjectIntegrationManagement
 * @data 2020/3/5 18:08
 */
@RestController
public class MybatisPlusController {





    @Autowired
    private UserMapper userMapper;



    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    public int addRecord(User ur){
        //
       User nUser = new User();
       nUser.setAge(2);
       nUser.setId(1);
       nUser.setName("aa");
       nUser.setSex("nan");
        //T_user nUser = new T_user();
        //nUser.setName("ll");
        return userMapper.insert(ur);

    }

}
