package com.example.ticketui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var selectedCard by mutableStateOf<Pair<String, Brush>?>(null)
    val cardData = listOf(
        Pair("HDFC Neo", Brush.linearGradient(colors = listOf(Color(0xFF00BFA6), Color(0xFF6200EA)))),
        Pair("Axis Titan", Brush.linearGradient(colors = listOf(Color(0xFFE040FB), Color(0xFF8E24AA)))),
        Pair("ICICI Supreme", Brush.linearGradient(colors = listOf(Color(0xFFFF7043), Color(0xFFD32F2F)))),
        Pair("HDFC Supra", Brush.linearGradient(colors = listOf(Color(0xFFFFF176), Color(0xFF42A5F5))))
    )
}
