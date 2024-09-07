package com.example.pawsomepetcare.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.components.SearchBar
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier){
    val colors = MaterialTheme.colorScheme

    Column(
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        SearchBar()
    }
}




@Preview(showBackground = true)
@Composable
fun Preview(){
    PawsomePetCareTheme {
        HomeScreen(navController = rememberNavController())
    }
}