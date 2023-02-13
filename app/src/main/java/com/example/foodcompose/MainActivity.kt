package com.example.foodcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodComposeTheme {
                var isSearching by remember { mutableStateOf(false) }
                val scaffoldState = rememberBottomSheetScaffoldState()
                val shape = RoundedCornerShape(30.dp)
                // A surface container using the 'background' color from the theme
                BottomSheetScaffold(modifier = Modifier
                    .background(appGreen)
                    .wrapContentSize(Alignment.Center), scaffoldState = scaffoldState,
                    sheetShape = shape,
                    sheetContent = {
                        //food Prices
                        val textState = remember { mutableStateOf(TextFieldValue("")) }

                        Column(
                            modifier = Modifier
                                .background(Color.Transparent, shape = shape)
                                .padding(20.dp)
                        ) {
                            SearchBar(textState, { isSearching = !isSearching })
                            Column(
                                verticalArrangement = Arrangement.spacedBy(20.dp),
                                modifier = Modifier
                                    .background(Primary, shape = shape)
                                    .clip(shape)
                            ) {
                                Text(
                                    text = "Recent Orders:",
                                    modifier = Modifier
                                        .padding(15.dp),
                                    style = TextStyle(
                                        color = appGreen,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 30.sp
                                    )
                                )
                                ListItem(list = FoodList.List)
                            }
                        }


                    }
                ) {
                    val textField: String = ""
                    //payment method
                    Column(
                        modifier = Modifier
                            .background(appGreen)
                            .fillMaxHeight()
                    ) {
                        Spacer(modifier = Modifier.padding(30.dp))
                        Row(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Spacer(modifier = Modifier.padding(30.dp))
                            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                                Text(
                                    text = "Jackie Miller",
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    style = TextStyle(
                                        fontFamily = FontFamily.Monospace,
                                        color = Color.White,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                )
                                Text(
                                    text = "jackieMiller@gmail.com",
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    style = TextStyle(color = Color.White)
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.ellipse_5),
                                contentDescription = "profile",
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Spacer(modifier = Modifier.padding(30.dp))
                        }
                        Column {
                            val commonTextSize = TextStyle(color = appGreen, fontWeight = FontWeight.Bold)
                            Card(
                                modifier = Modifier
                                    .padding(30.dp)
                                    .clip(shape)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp, 10.dp)

                                ) {
                                    ThickTitle("Profile Info")
                                    ProfileInfoRow(title = "Age:", text = "26")
                                    ProfileInfoRow(title = "AboutMe:", text = "love Swimming")
                                    ProfileInfoRow(title = "Country/City:", text = "United Kingdom")
                                    ProfileInfoRow(title = "Delivery Address:", text = "Baker's Street 221b c/o Miller")
                                    Column {
                                        CreditField()
                                        CreditField()
                                        CreditField()
                                    }

                                    Button(
                                        content = { Text(text = "Change Info") },
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier
                                            .clip(shape)
                                            .fillMaxWidth()
                                            .padding(30.dp),
                                        shape = rounded30
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    }

}
