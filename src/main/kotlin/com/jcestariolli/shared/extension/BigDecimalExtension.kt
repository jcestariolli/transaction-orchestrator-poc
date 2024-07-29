package com.jcestariolli.shared.extension

import java.math.BigDecimal


fun BigDecimal.greaterThan(d1: BigDecimal, d2: BigDecimal?): Boolean = d1.compareTo(d2) > 0

fun BigDecimal.greaterThanOrEquals(d1: BigDecimal, d2: BigDecimal?): Boolean  = d1.compareTo(d2) >= 0

fun BigDecimal.greaterThanOrEqualsToZero(d1: BigDecimal): Boolean  = greaterThanOrEquals(d1, BigDecimal.ZERO)

fun BigDecimal.greaterThanZero(d1: BigDecimal): Boolean  = greaterThan(d1, BigDecimal.ZERO)

fun BigDecimal.equalsZero(d1: BigDecimal?): Boolean = BigDecimal.ZERO.compareTo(d1) == 0

fun BigDecimal.lessThan(d1: BigDecimal, d2: BigDecimal?): Boolean = d1.compareTo(d2) < 0

fun BigDecimal.lessThanOrEquals(d1: BigDecimal, d2: BigDecimal?): Boolean = d1.compareTo(d2) <= 0

fun BigDecimal.lessThanZero(d1: BigDecimal): Boolean =  lessThan(d1, BigDecimal.ZERO)

fun BigDecimal.lessThanOrEqualsToZero(d1: BigDecimal): Boolean = lessThanOrEquals(d1, BigDecimal.ZERO)
