package com.flow.domain.alarm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/11/17 9:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmMsg {
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 短信报警内容
     */
    private String alarmContent;
    /**
     * 报警时间
     */
    private String alarmTime;
    /**
     * 监测指标
     */
    private String monitorPara;
    /**
     * 报警时段
     */
    private String monitorInterval;
    /**
     * 通讯录编码
     */
    private String addressBookId;
    /**
     * 电话
     */
    private String phone;
    /**
     * 发送短信失败错误信息
     */
    private String errorMsg;
    /**
     * 发送短信结果  1：成功  0：失败
     */
    private Integer sendResult = 0;
}
