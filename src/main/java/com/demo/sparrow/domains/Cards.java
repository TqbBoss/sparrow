package com.demo.sparrow.domains;

import java.io.Serializable;
import lombok.Data;

/**
 * cards
 * @author tqboss
 */
@Data
public class Cards implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 账户
     */
    private String account;

    /**
     * 银行
     */
    private String bank;

    /**
     * 用户ID
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}