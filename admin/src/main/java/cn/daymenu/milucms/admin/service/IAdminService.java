package cn.daymenu.milucms.admin.service;

import cn.daymenu.milucms.admin.entity.Admin;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminListRequest;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminPostRequest;
import cn.daymenu.milucms.admin.pojo.requests.admin.AdminPutRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author madison
 * @since 2020-05-23
 */
public interface IAdminService extends IService<Admin> {
    /**
     *  管理员分页列表
     * @param adminListRequest
     * @return
     */
    public IPage<Admin> page(AdminListRequest adminListRequest);

    /**
     * 添加管理员
     * @param adminPostRequest
     * @return
     */
    public Admin adminAdd(AdminPostRequest adminPostRequest);

    /**
     * 修改管理员
     * @param id
     * @param adminPutRequest
     * @return
     */
    public Admin adminUpdate (Integer id, AdminPutRequest adminPutRequest);

    /**
     * 修改管理员
     * @param id
     * @return
     */
    public boolean adminDelete (Integer id);

}
