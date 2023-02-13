package com.example.foodcompose

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodcompose.ui.theme.ImageRow
import com.example.foodcompose.ui.theme.OnPrimary
import com.example.foodcompose.ui.theme.appGreen
import com.example.foodcompose.ui.theme.rounded30
import java.util.Locale
import kotlin.collections.ArrayList

@Composable
fun SearchBar(state: MutableState<TextFieldValue>, onClick: () -> Unit) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() },
        textStyle = TextStyle(color = OnPrimary, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon

                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = rounded30, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = OnPrimary,
            cursorColor = OnPrimary,
            leadingIconColor = OnPrimary,
            trailingIconColor = OnPrimary,
            backgroundColor = MaterialTheme.colors.primary,
            focusedIndicatorColor = OnPrimary,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun SearchList(state: MutableState<TextFieldValue>) {
    val items by remember { mutableStateOf(listOf("pizza", "caffe")) }

    var filteredItems: List<String>
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        val searchedText = state.value.text
        filteredItems = if (searchedText.isEmpty()) {
            items
        } else {
            val resultList = ArrayList<String>()
            for (item in items) {
                if (item.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(item)
                }
            }
            resultList
        }
        items(filteredItems) { filteredItem ->
            SearchListItem(
                ItemText = filteredItem,
                onItemClick = { /*Click event code needs to be implement*/
                }
            )
        }

    }
}


@Composable
fun SearchListItem(ItemText: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(ItemText) })
            .background(colorResource(id = R.color.purple_700))
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = ItemText, fontSize = 18.sp, color = Color.White)
    }
}

@Composable
fun ListItem(list: List<ImageRow>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(list) {
            ItemRow(it)
        }
    }
}

@Composable
fun ItemRow(imageRow: ImageRow) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ItemImage(image = imageRow.image1)
        ItemImage(image = imageRow.image2)
    }
}

@Composable
fun ItemImage(@DrawableRes image: Int) {
    Image(
        painter = painterResource(image), contentDescription = "Image",
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun ProfileInfoRow(title: String, text: String) {
    val titleStyle = TextStyle(color = appGreen, fontWeight = FontWeight.Bold)
    val contextStyle = TextStyle(color = appGreen)
    Spacer(modifier = Modifier.padding(10.dp))
    Row {
        Text(
            text = title,
            modifier = Modifier
                .wrapContentSize(Alignment.CenterStart),
            style = titleStyle
        )
        Text(
            text = text,
            style = contextStyle
        )
    }
}

@Composable
fun ThickTitle(text: String){
    Text(
        text = text,
        modifier = Modifier
            .wrapContentSize(Alignment.CenterStart),
        style = TextStyle(
            color = Color(0xFF999999),
            fontWeight = FontWeight.ExtraBold
        )
    )
}
@Composable
fun CreditField(){
    val text = ""
    Spacer(modifier = Modifier.padding(10.dp))
    TextField(
        value = text,
        onValueChange = { /*TODO*/ },
        shape = rounded30
    )
}
