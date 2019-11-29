package com.flow.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/10/24 16:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUser {

    /**
     * 姓名
     */
    private String name;
    /**
     * 职务
     */
    private String dutiesName;

    /**
     * 电话
     */
    private String phone;
    /**
     * 报警特性
     */
    private String alarmCharacter;
    /**
     * 操作
     */
    private String isSelected;
    /**
     * 测站名称
     */
    private String stcd;
    /**
     * 通讯录ID
     */
    private String addressbookId;
    /**
     * 职位ID
     */
    private String dutiesId;
    /**
     * 组织ID
     */
    private String organizationId;
    /**
     * 重试次数
     */
    private String retryNumber;
    /**
     * 最大次数
     */
    private String maxNumber;
    /**
     * 发布结果
     */
    private String result;
    /**
     * 操作
     */
    private String operation;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 座机
     */
    private String tel;
    /**
     * 邮件
     */
    private String email;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 用户排序字段
     */
    private String index;


}
