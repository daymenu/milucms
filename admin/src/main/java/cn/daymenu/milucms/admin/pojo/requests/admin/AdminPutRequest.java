package cn.daymenu.milucms.admin.pojo.requests.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class AdminPutRequest {
    @NotNull(message = "用户名不能为空")
    @Length(min = 5, max = 10, message = "用户名要在5~10个字符之间")
    @ApiModelProperty("用户名")
    private String username;


    @NotNull(message = "密码不能为空")
    @Length(min = 5, max = 10, message = "密码要在5~10个字符之间")
    @ApiModelProperty("密码")
    private String password;

    @NotNull(message = "邮箱不能为空")
    @Length(min = 5, max = 10, message = "邮箱要在5~10个字符之间")
    @ApiModelProperty("邮箱")
    private String email;
}
