package com.flow.domain.scale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-14 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private String groupName;
    private String groupCd;
    private String pGroupCd;
    private String groupLevel;
}
