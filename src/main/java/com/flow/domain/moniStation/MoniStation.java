/**
 * Copyright © 2016-2019 The Thingsboard Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flow.domain.moniStation;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoniStation {


    /**
     * ID(列表默认以ID升序)
     */
    private String id;

    /**
     * 经度
     */
    private String lttd;
    /**
     * 纬度
     */
    private String lgtd;
    /**
     * 监测站名称
     */
    private String stnm;
    /**
     * 监测站编码
     */
    private String stcd;
    /**
     * 是否启动图标
     */
    private String enableIco;
    /**
     * 图标文件位置
     */
    private String icoPosition;
    /**
     * 是否启动闪烁图标
     */
    private String enableIcoFlicker;

    /**
     * 闪烁图标位置
     */
    private String flickerIcoPosition;
    /**
     * 闪烁频率模式
     */
    private String flickerRateMode;
    /**
     * 闪烁重复次数
     */
    private String flickerNumber;

    /**
     * 闪烁截止时间
     */
    private String flickerToTime;

    /**
     * 是否启音频
     */
    private String enableAudio;
    /**
     * 音频文件位置
     */
    private String audioPosition;
    /**
     * 音频播放频率模式
     */
    private String audioPlayRateMode;
    /**
     * 音频播放重复次数
     */
    private String audioPlayNumber;
    /**
     * 音频播放截止时间
     */
    private String audioPlayToTime;
    /**
     * 状态是否完成
     */
    private String stateIFFinish;

    /**
     * 监测站类型（"QJ"指取水计量，"SL"指生态流量）
     */
    private String sttp;

    /**
     * 监测站类型名称
     */
    private String sttpName;

    /**
     * 监测站类型详情
     */
    private String sonSttp;

    /**
     * 监测站类型详情名称
     */
    private String sonSttpName;

    /**
     * 监测站地址
     */
    private String stlc;

    /**
     * 监测指标
     */
    private String monitorPara;


}
