package com.arc.recycle.service;

import com.arc.model.domain.system.SysMenu;

import java.util.List;

/**
 * 菜单相关服务层，目的是处理业务，
 *
 * @author 叶超
 * @since 2019/7/8 16:41
 */

public interface MenuService {

    Long save(SysMenu menu);

    int delete(Long id);

//    int update(SysMenu menu);

    SysMenu get(Long id);

    List<SysMenu> list();

    /**
     * 物理删除
     *
     * @param id
     * @return
     */
    int deletePhysically(Long id);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    int deleteLogical(Long id);

    Object listByQuery(SysMenu menu);

    //List<SysMenu> listByQuery();

}
