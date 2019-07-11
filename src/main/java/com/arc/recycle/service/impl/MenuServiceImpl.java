package com.arc.recycle.service.impl;

import com.arc.model.domain.system.SysMenu;
import com.arc.recycle.mapper.system.MenuMapper;
import com.arc.recycle.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 叶超
 * @since 2019/7/8 16:44
 */
@Slf4j
//说明， 这里持久层使用Mybatis Plus  初次使用， 本service是使用手写sql的方式去做
@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public Long save(SysMenu menu) {
        return menuMapper.save(menu);
    }

    @Override
    public int delete(Long id) {
        return menuMapper.delete(id);
    }

    @Override
    public int deleteLogical(Long id) {
        return menuMapper.deleteLogical(id);
    }

    @Override
    public int update(SysMenu menu) {
        return menuMapper.update(menu);
    }

    @Override
    public SysMenu get(Long id) {
        return menuMapper.get(id);
    }

    @Override
    public int saveBatch(List<SysMenu> menus) {
        return menuMapper.saveBatch(menus);
    }

    @Override
    public List<SysMenu> listAllMenuWithSystemIdAndLevel(Integer systemId, Integer level) {
        return menuMapper.listAllMenuWithSystemIdAndLevel(systemId, level);
    }

    @Override
    public List<SysMenu> pageByQuery(SysMenu menu) {
        return null;
    }
}
