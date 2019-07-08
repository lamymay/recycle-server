package com.arc.recycle.service.impl;

import com.arc.model.domain.system.SysMenu;
import com.arc.recycle.mapper.system.MenuMapper;
import com.arc.recycle.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 叶超
 * @since 2019/7/8 16:44
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Long save(SysMenu menu) {
//        int insert = menuMapper.insert(menu);
//        return insert == 1 ? menu.getId() : null;
        return menuMapper.save(menu);
    }

    @Override
    public int delete(Long id) {
        return menuMapper.deleteById(id);
    }
//
//    @Override
//    public int update(SysMenu menu) {
//        return menuMapper.update(menu);
//    }

    @Override
    public SysMenu get(Long id) {
//        return menuMapper.selectById(id);
        return menuMapper.get(id);
    }

    @Override
    public List<SysMenu> list() {
        return menuMapper.list();
    }

    @Override
    public int deletePhysically(Long id) {
        return 0;
    }

    @Override
    public int deleteLogical(Long id) {
        return 0;
    }

    @Override
    public Object listByQuery(SysMenu menu) {
        return null;
    }
}
