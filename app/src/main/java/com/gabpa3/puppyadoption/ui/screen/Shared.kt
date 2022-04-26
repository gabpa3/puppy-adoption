package com.gabpa3.puppyadoption.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.SubcomposeAsyncImage
import com.gabpa3.puppyadoption.R
import com.gabpa3.puppyadoption.data.Puppy

@Composable
fun PuppyImage(puppy: Puppy, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        model = puppy.photoUrl,
        contentDescription = stringResource(R.string.image_puppy_description),
        contentScale = ContentScale.Crop,
        modifier = modifier,
        loading = {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        },
        error = {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.image_error_description))
        }
    )
}
