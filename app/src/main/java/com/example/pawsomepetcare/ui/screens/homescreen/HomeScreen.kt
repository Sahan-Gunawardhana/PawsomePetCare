package com.example.pawsomepetcare.ui.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.ui.Common.ProductCardOne
import com.example.pawsomepetcare.ui.Common.SearchBar
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier){
    val colors = MaterialTheme.colorScheme
    val ftproducts = DataSource().loadFeaturedProducts()
    val dogProducts = DataSource().loadDogProducts()
    val catProducts = DataSource().loadCatProducts()
    val birdProducts = DataSource().loadBirdProducts()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 0.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ) // Apply padding to the entire column
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.featured),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, bottom = 6.dp),
            style = typography.headlineSmall,
        )
        LazyRow (){
            items(ftproducts) { product ->
                ProductCardOne(product, navController)
            }
        }

        Column(
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.primaryContainer,
                        contentColor = colors.onPrimaryContainer
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        focusedElevation = 8.dp,
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {

                    Text(text = "Dog Supplies", modifier = Modifier.padding(start = 8.dp))
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.primaryContainer,
                        contentColor = colors.onPrimaryContainer
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        focusedElevation = 8.dp,
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                ) {

                    Text(text = "Cat Supplies", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.primaryContainer,
                        contentColor = colors.onPrimaryContainer
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        focusedElevation = 8.dp,
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {

                    Text(text = "Bird Supplies", modifier = Modifier.padding(start = 8.dp))
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.primaryContainer,
                        contentColor = colors.onPrimaryContainer
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        focusedElevation = 8.dp,
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                ) {

                    Text(text = "Other", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            // Dog Suppliers Section
            Text(
                text = "Dog Suppliers",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 8.dp, bottom = 4.dp) // Added padding for better spacing
            )
            LazyRow(
                modifier = Modifier.padding(bottom = 16.dp) // Space between sections
            ) {
                items(dogProducts) { product ->
                    ProductCardOne(product, navController)
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            // Cat Suppliers Section
            Text(
                text = "Cat Suppliers",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 8.dp, bottom = 4.dp) // Added padding for better spacing
            )
            LazyRow(
                modifier = Modifier.padding(bottom = 16.dp) // Space between sections
            ) {
                items(catProducts) { product ->
                    ProductCardOne(product, navController)
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            // Bird Suppliers Section
            Text(
                text = "Bird Suppliers",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 8.dp, bottom = 4.dp) // Added padding for better spacing
            )
            LazyRow(
                modifier = Modifier.padding(bottom = 16.dp) // Space between sections
            ) {
                items(birdProducts) { product ->
                    ProductCardOne(product, navController)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    PawsomePetCareTheme {
        HomeScreen(navController = rememberNavController())
    }
}
