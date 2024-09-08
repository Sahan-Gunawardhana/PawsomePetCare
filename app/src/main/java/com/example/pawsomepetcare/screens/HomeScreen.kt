package com.example.pawsomepetcare.screens

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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.pawsomepetcare.components.ProductCard
import com.example.pawsomepetcare.components.SearchBar
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier){
    val products = DataSource().loadPicturesToHome()
    Column(
        modifier = Modifier
            .padding(8.dp) // Apply padding to the entire column
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.featured),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp,bottom = 6.dp),
            style = typography.headlineSmall,
        )
        LazyRow {
            items(products) { product ->
                ProductCard(product, navController)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Dog Supplies")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Cat Supplies")
                }
            }
            Spacer(modifier = Modifier.height(8.dp)) // Add spacing between rows of buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Bird Supplies")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Fish Supplies")
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
