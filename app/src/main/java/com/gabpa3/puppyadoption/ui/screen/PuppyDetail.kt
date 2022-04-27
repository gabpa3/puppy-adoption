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

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gabpa3.puppyadoption.R
import com.gabpa3.puppyadoption.data.Puppy
import com.gabpa3.puppyadoption.data.PuppyData

@Composable
fun DetailScreen(puppyId: Int = 8, onUpClick: () -> Unit) {
    val puppy = PuppyData.findById(puppyId)
    puppy.description = stringResource(R.string.detail_text_doggo_ipsum)
    PuppyDetailScreen(puppy = puppy, onUpClick)
}

@Composable
fun PuppyDetailScreen(puppy: Puppy, onUpClick: () -> Unit) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Detail") },
                navigationIcon = { ArrowBackIcon(onUpClick) })
//            TopBar()
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            PuppyImage(puppy = puppy, Modifier.height(250.dp))
            Spacer(Modifier.size(16.dp))
            ContentDetail(puppy = puppy)
        }
    }
}

@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(onClick = onUpClick) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back"
        )
    }
}

@Composable
fun TopBar() {
    Box(
        Modifier.background(Color.Transparent)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            modifier = Modifier
                .padding(8.dp)
                .size(32.dp)
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = MaterialTheme.shapes.small,
                )
        )
    }
}

@Composable
private fun ContentDetail(puppy: Puppy) {
    MainContentText(
        puppy = puppy,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textStyleForName = MaterialTheme.typography.h5
    )
    Spacer(modifier = Modifier.size(16.dp))
    ContentDescription(value = puppy.description)
    ButtonAdopt()
}

@Composable
fun ContentDescription(value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text(text = stringResource(id = R.string.label_description), style = MaterialTheme.typography.h6)
        Spacer(Modifier.size(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            maxLines = 8,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ButtonAdopt() {
    val context = LocalContext.current
    Row(
        Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    context.getString(R.string.detail_message_adoption), Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier
                .padding(all = 16.dp)
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp)
        ) {
            Text(text = stringResource(id = R.string.detail_button_adopt).uppercase())
        }
    }
}
