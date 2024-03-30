package com.acadiasoft.im.simm.model.param;

import com.acadiasoft.im.simm.config.HoldingPeriod;
import com.acadiasoft.im.simm.model.param.cq.BaseCorrRisk;
import com.acadiasoft.im.simm.model.param.cq.BaseCorrRisk1d;

public class BaseCorrRiskStrategyFactory {

    public static BaseCorrRiskStrategy getStrategy(HoldingPeriod period) {
        if (period.equals(HoldingPeriod.TEN_DAY)) {
            return new BaseCorrRisk();
        } else {
            return new BaseCorrRisk1d();
        }
    }
}
