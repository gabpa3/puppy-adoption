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

object PuppyData {

    val puppyList = listOf(
        Puppy(
            id = 1,
            name = "Roco",
            age = 3.0,
            size = PuppySize.MEDIUM,
            breed = PuppyBreed.BORDER_COLLIE,
            personality = "",
            genre = PuppyGenre.MALE,
            photoUrl = "https://placedog.net/200?id=37"
        ),
        Puppy(
            id = 2,
            name = "Ghost",
            age = 1.5,
            size = PuppySize.LARGE,
            breed = PuppyBreed.SIBERIAN_WOLF,
            personality = "",
            genre = PuppyGenre.MALE,
            photoUrl = "https://placedog.net/200?id=96"
        ),
        Puppy(
            id = 3,
            name = "Shaggy",
            age = 0.5,
            size = PuppySize.LARGE,
            breed = PuppyBreed.BOXER,
            personality = "",
            genre = PuppyGenre.MALE,
            photoUrl = "https://placedog.net/200?id=90"
        ),
        Puppy(
            id = 4,
            name = "Sun",
            age = 1.5,
            size = PuppySize.SMALL,
            breed = PuppyBreed.CORGI,
            personality = "",
            genre = PuppyGenre.FEMALE,
            photoUrl = "https://placedog.net/200?id=75"
        ),
        Puppy(
            id = 6,
            name = "Lupin",
            age = .8,
            size = PuppySize.MEDIUM,
            breed = PuppyBreed.UNDEFINE,
            personality = "",
            genre = PuppyGenre.MALE,
            photoUrl = "https://placedog.net/200?id=21"
        ),
        Puppy(
            id = 7,
            name = "Perdy",
            age = 1.0,
            size = PuppySize.LARGE,
            breed = PuppyBreed.DALMATIAN,
            personality = "",
            genre = PuppyGenre.FEMALE,
            photoUrl = "https://placedog.net/200?id=92"
        ),
        Puppy(
            id = 8,
            name = "Lady",
            age = 3.0,
            size = PuppySize.SMALL,
            breed = PuppyBreed.COCKER_SPANIEL,
            personality = "",
            genre = PuppyGenre.FEMALE,
            photoUrl = "https://placedog.net/200?id=93"
        ),
        Puppy(
            id = 9,
            name = "Crispy",
            age = .8,
            size = PuppySize.SMALL,
            breed = PuppyBreed.UNDEFINE,
            personality = "",
            genre = PuppyGenre.FEMALE,
            photoUrl = "https://placedog.net/200?id=13"
        ),
        Puppy(
            id = 10,
            name = "Spoty",
            age = .2,
            size = PuppySize.MEDIUM,
            breed = PuppyBreed.BORDER_COLLIE,
            personality = "",
            genre = PuppyGenre.FEMALE,
            photoUrl = "https://placedog.net/200?id=135"
        ),
        Puppy(
            id = 11,
            name = "Muck",
            age = 1.0,
            size = PuppySize.SMALL,
            breed = PuppyBreed.CORGI,
            personality = "",
            genre = PuppyGenre.MALE,
            photoUrl = "https://placedog.net/200?id=139"
        ),
        Puppy(
            id = 12,
            name = "Simba",
            age = 2.0,
            size = PuppySize.SMALL,
            breed = PuppyBreed.UNDEFINE,
            personality = "",
            genre = PuppyGenre.MALE,
            photoUrl = "https://placedog.net/200?id=9"
        ),
        Puppy(
            id = 13,
            name = "Night",
            age = .3,
            size = PuppySize.LARGE,
            breed = PuppyBreed.SIBERIAN_WOLF,
            personality = "",
            genre = PuppyGenre.FEMALE,
            photoUrl = "https://placedog.net/200?id=160"
        )
    )

    fun findById(puppyId: Int): Puppy {
        return puppyList.find { it.id == puppyId } ?: Puppy.empty()
    }
}
