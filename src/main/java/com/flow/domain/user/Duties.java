package com.flow.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

/**
 * @author jerry
 * @date 2019/11/7 18:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duties {
    /**
     * 职务ID
     */
    private String dutiesId;
    /**
     * 职务名称
     */
    private String dutiesName;
}
