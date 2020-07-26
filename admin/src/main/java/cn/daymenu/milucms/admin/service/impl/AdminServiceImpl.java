package cn.daymenu.milucms.admin.service.impl;

import cn.daymenu.milucms.admin.entity.Admin;
import cn.daymenu.milucms.admin.mapper.AdminMapper;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminListRequest;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminPostRequest;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminPutRequest;
import cn.daymenu.milucms.admin.service.IAdminService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author madison
 * @since 2020-05-23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    /**
     * 管理员分页列表
     *
     * @param adminListRequest
     * @return
     */
    @Override
    public IPage<Admin> page(AdminListRequest adminListRequest) {
        IPage<Admin> page = new Page<>(adminListRequest.getPage(), adminListRequest.getPageSize());
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        if (!adminListRequest.getUsername().isEmpty()) {
            queryWrapper.like(Admin::getUsername, adminListRequest.getUsername());
        }
        queryWrapper.orderByDesc(Admin::getId);
        return this.page(page, queryWrapper);
    }

    /**
     * 添加管理员
     *
     * @param adminPostRequest
     * @return
     */
    @Override
    public Admin adminAdd(AdminPostRequest adminPostRequest) {
        Admin admin = new Admin();

        admin.setUsername(adminPostRequest.getUsername());
        admin.setEmail(adminPostRequest.getEmail());
        admin.setPassword(adminPostRequest.getPassword());

        boolean success = this.save(admin);
        if (success) {
            return this.getById(admin.getId());
        }

        return null;
    }

    @Override
    public Admin adminUpdate(Integer id, AdminPutRequest adminPutRequest) {
        Admin admin = new Admin();
        admin.setUsername(adminPutRequest.getUsername());
        admin.setEmail(adminPutRequest.getEmail());
        admin.setId(id);
        this.updateById(admin);
        return this.getById(admin.getId());
    }

    @Override
    public boolean adminDelete(Integer id) {
        Admin admin = new Admin();
        admin.setDeleteTime(LocalDateTime.now());
        admin.setDeleteStatus(2);
        admin.setId(id);
        return this.updateById(admin);
    }


}
