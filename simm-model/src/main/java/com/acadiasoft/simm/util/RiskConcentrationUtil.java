/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.simm.util;

import com.acadiasoft.util.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by alec.stewart on 8/9/17.
 */
public class RiskConcentrationUtil {

  public static final BigDecimal MM = new BigDecimal("1000000");

  public static <T> BigDecimal calcSum(Predicate<T> filter, Function<T, BigDecimal> convert, List<T> all) {
    return all.stream().filter(filter).map(convert).reduce(BigDecimal.ZERO, (a, b) -> a.add(b)).abs();
  }

  public static BigDecimal divideSqrtMax(BigDecimal sum, BigDecimal threshold) {
    BigDecimal risk = BigDecimalUtils.divideWithPrecision(sum, threshold);
    return BigDecimalUtils.sqrt(risk).max(BigDecimal.ONE);
  }

}