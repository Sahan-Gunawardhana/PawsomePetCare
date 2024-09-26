
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.ui.component.ProductCard
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(navController: NavController, modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    val products = DataSource().loadPicturesToHome()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        LazyColumn(
        ) {
            items(products) { product ->
                ProductCard(product, navController)
            }
        }
    }

}

@Preview
@Composable
fun pv(){
    PawsomePetCareTheme (darkTheme = false){
        FavouritesScreen(navController = rememberNavController())
    }
}