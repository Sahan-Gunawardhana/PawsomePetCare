package com.example.pawsomepetcare.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun LandingScreen(modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Box(
           modifier = Modifier
               .height(450.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.landing_main),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()

                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                colors.background.copy(0.5f),
                                colors.background.copy(1f)
                            ),
                            startY = 0f,
                            endY = 1200f
                        )
                    )

            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.landing_title_1),
                color = colors.onBackground,
                style = typography.titleLarge,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier
                .height(16.dp))
            Text(
                text = stringResource(R.string.landing_title_2),
                color = colors.onBackground,
                style = typography.bodyLarge,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .widthIn(max = 300.dp)
            )
            Spacer(modifier = Modifier
                .height(16.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.primary, // This should use your green color
                    contentColor = colors.onPrimary // Ensure this is set correctly too
                )
            ) {
                Text(
                    text = stringResource(id = R.string.landing_button_text)
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Composable
fun LandingScreenPreview() {
    PawsomePetCareTheme (darkTheme = false) {
        LandingScreen()
    }
}