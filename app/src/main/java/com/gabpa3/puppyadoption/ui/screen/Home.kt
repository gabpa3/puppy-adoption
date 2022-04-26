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
package com.gabpa3.puppyadoption.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gabpa3.puppyadoption.R
import com.gabpa3.puppyadoption.data.Puppy
import com.gabpa3.puppyadoption.data.PuppyData
import com.gabpa3.puppyadoption.data.PuppyGenre
import com.gabpa3.puppyadoption.data.setAgeToUI
import com.gabpa3.puppyadoption.ui.toTitleCase

@Composable
fun HomeScreen(onDetail: (Int) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        PuppyList(
            puppies = PuppyData.puppyList,
            modifier = Modifier.padding(horizontal = 16.dp),
            onDetail = onDetail
        )
    }
}

@Composable
fun PuppyCard(puppy: Puppy, onDetail: (Int) -> Unit) {
    var puppyId by remember { mutableStateOf(-1) }
    if (puppyId != -1) {
        onDetail(puppyId)
        puppyId = -1 // stop flash condition
    }
    Card(
        modifier = Modifier
            .clickable(onClick = { puppyId = puppy.id })
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            Modifier
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .width(180.dp)
            ) {
                PuppyImage(puppy = puppy)
            }
            MainContentText(
                puppy = puppy,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                textStyleForName = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun MainContentText(puppy: Puppy, modifier: Modifier, textStyleForName: TextStyle) {
    Column(modifier) {
        val resourceGenre =
            if (puppy.genre == PuppyGenre.FEMALE) R.drawable.ic_female else R.drawable.ic_male
        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = resourceGenre),
                contentDescription = stringResource(R.string.image_genre_description)
            )
        }
        Text(text = puppy.name, style = textStyleForName)
        Spacer(Modifier.size(4.dp))
        Text(text = puppy.breed.name.toTitleCase(), style = MaterialTheme.typography.subtitle2)
        Text(text = setAgeToUI(puppy.age), style = MaterialTheme.typography.body1)
    }
}

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    modifier: Modifier,
    onDetail: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(puppies) {
            PuppyCard(puppy = it, onDetail)
        }
    }
}
