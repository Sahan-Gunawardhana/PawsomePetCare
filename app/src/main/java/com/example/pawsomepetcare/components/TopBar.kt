package com.example.pawsomepetcare.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSettings(
    onSettingsClick:() -> Unit,
){
    val colors = MaterialTheme.colorScheme
   TopAppBar(
       title = { Text(text = "") },
       actions = {
           Button(
               onClick = onSettingsClick,
               modifier = Modifier
                   .size(48.dp)
                   .clip(CircleShape),
               colors = ButtonDefaults.buttonColors(
                   containerColor = colors.secondaryContainer,
                   contentColor = colors.onSecondaryContainer
               ),
               contentPadding = PaddingValues(0.dp)
           ) {
               Icon(
                   imageVector = Icons.Default.Settings,
                   contentDescription = "Settings",
                   modifier = Modifier.size(24.dp))
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
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 36.dp)
        ) {
            Text(
                text = stringResource(R.string.home_greeting),
                style = typography.titleLarge,
                fontWeight = FontWeight(700),
                color = colors.onBackground
            )
            Text(
                text = stringResource(R.string.home_greeting_two),
                style = typography.titleLarge,
                fontWeight = FontWeight(700),
                color = colors.onBackground
            )
        }
        TopAppBar(
            title = { Text(text = "") },

            actions = {
                Button(
                    onClick = onSettingsClick,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.secondaryContainer,
                        contentColor = colors.onSecondaryContainer
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        modifier = Modifier.size(24.dp)
                    )
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
            Button(
                onClick = onBackArrowClick,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.secondaryContainer,
                    contentColor = colors.onPrimaryContainer
                ),
                contentPadding = PaddingValues(0.dp)

            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp),
                )
            }
        },
        actions = {
            Button(
                onClick = onSettingsClick,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.secondaryContainer,
                    contentColor = colors.onSecondaryContainer
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier.size(24.dp))
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
