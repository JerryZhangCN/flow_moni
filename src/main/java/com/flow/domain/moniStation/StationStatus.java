package com.flow.domain.moniStation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/12/16 17:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationStatus {
    private String sttp;
    private String stationStatus;
    private String stationStatusName;

}
