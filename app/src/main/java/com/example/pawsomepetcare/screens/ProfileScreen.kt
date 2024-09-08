package com.example.pawsomepetcare.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Adjust padding as needed
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Profile Information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "John Doe",
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.small) // Apply rounded corners to the Box
                        .background(color = colors.tertiaryContainer) // Apply background color to the Box
                        .padding(32.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp), // Spacing between rows
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Username", style = MaterialTheme.typography.titleMedium)
                            Text(text = "JohnDoe")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Password", style = MaterialTheme.typography.titleMedium)
                            Text(text = "***********")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Email", style = MaterialTheme.typography.titleMedium)
                            Text(text = "johndoe@example.com")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Phone", style = MaterialTheme.typography.titleMedium)
                            Text(text = "+1234567890")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.errorContainer,
                        contentColor = colors.onErrorContainer
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        focusedElevation = 8.dp,
                        defaultElevation = 8.dp,
                        pressedElevation = 8.dp,
                        hoveredElevation = 8.dp
                    )
                ) {
                    Text(text = "Log Out")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Ongoing Activities",
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.small) // Apply rounded corners to the Box
                        .background(color = colors.tertiaryContainer)
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
                        ) {
                            Text(text = "Appointment", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                            Text(text = "2024/01/23", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
                        ) {
                            Text(text = "From")
                            Text(text = "2024/01/25")
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
                        ) {
                            Text(text = "Till")
                            Text(text = "2024/01/30")
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(end = 32.dp, bottom = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colors.errorContainer,
                                contentColor = colors.onErrorContainer
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                focusedElevation = 8.dp,
                                defaultElevation = 8.dp,
                                pressedElevation = 8.dp,
                                hoveredElevation = 8.dp
                            )
                        ) {
                            Text(text = "Cancel")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Order History Section
            Text(text = "Order History", modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.titleLarge)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = colors.tertiaryContainer)
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
                        ) {
                            Text(text = "Order #12341", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                            Text(text = "2024/01/23", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
                        ) {
                            Text(text = "Total")
                            Text(text = "$123.00")
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
                        ) {
                            Text(text = "Arrival")
                            Text(text = "2024/01/30")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(70.dp))
        }
        FloatingActionButton(
            onClick = {

            },
            containerColor = colors.primaryContainer,
            contentColor = colors.onPrimaryContainer,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.Edit, contentDescription = "Edit Profile")
        }
        Spacer(modifier = Modifier.height(150.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    PawsomePetCareTheme(darkTheme = false) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            ProfileScreen(navController = rememberNavController())

        }
    }
}