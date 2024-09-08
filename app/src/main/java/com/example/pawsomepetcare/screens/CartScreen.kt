package com.example.pawsomepetcare.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun CartScreen(navController: NavController, modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 0.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // First Cart Item
        CartItem(
            imageResourceId = R.drawable.dog_food_2,
            itemName = stringResource(id = R.string.product_1),
            itemPrice = stringResource(id = R.string.product_1_price),
            quantity = "x2",
            onDeleteClick = { /*TODO*/ }
        )
        CartItem(
            imageResourceId = R.drawable.cat_food_2,
            itemName = stringResource(id = R.string.product_2),
            itemPrice = stringResource(id = R.string.product_2_price),
            quantity = "x1",
            onDeleteClick = { /*TODO*/ }
        )
        CartItem(
            imageResourceId = R.drawable.dog_food_1,
            itemName = stringResource(id = R.string.product_3),
            itemPrice = stringResource(id = R.string.product_3_price),
            quantity = "x2",
            onDeleteClick = { /*TODO*/ }
        )
        CartItem(
            imageResourceId = R.drawable.dog_toy_1,
            itemName = stringResource(id = R.string.product_4),
            itemPrice = stringResource(id = R.string.product_4_price),
            quantity = "x2",
            onDeleteClick = { /*TODO*/ }
        )
        CartItem(
            imageResourceId = R.drawable.dog_food_3,
            itemName = stringResource(id = R.string.product_5),
            itemPrice = stringResource(id = R.string.product_5_price),
            quantity = "x5",
            onDeleteClick = { /*TODO*/ }
        )
        Spacer(modifier = Modifier
            .height(0.7.dp)
            .background(color = Color.Black)
            .fillMaxWidth())
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Sub-total")
            Text(text = "$210.00")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Shipping")
            Text(text = "$14.00")
        }
        Spacer(modifier = Modifier
            .height(1.dp)
            .background(color = Color.Black)
            .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(text = "Total", style = typography.titleLarge)
            Text(text = "$224.00",style = typography.titleLarge)
        }
        Spacer(modifier = Modifier
            .height(1.dp)
            .background(color = Color.Black)
            .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.errorContainer,
                    contentColor = colors.onErrorContainer
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    focusedElevation = 8.dp
                )
            ) {
                Text(text = "Continue Browsing")
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.primaryContainer,
                    contentColor = colors.onPrimaryContainer
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    focusedElevation = 8.dp
                )
            ) {
                Text(text = "Proceed to Checkout")
            }
        }
    }
}

@Composable
fun CartItem(
    imageResourceId: Int,
    itemName: String,
    itemPrice: String,
    quantity: String,
    onDeleteClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(shape = shapes.small),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(text = itemName, style = MaterialTheme.typography.bodyLarge)
            Text(text = itemPrice, style = MaterialTheme.typography.bodyMedium)
        }
        IconButton(onClick = onDeleteClick) {
            Icon(imageVector = Icons.Outlined.Delete, contentDescription = null)
        }
        Text(text = quantity, style = MaterialTheme.typography.bodyLarge)
    }
    Spacer(modifier = Modifier
        .height(0.2.dp)
        .background(color = colors.onBackground)
        .fillMaxWidth())
}


@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    // Use a dummy NavController for preview purposes
    PawsomePetCareTheme {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            val navController = rememberNavController()
            CartScreen(navController = navController)
        }
    }
}