package com.gabpa3.puppyadoption

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Immutable
    @Parcelize
    data class PuppyDetail(val puppyId: Long) : Destination()
}
//
//class Actions(navigator: Navigator<Destination>)  {
//    val selectPuppy: (Long) -> Unit = { snackId: Long ->
//        navigator.navigate(Destination.SnackDetail(snackId))
//    }
//    val upPress: () -> Unit = {
//        navigator.back()
//    }
//}