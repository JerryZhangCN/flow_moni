package com.flow.domain.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/10/19 23:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoProperty {
    /**
     * 分屏模式
     */
    private String screenMode;
    /**
     * 分屏ID
     */
    private String screenModeId;
}
