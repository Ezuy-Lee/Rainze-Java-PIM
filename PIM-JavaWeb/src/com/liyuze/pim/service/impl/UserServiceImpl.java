package com.liyuze.pim.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.liyuze.pim.dao.UserDao;
import com.liyuze.pim.entity.User;
import com.liyuze.pim.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 1034683568@qq.com
 *         project_name ssm-demo
 * @date 2015-7-28
 * @time 下午1:52:50
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> findUser(Map<String, Object> map) {
        return userDao.findUsers(map);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser(map);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

}
