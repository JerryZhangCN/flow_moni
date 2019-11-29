package com.flow.domain.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-18 13:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 平台IP
     */
    private String ip;
    /**
     * 端口
     */
    private String port;
    /**
     * 用户
     */
    private String user;
    /**
     * 密码
     */
    private String password;
    /**
     * 通道
     */
    private String channelId;
    /**
     * 是否在线
     */
    private String isOnline;
}
