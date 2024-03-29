package com.arc.recycle.mapper.system;


import com.arc.model.domain.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 表数据库控制层接口
 *
 * @author X
 */
public interface MenuMapper extends BaseMapper<SysMenu> {

    Long save(SysMenu menu);

    int delete(Long menu);

    int update(SysMenu menu);

    /**
     * ·
     * 主键查询
     *
     * @param id
     * @return
     */
    SysMenu get(Long id);

    /**
     * 逻辑删除，即：更新
     *
     * @param id
     * @return
     */
    int deleteLogical(Long id);

    /**
     * 批量保存，待测试
     *
     * @param menus
     * @return
     */
    int saveBatch(@Param("menus") List<SysMenu> menus);

    List<SysMenu> listAllMenuWithSystemIdAndLevel(@Param("systemId") Integer systemId, @Param("level") Integer level);

    //    List<SysMenu> list();

}
