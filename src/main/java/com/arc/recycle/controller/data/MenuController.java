package com.arc.recycle.controller.data;

import com.arc.enums.system.ProjectCodeEnum;
import com.arc.exception.BizException;
import com.arc.model.domain.system.SysMenu;
import com.arc.model.vo.ResponseVo;
import com.arc.recycle.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：实际上就是表menu 的控制层
 *
 * @author yechao
 * @date 2018-10-18 16:37:18
 */
@Slf4j
@RestController
@RequestMapping(path = "/menus")
public class MenuController {

    @Autowired
    @Qualifier("menuServiceImpl")
    private MenuService menuService;


    /**
     * 描述:创建menu
     *
     * @param request
     */
    @PostMapping("")
    public ResponseVo save(@RequestBody SysMenu request) {
        return ResponseVo.success(menuService.save(request));
    }

    /**
     * 批量保存
     *
     * @param menus
     * @return
     */
    @PostMapping("/batch")
    public ResponseVo saveBatch(@RequestBody List<SysMenu> menus) {
        return ResponseVo.success(menuService.saveBatch(menus));
    }

    /**
     * 描述：物理删除menu--DeleteMapping("/{id}/physically")
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    ResponseVo<Integer> deletePhysically(@PathVariable Long id) {
        return ResponseVo.success(menuService.delete(id));
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return 返回操作影响行数
     */
    @DeleteMapping("/{id}/logical")
    ResponseVo<Integer> deleteLogical(@PathVariable Long id) {
        return ResponseVo.success(menuService.deleteLogical(id));
    }


    /**
     * 描述：更新menu
     *
     * @param id
     * @param request
     * @return 返回操作影响行数
     */
    //todo id 是用什么方式来传递？ url中 还是body中
    @PutMapping("/{id}/update")
    public ResponseVo<Integer> update(@PathVariable Long id, @RequestBody SysMenu request) {
        if (request == null) {
            throw new BizException(ProjectCodeEnum.NULL);
        }
        return ResponseVo.success(menuService.update(request));
    }

    /**
     * 主键查询
     *
     * @param id 主键id
     * @return 单个菜单数据（一般用于编辑回显）
     */
    @GetMapping("/{id}")
    public ResponseVo getMenuByMenuCode(@PathVariable Long id) {
        return ResponseVo.success(menuService.get(id));
    }


    /**
     * 返回带层级结构的已经启用的菜单数据
     *
     * @param systemId 系统id
     * @param level    级别
     * @return 首页菜单渲染（Available=未删除的）
     */
    //注意url中不要驼峰表示，这里是{取值}，建议随java风格驼峰，其余一律小写
    @GetMapping("/{systemId}/{level}")
    ResponseVo listAllAvailableMenuWith3Level(@PathVariable Integer systemId, @PathVariable Integer level) {
        return ResponseVo.success(menuService.listAllMenuWithSystemIdAndLevel(systemId, level));
    }

    /**
     * 分页查询 后台编辑管理中用的
     *
     * @param menu
     * @return
     */
    //todo 后台编辑管理中用的  参数实体建议分离，即 手参对象不应该是db中用的那个对象，
    @PostMapping("/page")
    public ResponseVo page(@RequestBody SysMenu menu) {
        return ResponseVo.success(menuService.pageByQuery(menu));
    }

}
