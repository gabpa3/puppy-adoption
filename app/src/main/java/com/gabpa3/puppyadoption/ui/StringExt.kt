package com.gabpa3.puppyadoption.ui

import java.util.*

const val UNDERSCORE = "_"

fun String.toTitleCase(): String {
    return if (this.contains(UNDERSCORE)) {
        this.split(UNDERSCORE).joinToString(separator = " ") {
            it.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
        }
    } else {
        this.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
    }
}