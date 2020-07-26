package cn.daymenu.milucms.admin.controller;


import cn.daymenu.milucms.admin.common.commons.ApiResultCommon;
import cn.daymenu.milucms.admin.entity.Admin;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminListRequest;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminPostRequest;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminPutRequest;
import cn.daymenu.milucms.admin.service.IAdminService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author madison
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/admin/admin")
@Api(value = "Admin", tags = "admin")
@Slf4j
public class AdminController {
    @Resource
    private IAdminService adminService;

    @ApiOperation(value = "管理员分页列表", notes = "管理员分页列表")
    @ApiResponses(value = {
    })

    @GetMapping
    @ResponseBody
    public ApiResultCommon<IPage<Admin>> index(@RequestBody @Validated AdminListRequest listRequest) {
        return ApiResultCommon.SUCCESS(adminService.page(listRequest));
    }

    @GetMapping("{id}")
    @ResponseBody
    public ApiResultCommon<Admin> show(@PathVariable("id") Integer id) {
        return ApiResultCommon.SUCCESS(adminService.getById(id));
    }

    @PostMapping
    @ResponseBody
    public ApiResultCommon<Admin> add(@RequestBody @Validated AdminPostRequest adminPostRequest) {
        return ApiResultCommon.SUCCESS(adminService.adminAdd(adminPostRequest));
    }

    @PutMapping("{id}")
    @ResponseBody
    public ApiResultCommon<Admin> update(@PathVariable("id") Integer id, @RequestBody @Validated AdminPutRequest adminPutRequest) {
        return ApiResultCommon.SUCCESS(adminService.adminUpdate(id, adminPutRequest));
    }


    @DeleteMapping("{id}")
    @ResponseBody
    public ApiResultCommon<Boolean> delete(@PathVariable("id") Integer id) {
        return ApiResultCommon.SUCCESS(adminService.adminDelete(id));
    }
}
