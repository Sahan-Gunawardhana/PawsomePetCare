package com.example.pawsomepetcare.data

import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.model.Favourite
import com.example.pawsomepetcare.model.Product
import com.example.pawsomepetcare.model.Service

class DataSource {
    fun loadPicturesToHome(): List<Product> {
        return listOf<Product>(
            Product("1",R.string.product_1,R.string.product_1_price, R.drawable.product_3),
            Product("2",R.string.product_2,R.string.product_2_price, R.drawable.product_1),
            Product("3",R.string.product_3,R.string.product_3_price, R.drawable.product_4),
            Product("4",R.string.product_4,R.string.product_4_price, R.drawable.product_7),
            Product("5",R.string.product_5,R.string.product_5_price, R.drawable.product_5),
            Product("6",R.string.product_6,R.string.product_6_price, R.drawable.product_2),
        )
    }
    fun loadServiceToServices():List<Service>{
        return listOf<Service>(
            Service("1",R.string.services_c_service_1,R.drawable.services_1),
            Service("1",R.string.services_c_service_2,R.drawable.services_2),
            Service("1",R.string.services_c_service_3,R.drawable.services_3),
            Service("1",R.string.services_c_service_4,R.drawable.services_4),
            Service("1",R.string.services_c_service_5,R.drawable.services_5),
            Service("1",R.string.services_c_service_6,R.drawable.services_6)
        )
    }

    fun loadImagesToFavs():List<Favourite>{
        return listOf<Favourite>(
//            Favourite()
        )
    }
}
