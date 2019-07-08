package com.arc.recycle.controller.data;

import com.arc.model.domain.system.SysMenu;
import com.arc.model.vo.ResponseVo;
import com.arc.recycle.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：t_sys_menu控制层
 *
 * @author yechao
 * @date 2018-10-18 16:37:18
 */
@Slf4j
@RestController
@RequestMapping(path = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    /**
     * 描述:创建t_sys_menu
     *
     * @param request
     */
    @PostMapping("/save")
    public ResponseVo save(@RequestBody SysMenu request) {
        return ResponseVo.success(menuService.save(request));
    }

    /**
     * 描述：物理删除t_sys_menu
     *
     * @param id
     */
    @DeleteMapping("/{id}/physically")
    ResponseVo<Integer> deletePhysically(@PathVariable Long id) {
        return ResponseVo.success(menuService.deletePhysically(id));
    }

    @DeleteMapping("/{id}/logical")
    ResponseVo<Integer> deleteLogical(@PathVariable Long id) {
        return ResponseVo.success(menuService.deleteLogical(id));
    }


//    /**
//     * 描述：更新t_sys_menu
//     *
//     * @param request SysMenu
//     */
//    @PostMapping("/update")
//    public ResponseVo<Integer> update(@RequestBody SysMenu request) {
//        if (request == null) {
//            throw new BizException(ProjectCodeEnum.NULL);
//        }
//        return ResponseVo.success(menuService.update(request));
//    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseVo getMenuByMenuCode(@PathVariable  Long id ) {
        return ResponseVo.success(menuService.get(id));
    }




/*


/**
     * 根据级别获取指定的菜单列表 level
     * 注意：如果不穿参数则查询所有可用的
     *
     * @return
     *//*

    @PostMapping("/listAllAvailableMenu")
    public ResponseVo<> listAllAvailableMenu(@RequestBody SysMenu request) {
        return ResponseVo.success(menuService.listAllAvailableMenu(request));
    }


    */
/**
     * 返回的是带层级结构的数据
     *
     * @return
     *//*

    @PostMapping("/listAllAvailableMenuWith3Level")
    ResponseVo listAllAvailableMenuWith3Level(@RequestBody SysMenu request) {
        return ResponseVo.success(menuService.listAllAvailableMenuWith3Level());
    }
*/


    /**
     * todo 分页查询菜单
     *
     * @param menu
     * @return
     */
    @PostMapping("/page")
    public ResponseVo page(@RequestBody SysMenu menu) {
        return ResponseVo.success(menuService.listByQuery(menu));
    }


}
