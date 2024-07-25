package com.example.ticketui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DirectionsBusFilled
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Main Screen
@Composable
fun PaymentScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    var navigateToCheckout by remember { mutableStateOf(false) }

    if (navigateToCheckout && sharedViewModel.selectedCard != null) {
        navController.navigate("checkout_screen")
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            TopBar("Payments")
            Spacer(modifier = Modifier.height(16.dp))
            PaymentDetails()
            Spacer(modifier = Modifier.height(16.dp))
            PaymentMethods()
            Spacer(modifier = Modifier.height(32.dp))
            CardStack(cardData = sharedViewModel.cardData) { card ->
                sharedViewModel.selectedCard = card
                navigateToCheckout = true
            }
        }
    }
}


@Composable
fun TopBar(text: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(36.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /* Handle back navigation */ }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PaymentDetails() {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    Icons.Default.DirectionsBusFilled,
                    contentDescription = "Bus",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "BLR -> NGP", fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Payable Amount", color = Color.Gray, fontWeight = FontWeight.Medium)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Person, contentDescription = "Person", tint = Color.Gray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "1 Adult", fontWeight = FontWeight.Medium, color = Color.Gray)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$ 283",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun PaymentMethods() {
    var selectedMethod by remember { mutableStateOf("Card") }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray.copy(0.4f))
    ) {
        PaymentMethodButton("UPI", selectedMethod == "UPI") { selectedMethod = "UPI" }
        PaymentMethodButton("Card", selectedMethod == "Card") { selectedMethod = "Card" }
        PaymentMethodButton("Net Banking", selectedMethod == "Net Banking") {
            selectedMethod = "Net Banking"
        }
    }
}

@Composable
fun PaymentMethodButton(method: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.White else Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(text = method, color = if (isSelected) Color.Blue else Color.Gray)
    }
}

@Composable
fun CardStack(cardData: List<Pair<String, Brush>>, onCardSelected: (Pair<String, Brush>) -> Unit) {
    // Manage the state for card offsets
    var currentCardData by remember { mutableStateOf(cardData) }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(340.dp)
            .background(Color.Transparent)
            .padding(16.dp)
            .offset(x = -20.dp),
        contentAlignment = Alignment.Center
    ) {
        currentCardData.forEachIndexed { index, cardPair ->
            val card = cardPair.first
            val gradient = cardPair.second
            var offsetY by remember { mutableStateOf(0.dp) }
            val animatedOffsetY by animateDpAsState(
                targetValue = offsetY,
                animationSpec = tween(300),
                label = "cardOffset"
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
                    .offset(y = animatedOffsetY, x = (index * 20).dp)
                    .background(
                        gradient,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragEnd = {
                                if (offsetY > 120.dp) {
                                    offsetY = 500.dp
                                    // Update the card data list
                                    currentCardData = currentCardData - cardPair
                                } else {
                                    offsetY = 0.dp
                                }
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                offsetY += dragAmount.y.dp
                            }
                        )
                    }
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = { onCardSelected(cardPair) }
                        )
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = card,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Card Details",
                        color = Color.White.copy(alpha = 0.7f),
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
    }
}