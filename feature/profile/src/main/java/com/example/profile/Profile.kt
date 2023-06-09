package com.example.profile

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Profile() {
    Column(Modifier.background(color = Color.Red)) {

    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewProfile() {
    Profile()
}