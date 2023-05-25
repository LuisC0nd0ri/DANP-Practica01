package com.luiscv.practica01.MyComponents

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luiscv.practica01.R

@Composable
fun MyImage(uno:String) {

    val img = Image(
        painterResource(
            id = uno.toInt()),
        "Mi foto de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
    )

    return img
}