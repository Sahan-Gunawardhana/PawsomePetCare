package com.example.pawsomepetcare.ui.screens

import DatePickerDocked
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.navigation.Screens
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme


@Composable
fun SignUpScreen(navController: NavHostController, modifier: Modifier = Modifier){

    val colors = MaterialTheme.colorScheme
    val name = remember {
        mutableStateOf("")
    }
    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val tele = remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(rememberScrollState())
            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Box(
            modifier = Modifier
                .height(450.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.signup_main),
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
                .offset(y = (-300).dp) // Move 100 dp up
                .background(colors.background, shape = shapes.small)
                .border(
                    BorderStroke(0.2.dp, colors.primary),
                    shape = shapes.small
                )
                .padding(16.dp)
                .widthIn(max = 300.dp)
                .height(intrinsicSize = IntrinsicSize.Min)
                .align(Alignment.CenterHorizontally),

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .height(IntrinsicSize.Min)
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.signup_title),
                    style = typography.titleLarge,
                    color = colors.onBackground
                )
                Spacer(modifier = Modifier.height(36.dp))
                TextField(
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.signup_name_text_field))
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
                    value = username.value,
                    onValueChange = {
                        username.value = it
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.signup_user_name_text_field)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = stringResource(R.string.login_password_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),

                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.signup_password_text_field))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = stringResource(R.string.signup_password_desc)
                        )
                    },keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent, // Remove underline
                        unfocusedIndicatorColor = Color.Transparent // Remove underline
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.signup_email)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = stringResource(R.string.signup_email_desc)
                        )
                    },keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),

                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = tele.value,
                    onValueChange = {
                        tele.value = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.signup_tele))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Phone,
                            contentDescription = stringResource(R.string.signup_tele_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent, // Remove underline
                        unfocusedIndicatorColor = Color.Transparent // Remove underline
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                DatePickerDocked()
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(Screens.LoginScreen.name) },
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
                        text = stringResource(R.string.signup_button_text),
                    )
                }

            }


        }
        Text(text = stringResource(id = R.string.signup_redirect_to_sign_up))
    }
}



@Preview
@Composable
fun SNPV(){
    PawsomePetCareTheme {
        SignUpScreen(navController = rememberNavController())
    }
}