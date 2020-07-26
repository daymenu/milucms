package cn.daymenu.milucms.admin.pojo.requests.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madison
 */
@Data
@ApiModel
public class PageRequest {
    @ApiModelProperty(value = "页数")
    protected Integer page =1;

    @ApiModelProperty("每页多少条")
    protected Integer pageSize = 20;
}
