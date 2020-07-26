package cn.daymenu.milucms.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 基础Entity
 * </p>
 *
 * @author madison
 * @since 2020-05-23
 */
@Data
public class BaseEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Integer id;
}
