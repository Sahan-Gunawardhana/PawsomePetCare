package com.example.pawsomepetcare.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSettings(
    title:String,
    onSettingsClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme
    TopAppBar(
        title = { Text(text =title) },
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
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
                onSettingsClick = {}
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
