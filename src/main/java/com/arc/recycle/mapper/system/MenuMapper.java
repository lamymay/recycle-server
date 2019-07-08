package com.arc.recycle.mapper.system;


import com.arc.model.domain.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 *  表数据库控制层接口
 * @author X
 */
public interface MenuMapper extends BaseMapper<SysMenu> {

    Long save(SysMenu menu);

//    int delete(SysMenu menu);
//    int update(SysMenu menu);

    List<SysMenu> list();

    SysMenu get(Long id);
}
