package com.example.pawsomepetcare.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.navigation.Screens
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {

    val colors = MaterialTheme.colorScheme
    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(rememberScrollState())
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
                            startY = 400f,
                            endY = 1200f
                        )
                    )
            )
        }
        Box(
            modifier = Modifier
                .offset(y = (-100).dp) // Move 100 dp up
                .background(colors.background, shape = shapes.small)
                .border(
                    BorderStroke(0.2.dp, colors.primary),
                    shape = shapes.small
                )
                .padding(16.dp)
                .widthIn(max = 300.dp)
                .height(260.dp)
                .align(Alignment.CenterHorizontally),

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .height(IntrinsicSize.Min)

            ) {
                Text(
                    text = stringResource(id = R.string.login_in_title),
                    style = typography.titleLarge,
                    color = colors.onBackground
                )
                Spacer(modifier = Modifier.height(36.dp))
                TextField(
                    value = username.value,
                    onValueChange = {
                        username.value = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.login_name_text_field))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = stringResource(R.string.login_user_name_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent, // Remove underline
                        unfocusedIndicatorColor = Color.Transparent // Remove underline
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.login_password_text_field)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = stringResource(R.string.login_password_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(Screens.HomeScreen.name) },
                    elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 8.dp,
                                focusedElevation = 8.dp,
                                pressedElevation = 8.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.primaryContainer,
                        contentColor = colors.onPrimaryContainer
                    )
                ) {
                    Text(
                        text = stringResource(R.string.login_button_text),
                        style = typography.labelLarge
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.login_redirect_to_sign_up),
                style = typography.bodyMedium,
                color = colors.onBackground
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = stringResource(id = R.string.login_redirect_to_sign_clickable_text),
                style = typography.bodyMedium.copy(color = colors.secondary),
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .clickable {
                        navController.navigate("SignUp")
                    }
            )
        }
    }
}



@Preview
@Composable
fun LoginScreenPreview() {
    PawsomePetCareTheme(darkTheme = false) {
        // Use a dummy NavHostController for preview purposes
        LoginScreen(navController = rememberNavController())
    }
}
