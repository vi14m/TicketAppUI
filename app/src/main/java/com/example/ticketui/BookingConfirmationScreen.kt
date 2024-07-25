package com.example.ticketui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketui.ui.theme.TicketUITheme

@Composable
fun BookingConfirmationScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.bgg),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff1D2948).copy(0.35f))) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Check Icon",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Booking Done",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
                Ticket(
                    dateFrom = "Nov 20",
                    timeFrom = "21:32",
                    locationFrom = "BLR",
                    dateTo = "Nov 21",
                    timeTo = "08:22",
                    locationTo = "NGP",
                    passengerName = "Jitu Raut",
                    seatNumber = "D12",
                    terminal = "T6",
                    gate = "21",
                    busNumber = "BH29187"
                )
            }
        }

    }

}

@Composable
fun Ticket(
    dateFrom: String,
    timeFrom: String,
    locationFrom: String,
    dateTo: String,
    timeTo: String,
    locationTo: String,
    passengerName: String,
    seatNumber: String,
    terminal: String,
    gate: String,
    busNumber: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = dateFrom, color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = timeFrom, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = locationFrom,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                HorizontalDivider(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.DirectionsBus,
                    contentDescription = "Bus Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                HorizontalDivider(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(10.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = dateTo, color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = timeTo, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = locationTo,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Passenger", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = passengerName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "Seat", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = seatNumber,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Blue
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray.copy(0.6f))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Terminal", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = terminal, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Gate", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = gate, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "Bus Number", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = busNumber, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            DottedLineDivider()
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.barcode),
                    contentDescription = "Barcode",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }

    }
}


class TicketShape(
    private val cutRadius: Dp,
    private val dividerHeight: Dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(path = getPath(size, density))
    }

    private fun getPath(size: Size, density: Density): Path {
        val middleX = size.width / 2
        val cutRadiusPx = with(density) { cutRadius.toPx() }
        val dividerHeightPx = with(density) { dividerHeight.toPx() }
        return Path().apply {
            reset()

            // Draw the top horizontal line
            moveTo(x = 0F, y = 0F)
            lineTo(x = middleX - cutRadiusPx, y = 0F)

            // Draw the left semicircle cutout
            arcTo(
                rect = Rect(
                    left = middleX - cutRadiusPx * 2,
                    top = -cutRadiusPx,
                    right = middleX,
                    bottom = cutRadiusPx
                ),
                startAngleDegrees = 180F,
                sweepAngleDegrees = -180F,
                forceMoveTo = false
            )

            // Draw the vertical line to the top of the divider
            lineTo(x = middleX + cutRadiusPx, y = 0F)
            lineTo(x = middleX + cutRadiusPx, y = dividerHeightPx)

            // Draw the right semicircle cutout
            arcTo(
                rect = Rect(
                    left = middleX,
                    top = -cutRadiusPx,
                    right = middleX + cutRadiusPx * 2,
                    bottom = cutRadiusPx
                ),
                startAngleDegrees = 0F,
                sweepAngleDegrees = -180F,
                forceMoveTo = false
            )

            // Draw the line to the right edge
            lineTo(x = size.width, y = dividerHeightPx)

            // Draw the bottom right corner
            lineTo(x = size.width, y = size.height)

            // Draw the bottom horizontal line
            lineTo(x = 0F, y = size.height)

            // Draw the bottom left corner and close the path
            lineTo(x = 0F, y = dividerHeightPx)
            close()
        }
    }
}


@Composable
fun DottedLineDivider() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        val canvasWidth = size.width
        val dotRadius = 2.dp.toPx() // Convert dp to px
        val spaceBetweenDots = 4.dp.toPx() // Convert dp to px
        var currentX = 0f

        while (currentX < canvasWidth) {
            drawCircle(
                color = Color.Gray,
                radius = dotRadius,
                center = Offset(x = currentX, y = size.height / 2)
            )
            currentX += dotRadius * 2 + spaceBetweenDots
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BookingConfirmationPreview() {
    TicketUITheme {
        BookingConfirmationScreen()
    }
}