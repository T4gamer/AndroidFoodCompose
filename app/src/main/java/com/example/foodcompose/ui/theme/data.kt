package com.example.foodcompose.ui.theme

import androidx.annotation.DrawableRes
import com.example.foodcompose.R

data class ImageRow(
    @DrawableRes val image1:Int,
    @DrawableRes val image2:Int,
)
object FoodList{
    val List = listOf<ImageRow>(
        ImageRow(R.drawable.food_content_2,R.drawable.food_content_3),
        ImageRow(R.drawable.food_content_1,R.drawable.food_content_4),
        ImageRow(R.drawable.food_content_5,R.drawable.food_content_6)
    )
}