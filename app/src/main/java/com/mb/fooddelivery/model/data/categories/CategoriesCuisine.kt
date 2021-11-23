package com.mb.fooddelivery.model.data.categories

class CategoriesCuisine(
    val name : String
)

fun getCuisineList(): MutableList<CategoriesCuisine> {
    val categories = mutableListOf(
        CategoriesCuisine("Pizza"),
        CategoriesCuisine("Burger"),
        CategoriesCuisine("Bakery"),
        CategoriesCuisine("Dessert"),
        CategoriesCuisine("Worldwide"),
        CategoriesCuisine("Homemade"),
        CategoriesCuisine("Breakfast"),
        CategoriesCuisine("Kebab"),
        CategoriesCuisine("Pasta - Salad"),
        CategoriesCuisine("Doner"),
        CategoriesCuisine("Seafood"),
        CategoriesCuisine("Eastern Kitchen"),
    )
    return categories
}