package co.edu.unab.andresardila


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            val scrollBehavior =
                TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Medium Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ExitToApp,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },


        ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                "Promociones", modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    bottom = 8.dp
                )



            )

            val listurl = listOf(
                "https://www.movilexito.com/sites/default/files/2023-03/Mo%CC%81vil%20E%CC%81xito%20-%201x10%20Aniversario%20-%20Banner%20Desktop.png",
                "https://landing.connectbogota.org/wp-content/uploads/2021/02/27012021_Banner_facbrica_de_la_innovacion-1024x304.jpg",
                "https://static.vecteezy.com/system/resources/previews/004/672/772/non_2x/flash-sale-banner-design-template-offer-shopping-on-dark-blue-background-free-vector.jpg",
                "https://w7.pngwing.com/pngs/97/422/png-transparent-super-offer-limited-creative-origami-banner-thumbnail.png",
                "https://static.vecteezy.com/system/resources/previews/004/852/255/non_2x/christmas-sale-banner-design-christmas-limited-time-offer-text-promotion-discount-with-santa-claus-character-for-xmas-holiday-advertising-illustration-vector.jpg"

            )


            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                for (url in listurl){
                    item { CardPromo(url) }
                }


            }

        }

    }


}


@Composable
fun CardPromo(url:String) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(300.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "Promocion",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop

        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}