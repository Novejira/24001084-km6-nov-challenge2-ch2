package com.catnip.layoutingexample.layoutingexample.data

import com.example.suek.R
import feature.model.Catalog

interface FoodDataSource {
    fun getFoodMembers(): List<Catalog>
}

class FoodDataSourceImpl() : FoodDataSource {
    override fun getFoodMembers(): List<Catalog> {
        return mutableListOf(
            Catalog(
                name = "Mie Ayam",
                formattedPrice = "Rp 12.000",
                image = R.drawable.img_mieayam,
                foodDesc = "Mie" ,
                addres = "Gg. Hj Senin No.06, RW.09, Kec. Sukmajaya, Kota Depok, Jawa Barat 16412",
                mapURL = ""
            ),
            Catalog(
                name = "Boba",
                formattedPrice = "Rp 15.000",
                image = R.drawable.img_boba,
                foodDesc = "Bulat",
                addres = "Jl. Ruko Anggrek 1 No.18 Blok C1, Tirtajaya, Kec. Sukmajaya, Kota Depok, Jawa Barat 16412",
                mapURL = ""

            ),
        )
    }
}