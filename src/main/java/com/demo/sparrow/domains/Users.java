package com.demo.sparrow.domains;

import java.io.Serializable;
import lombok.Data;

/**
 * users
 * @author tqboss
 */
@Data
public class Users implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String telephone;

    private static final long serialVersionUID = 1L;
}