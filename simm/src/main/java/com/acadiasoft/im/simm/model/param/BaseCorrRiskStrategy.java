package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import java.math.BigDecimal;

public interface BaseCorrRiskStrategy {
    BigDecimal getRiskWeight(WeightingClass w);
    BigDecimal getSensitivityCorrelation(WeightingClass r, WeightingClass s);
}