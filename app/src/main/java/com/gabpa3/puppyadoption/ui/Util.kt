package com.gabpa3.puppyadoption.ui

fun getDecimalPart(value: Double): Int {
    return value.toString().substringAfter('.').toInt()
}

fun getIntegerPart(value: Double): Int {
    return value.toString().substringBefore('.').toInt()
}
