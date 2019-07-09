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

    /**
     * 保存一条数据
     *
     * @param menu
     * @return
     */
    Long save(SysMenu menu);

    /**
     * 批量保存
     *
     * @param menus
     * @return
     */
    int saveBatch(List<SysMenu> menus);


    /**
     * 单条数据查询
     *
     * @param id
     * @return
     */
    SysMenu get(Long id);

    /**
     * 物理删除 deletePhysically 【默认】
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 逻辑删除【实际上是更新】
     *
     * @param id
     * @return
     */
    int deleteLogical(Long id);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    int update(SysMenu request);

    /**
     * 返回带层级结构的已经启用的菜单数据
     *
     * @param systemId
     * @param level
     * @return
     */
    List<SysMenu> listAllMenuWithSystemIdAndLevel(Integer systemId, Integer level);

    /**
     * 分页查询
     *
     * @param menu
     * @return
     */
    //todo 分页查询 包裹对象需要重新设计
    List<SysMenu> pageByQuery(SysMenu menu);

}
