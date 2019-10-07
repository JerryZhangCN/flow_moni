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


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author jerry
 * @date 2019-10-06
 */
@Data
@Builder
@AllArgsConstructor
public class MoniStation {

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
     * 是否启动图标
     */
    private boolean EnableIco;
    /**
     * 图标文件位置
     */
    private String IcoPosition;
    /**
     * 是否启动闪烁图标
     */
    private boolean EnableIcoFlicker;

    /**
     * 闪烁图标位置
     */
    private String FlickerIcoPosition;
    /**
     * 闪烁频率模式
     */
    private String FlickerRateMode;
    /**
     * 闪烁重复次数
     */
    private int FlickerNumber;

    /**
     * 闪烁截止时间
     */
    private String FlickerToTime;

    /**
     * 是否启音频
     */
    private boolean EnableAudio;
    /**
     * 音频文件位置
     */
    private String AudioPosition;
    /**
     * 音频播放频率模式
     */
    private String AudioPlayRateMode;
    /**
     * 音频播放重复次数
     */
    private String AudioPlayNumber;
    /**
     * 音频播放截止时间
     */
    private String AudioPlayToTime;
    /**
     * 状态是否完成
     */
    private String StateIFFinish;


}
