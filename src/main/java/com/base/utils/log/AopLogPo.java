package com.base.utils.log;

import lombok.Data;

import java.util.Date;

/**
 * @author Yr
 */
@Data
public class AopLogPo {
    private Long id;
    /**
     * 操作人
     */
    private String userName;
    /**
     * 操作
     */
    private String operation;
    /**
     * 方法名
     */
    private String method;
    /**
     * 参数
     */
    private String params;
    /**
     * IP地址
     */
    private String ip;

    /**
     * 操作时间
     */
    private Date operatingTime;

    /**
     * 表名
     */
    private String tableName;
}
