package com.example.foodcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.foodcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodComposeTheme {
                var isSearching by remember { mutableStateOf(false) }
                val scaffoldState = rememberBottomSheetScaffoldState()
                // A surface container using the 'background' color from the theme
                BottomSheetScaffold(modifier = Modifier
                    .background(appGreen)
                    .wrapContentSize(Alignment.Center), scaffoldState = scaffoldState,
                    sheetShape = rounded30,
                    sheetContent = {
                        //food Prices
                        val textState = remember { mutableStateOf(TextFieldValue("")) }
                        Column(
                            modifier = Modifier
                                .background(Color.Transparent, shape = rounded30)
                                .padding(20.dp)
                        ) {
                            SearchBar(textState) { isSearching = !isSearching }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(20.dp),
                                modifier = Modifier
                                    .background(Primary, shape = rounded30)
                                    .clip(rounded30)
                            ) {
                                ThickTitle(text = "Recent Orders:", appGreen)
                                ListItem(list = FoodList.List)
                            }
                        }
                    }
                ) {
                    //payment method
                    if (scaffoldState.bottomSheetState.isCollapsed) {
                        PaymentMethod()
                    } else {
                        BeforePayment()
                    }
                }
            }
        }
    }

}
