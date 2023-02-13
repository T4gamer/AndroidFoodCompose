package com.example.foodcompose

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodcompose.ui.theme.FoodComposeTheme
import com.example.foodcompose.ui.theme.FoodList

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
                    .background(Color(0xFF406A52))
                    .wrapContentSize(Alignment.Center), scaffoldState = scaffoldState,
                    sheetContent = {
                        //food Prices
                        val textState = remember { mutableStateOf(TextFieldValue("")) }
                        Column(
                            modifier = Modifier
                                .background(Color.Transparent, shape = shape)
                                .clip(shape)
                        ) {
                            SearchBar(textState, { isSearching = !isSearching })
                            Column(
                                verticalArrangement = Arrangement.spacedBy(20.dp),
                                modifier = Modifier
                                    .background(Color(0xFFECECEC), shape = shape)
                                    .clip(shape)
//                                    .width(300.dp)

                            ) {
                                Text(
                                    text = "Recent Orders:",
                                    modifier = Modifier
                                        .padding(10.dp)
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
                            .background(Color(0xFF406A52))
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

                                    Text(
                                        text = "Profile Info",
                                        modifier = Modifier
                                            .align(Alignment.Start),
                                        style = TextStyle(color = Color(0xFF999999)),
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    Text(
                                        text = "AGE: 26",
                                        modifier = Modifier
                                            .align(Alignment.Start),
                                        style = TextStyle(color = Color(0xFF406A52))
                                    )
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(
                                        text = "About me: Cool,like to swim",
                                        modifier = Modifier.align(Alignment.Start),
                                        style = TextStyle(color = Color(0xFF406A52))
                                    )
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(
                                        text = "Country/City: United Kingdom",
                                        modifier = Modifier
                                            .align(Alignment.Start),
                                        style = TextStyle(color = Color(0xFF406A52))
                                    )
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(
                                        text = "Delivery Address",
                                        modifier = Modifier
                                            .align(Alignment.Start),
                                        style = TextStyle(color = Color(0xFF406A52))
                                    )
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    Text(
                                        text = "Credit & Debit Cards",
                                        modifier = Modifier
                                            .align(Alignment.Start),
                                        style = TextStyle(
                                            color = Color(0xFF999999),
                                            fontWeight = FontWeight.ExtraBold
                                        )
                                    )
                                    Card {
                                        Column() {
                                            Spacer(modifier = Modifier.padding(10.dp))
                                            TextField(
                                                value = textField,
                                                onValueChange = { /*TODO*/ },
                                                modifier = Modifier.clip(shape)
                                            )
                                            Spacer(modifier = Modifier.padding(5.dp))
                                            TextField(
                                                value = textField,
                                                onValueChange = { /*TODO*/ },
                                                modifier = Modifier.clip(shape)
                                            )
                                            Spacer(modifier = Modifier.padding(5.dp))
                                            TextField(
                                                value = textField,
                                                onValueChange = { /*TODO*/ },
                                                modifier = Modifier.clip(shape)
                                            )
                                        }
                                    }
                                    Button(content = { Text(text = "Change Info") },
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier
                                            .clip(shape)
                                            .fillMaxWidth()
                                            .padding(30.dp)
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
