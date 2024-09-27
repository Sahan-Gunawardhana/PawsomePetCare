package com.example.pawsomepetcare.ui.Common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.navigation.Screens
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSettings(
    title:String,
    navController: NavController
) {
    val colors = MaterialTheme.colorScheme
    var showmenu by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    val rotation by animateFloatAsState(
        targetValue = if (showmenu) 180f else 90f,
        animationSpec = tween(durationMillis = 1000)
    )
    TopAppBar(
        title = { Text(text =title) },
        actions = {
            IconButton(onClick = { showmenu = !showmenu }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", modifier = Modifier.graphicsLayer(rotationZ = rotation))
            }
            DropdownMenu(
                offset = DpOffset(60.dp, 0.dp),
                expanded = showmenu,
                onDismissRequest = { showmenu = false },
                modifier = Modifier.background(color = colors.background),
            ) {
                DropdownMenuItem(onClick = { navController.navigate(Screens.FavouritesScreen.route) }) {
                    Text(text = "Favourites")
                }
                DropdownMenuItem(onClick = {
                    navController.navigate(Screens.LoginScreen.route) {
                        popUpTo(Screens.LandingScreen.route) { inclusive = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }) {
                    Text(
                        text = "Log Out",
                        style = typography.labelLarge,
                        fontWeight = FontWeight(900),
                        color = colors.error
                    )
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSettingsWithGreeting(
    onSettingsClick:() -> Unit,
){
    val colors = MaterialTheme.colorScheme
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 33.dp)
        ) {
            Text(
                text = stringResource(R.string.home_greeting),
                style = typography.titleMedium,
                fontWeight = FontWeight(600),
                color = colors.onBackground
            )
            Text(
                text = stringResource(R.string.home_greeting_two),
                style = typography.titleMedium,
                color = colors.onBackground
            )
        }
        TopAppBar(
            title = { Text(text = "") },

            actions = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSettingsWithBack(
    onSettingsClick: () -> Unit,
    onBackArrowClick: () -> Unit
){
    val colors = MaterialTheme.colorScheme
    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarWithBackButtonPreview() {
    PawsomePetCareTheme {
        Surface {
            TopBarSettingsWithBack(
                onBackArrowClick = {},
                onSettingsClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarWithBackButtonPreview2() {
    PawsomePetCareTheme {
        Surface {
            TopBarSettings(
                title = "Profile",
                navController = rememberNavController()
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TopBarWithBackButtonPreview3() {
    PawsomePetCareTheme {
        Surface {
            TopBarSettingsWithGreeting {

            }
        }
    }
}


