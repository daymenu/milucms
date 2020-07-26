package cn.daymenu.milucms.admin.pojo.requests.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author madison
 */
@Data
@ApiModel
public class AdminListRequest extends PageRequest{
    @NotNull(message = "用户名不能为空")
    @Length(min = 0, max = 10, message = "用户名要在0~10个字符之间")
    @ApiModelProperty("搜索用户名")
    private String username = "";
}
