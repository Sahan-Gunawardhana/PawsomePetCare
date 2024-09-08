package com.example.pawsomepetcare.data

import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.model.Product

class DataSource {
    fun loadPicturesToHome(): List<Product> {
        return listOf<Product>(
            Product("1",R.string.product_1,R.string.product_1_price, R.drawable.dog_food_1),
            Product("2",R.string.product_2,R.string.product_2_price, R.drawable.cat_food_1),
            Product("3",R.string.product_3,R.string.product_3_price, R.drawable.dog_food_2),
            Product("4",R.string.product_4,R.string.product_4_price, R.drawable.dog_toy_1),
            Product("5",R.string.product_5,R.string.product_5_price, R.drawable.dog_food_3),
            Product("6",R.string.product_6,R.string.product_6_price, R.drawable.cat_food_2),
        )
    }

}