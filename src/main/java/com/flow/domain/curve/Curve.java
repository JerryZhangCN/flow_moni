package com.flow.domain.curve;

import com.flow.domain.scale.CurveProperty;
import com.flow.domain.statistics.CurveData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-19 16:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curve<T, O, X> {
    private List<T> curveData;
    private O curveProperty;
    private X floatWindowData;
}
