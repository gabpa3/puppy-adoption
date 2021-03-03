package com.gabpa3.puppyadoption.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gabpa3.puppyadoption.R
import com.gabpa3.puppyadoption.data.Puppy
import com.gabpa3.puppyadoption.data.PuppyGenre
import com.gabpa3.puppyadoption.data.setAgeToUI
import com.gabpa3.puppyadoption.ui.toTitleCase
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun HomeScreen(){
    Scaffold() {

    }
}

@Composable
fun PuppyCard(puppy: Puppy) {
    Card(
        modifier = Modifier
            .clickable(onClick = {})
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            Modifier
                .clickable(onClick = {})
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .width(180.dp)) {
                PuppyImage(puppy = puppy)
            }
            PuppyMainContentText(
                puppy = puppy,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                textStyleForName = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun PuppyMainContentText(puppy: Puppy, modifier: Modifier, textStyleForName: TextStyle) {
    Column(modifier) {
        val resourceGenre = if (puppy.genre == PuppyGenre.FEMALE) R.drawable.ic_female else R.drawable.ic_male
        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Image(
                painter = painterResource(id = resourceGenre),
                contentDescription = "genre image")
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
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
       items(puppies) {
            PuppyCard(puppy = it)
        }
    }
}

@Composable
fun PuppyImage(puppy: Puppy) {
    Log.i("PI", "url: "+ puppy.photoUrl)
    GlideImage(
        data = puppy.photoUrl,
        contentDescription = "pet photo",
        loading = {
            Box(Modifier.matchParentSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        },
        error = {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }
    )
}

