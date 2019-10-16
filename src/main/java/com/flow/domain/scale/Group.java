package com.flow.domain.scale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerry
 * @date 2019-10-14 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private String groupName;
    private String groupId;
    private String pGroupId;
    private String groupLevel;
    private List<Group> groups = new ArrayList<>();
}
