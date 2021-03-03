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
    DALMATIAN, UNDEFINE
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
    return when  {
        age < 1.0 -> "${getDecimalPart(age)} months old"
        age == 1.0 -> "${getIntegerPart(age)} year old"
        else -> if (getDecimalPart(age) == 0) {
            "${getIntegerPart(age)} years old"
        } else {
            "$age years old"
        }
    }
}