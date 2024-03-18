package com.catnip.layoutingexample.layoutingexample.data

import com.catnip.layoutingexample.layoutingexample.model.Food

interface FoodDataSource {
    fun getFoodMembers(): List<Food>
}

class FoodDataSourceImpl() : FoodDataSource {
    override fun getFoodMembers(): List<Food> {
        return mutableListOf(
            Food(
                name = "Mie Ayam",
                price = "Rp 12.000",
                pictUrl = "https://www.unileverfoodsolutions.co.id/dam/global-ufs/mcos/SEA/calcmenu/recipes/ID-recipes/pasta-dishes/chili-oil-chicken-bakmie/Bakmi%20Ayam1260x700.jpg"
            ),
            Food(
                name = "Boba",
                price = "Rp 15.000",
                pictUrl = "https://i.pinimg.com/originals/96/45/b6/9645b6eea8d4f8f68440120699e918d2.jpg"
            ),
            Food(
                name = "Roti O",
                price = "Rp 18.000",
                pictUrl = "https://doyanresep.com/wp-content/uploads/2019/11/resep-roti-boy.jpg"
            )
        )
    }
}