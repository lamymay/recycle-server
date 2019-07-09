package com.arc.recycle.service.impl;

import com.arc.model.domain.system.SysMenu;
import com.arc.recycle.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 叶超
 * @since 2019/7/9 16:46
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
//使用指定的那一份配置文件
@ActiveProfiles("dev")
//会回滚
//@Rollback(value = true)
//@Transactional
public class MenuServiceImplTest {


    @Autowired
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteLogical() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test
    public void saveBatch() {
        List<SysMenu> menus = new ArrayList<>(3);
        SysMenu sysMenu1 = new SysMenu();
        SysMenu sysMenu2 = new SysMenu();
        SysMenu sysMenu3 = new SysMenu();

        menus.add(sysMenu1);
        menus.add(sysMenu2);
        menus.add(sysMenu3);
        int save = menuService.saveBatch(menus);
        log.debug("结果={}", save);
        Assert.assertTrue(3 == save);
    }



    @Test
    public void listAllMenuWithSystemIdAndLevel() {
    }

    @Test
    public void pageByQuery() {
    }
}
