package com.example.pawsomepetcare.ui.screens

import DatePickerDocked
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.ui.component.leftRight
import com.example.pawsomepetcare.ui.component.rightLeft
import com.example.pawsomepetcare.ui.component.serviceCarousel
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen(navController: NavHostController, modifier: Modifier = Modifier){
    val colors = MaterialTheme.colorScheme
    val services = DataSource().loadServiceToServices()
    val innerScroll = rememberScrollState()
    val petname = remember {
        mutableStateOf( "")
    }
    val petage = remember {
        mutableStateOf("")
    }
    val add_notes = remember {
        mutableStateOf("")
    }
    val drop_date = remember {
        mutableStateOf("")
    }
    val pick_date = remember {
        mutableStateOf("")
    }

    LaunchedEffect (Unit){
        while (true){
            delay(1000)
            innerScroll.animateScrollTo(
                innerScroll.value + 460, animationSpec = tween(durationMillis = 1000)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        serviceCarousel(services = services, navController = navController)
        Text(text = stringResource(id = R.string.services_sub_title), style = typography.titleLarge, textAlign = TextAlign.Center,modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth())
        Text(text = stringResource(id = R.string.services_sub_desc), style = typography.bodyLarge, textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .verticalScroll(innerScroll),
            verticalArrangement = Arrangement.Top
        ) {
            leftRight(titleTitleId = R.string.services_title_3.toString(), titleDescId = R.string.services_title_3_desc.toString(), imageResourceId = R.drawable.services_1.toString())
            rightLeft(titleTitleId = R.string.services_title_3.toString(), titleDescId = R.string.services_title_3_desc.toString(), imageResourceId = R.drawable.services_1.toString())
            leftRight(titleTitleId = R.string.services_title_3.toString(), titleDescId = R.string.services_title_3_desc.toString(), imageResourceId = R.drawable.services_1.toString())
            rightLeft(titleTitleId = R.string.services_title_3.toString(), titleDescId = R.string.services_title_3_desc.toString(), imageResourceId = R.drawable.services_1.toString())
        }
        Text(text = stringResource(id = R.string.services_booking_title),style = typography.titleLarge, textAlign = TextAlign.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = stringResource(id = R.string.booking_petname), modifier = Modifier.weight(1f))
            Text(text = stringResource(id = R.string.booking_petage), modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            TextField(
                value = petname.value,
                onValueChange = {
                    petname.value = it
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
                ),
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = petage.value,
                onValueChange = {
                    petage.value = it
                },
                label = {
                    Text(text = stringResource(id = R.string.login_name_text_field))
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
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
                ),
                modifier = Modifier.weight(1f)
            )
        }
        Text(text = stringResource(id = R.string.booking_petnotes))
        TextField(
            value = petname.value,
            onValueChange = {
                petname.value = it
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
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            shape = shapes.small,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent, // Remove underline
                unfocusedIndicatorColor = Color.Transparent // Remove underline
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column (
                modifier = Modifier.weight(1f)
            ){
                Text(text = stringResource(id = R.string.booking_drop))
                DatePickerDocked()
            }
            Column (
                modifier = Modifier.weight(1f)
            ){
                Text(text = stringResource(id = R.string.booking_drop))
                DatePickerDocked()
            }
        }
    }
}


@Preview
@Composable
fun SP(){
    PawsomePetCareTheme {
        ServicesScreen(navController = rememberNavController())
    }
}