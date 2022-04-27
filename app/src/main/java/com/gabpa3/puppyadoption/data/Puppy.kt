/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gabpa3.puppyadoption.data

import com.gabpa3.puppyadoption.ui.getDecimalPart
import com.gabpa3.puppyadoption.ui.getIntegerPart

enum class PuppyGenre {
    MALE, FEMALE
}

enum class PuppySize {
    SMALL, MEDIUM, LARGE
}

enum class PuppyBreed {
    BORDER_COLLIE, SIBERIAN_WOLF, CORGI, BOXER, COCKER_SPANIEL,
    DALMATIAN, UNDEFINE, GOLDEN_RETRIEVER, SCHNAUZER, LABRADOR_RETRIEVER
}

data class Puppy(
    val id: Int = 0,
    val name: String = "",
    val age: Double = 0.0,
    val size: PuppySize,
    val breed: PuppyBreed,
    val personality: String = "",
    val genre: PuppyGenre,
    val photoUrl: String = "",
) {

    var description: String = ""

    companion object {
        fun empty(): Puppy {
            return Puppy(size = PuppySize.MEDIUM, breed = PuppyBreed.UNDEFINE, genre = PuppyGenre.MALE)
        }
    }
}

fun setAgeToUI(age: Double): String {
    return when {
        age < 1.0 -> "${getDecimalPart(age)} months old"
        age == 1.0 -> "${getIntegerPart(age)} year old"
        else -> if (getDecimalPart(age) == 0) {
            "${getIntegerPart(age)} years old"
        } else {
            "$age years old"
        }
    }
}
