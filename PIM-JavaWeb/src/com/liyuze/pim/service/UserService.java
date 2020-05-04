package com.liyuze.pim.service;

import com.liyuze.pim.entity.User;

import java.util.List;
import java.util.Map;


/**
 * @author 1034683568@qq.com
 * @project_name ssm-demo
 * @date 2015-7-28
 * @time 下午1:52:50
 */
public interface UserService {

    /**
     * �û���¼
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * ��ѯ�û�
     *
     * @param map
     * @return
     */
    public List<User> findUser(Map<String, Object> map);

    /**
     * ��ȡ�û���¼��
     *
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * �����û�
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * ����û�
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * ɾ���û�
     *
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
}
