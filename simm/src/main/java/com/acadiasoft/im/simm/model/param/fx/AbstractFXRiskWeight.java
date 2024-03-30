package com.acadiasoft.im.simm.model.param.fx;

import com.acadiasoft.im.simm.model.imtree.identifiers.WeightingClass;
import com.acadiasoft.im.simm.model.param.SimmFxRiskWeight;

import java.math.BigDecimal;

public abstract class AbstractFXRiskWeight implements SimmFxRiskWeight {

    protected abstract BigDecimal getVegaValue();

    @Override
    public BigDecimal getVegaRiskWeight(WeightingClass s, String calculationCurrency) {
        return getVegaValue();
    }

}
