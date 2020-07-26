CREATE DATABASE `cms`;
use cms;
CREATE TABLE `admin`
(
    id BIGINT auto_increment,
    username VARCHAR(255) NOT NULL DEFAULT '' COMMENT '用户名',
    email VARCHAR(255) NOT NULL DEFAULT '' COMMENT '邮箱',
    password VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码',
    status INT NOT NULL DEFAULT 1 COMMENT '状态',
    delete_status TINYINT NOT NULL DEFAULT 1 COMMENT '删除状态',
    create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    delete_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '删除时间',
    PRIMARY  KEY (id),
    KEY idx_username(username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '用户';


CREATE TABLE `admin_role`
(
    id BIGINT auto_increment,
    admin_id BIGINT NOT NULL DEFAULT '0' COMMENT '用户ID',
    role_id BIGINT NOT NULL DEFAULT '0' COMMENT '角色ID',
    status INT NOT NULL DEFAULT 1 COMMENT '状态',
    delete_status TINYINT NOT NULL DEFAULT 1 COMMENT '删除状态',
    create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    delete_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '删除时间',
    PRIMARY  KEY (id),
    KEY idx_admin_id(admin_id),
    KEY idx_role_id(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '用户角色关联';

CREATE TABLE `role`
(
    id BIGINT auto_increment,
    rolename VARCHAR(255) NOT NULL DEFAULT '' COMMENT '角色名',
    status INT NOT NULL DEFAULT 1 COMMENT '状态',
    delete_status TINYINT NOT NULL DEFAULT 1 COMMENT '删除状态',
    create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    delete_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '删除时间',
    PRIMARY  KEY (id),
    KEY idx_rolename(rolename)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '角色';