package com.example.pawsomepetcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pawsomepetcare.model.Product


@Composable
fun ProductCard(product: Product, navController: NavController) {
    val colors = MaterialTheme.colorScheme
    Card(
        onClick = { /* Handle click */ },
        modifier = Modifier
            .width(300.dp) // Fixed width
            .height(320.dp) // Fixed height
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = colors.onBackground,
            disabledContentColor = colors.onBackground,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = product.imageResourceId),
                    contentDescription = stringResource(id = product.name),

                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = shapes.small)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(product.name),
                style = typography.titleMedium,
                modifier = Modifier.padding(start = 0.dp, end = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp, top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = product.price),
                    style = typography.bodyLarge
                )
                Row {
                    Button(
                        onClick = { /* Handle favorite click */ },
                        modifier = Modifier.padding(end = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = colors.onSecondaryContainer,
                            containerColor = colors.secondaryContainer
                        )
                    ) {
                        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favorite", )
                    }
                    Button(
                        onClick = { /* Handle buy click */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colors.primaryContainer,
                            contentColor = colors.onPrimaryContainer,
                        )
                    ) {
                        Text(
                            text = "Buy",
                            style = typography.labelLarge
                        )
                    }
                }
            }
        }
    }
}
