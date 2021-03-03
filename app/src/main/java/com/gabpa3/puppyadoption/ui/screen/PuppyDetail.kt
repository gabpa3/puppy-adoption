package com.gabpa3.puppyadoption.ui.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gabpa3.puppyadoption.R
import com.gabpa3.puppyadoption.data.Puppy
import java.util.*

@Composable
fun PuppyDetailScreen(puppy: Puppy) {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) {
        Column {
            PuppyImage(puppy = puppy)
            Spacer(Modifier.size(16.dp))
            ContentDetail(puppy = puppy)
        }
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
    PuppyMainContentText(
        puppy = puppy,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textStyleForName = MaterialTheme.typography.h5
    )
    Spacer(Modifier.size(8.dp))
    ContentDescription(value = puppy.description)
    Spacer(Modifier.size(16.dp))
    ButtonAdopt()
}

@Composable
fun ContentDescription(value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text(text = stringResource(id = R.string.label_description), style = MaterialTheme.typography.h6)
        Spacer(Modifier.size(4.dp))
        Text(text = value, style = MaterialTheme.typography.body1, maxLines = 6)
    }
}

@Composable
fun ButtonAdopt() {
    val context = LocalContext.current
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(
            onClick = { Toast.makeText(context,"You have adopt this pet", Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .padding(all = 16.dp)
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
        ) {
            Text(text = stringResource(id = R.string.button_adopt).toUpperCase(Locale.ROOT))
        }
    }

}
