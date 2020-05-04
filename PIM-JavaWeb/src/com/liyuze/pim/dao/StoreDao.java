package com.liyuze.pim.dao;

import com.liyuze.pim.entity.Store;

import java.util.List;
import java.util.Map;


/**
 * @author 1034683568@qq.com
 *         project_name ssm-demo
 * @date 2015-8-17
 * @time 下午2:32:02
 */
public interface StoreDao {
    /**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Store> findStores(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalStores(Map<String, Object> map);

    /**
     * 添加书架
     *
     * @param store
     * @return
     */
    public int insertStore(Store store);

    /**
     * 修改书架信息
     *
     * @param store
     * @return
     */
    public int updStore(Store store);

    /**
     * 删除 这个功能暂时可能不会用到
     *
     * @param id
     * @return
     */
    public int delStore(String id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Store getStoreById(String id);

    /**
     * 找到最优的书架并返回
     *
     * @return
     */
    public Store getOptimalStore();

}
