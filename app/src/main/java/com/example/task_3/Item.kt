package com.example.task_3

class MoviesItems {
    fun getMoviesItems(): List<Item> {
        return listOf(
            Item("Saving Private Ryan", R.drawable.image1),
            Item("1917", R.drawable.image2),
            Item("Dunkirk", R.drawable.image3),
            Item("Hacksaw Ridge", R.drawable.image4),
            Item("Fury", R.drawable.image5),
            Item("All Quiet On The Western Front", R.drawable.image6),
            Item("The Pianist", R.drawable.image7)
        )
    }
    fun getMoreItems(): List<Item> {
        return listOf(Item("Full Metal Jacket",R.drawable.image8),
            Item("Inglourious Basterds",R.drawable.image9),
            Item("Apocalypse Now",R.drawable.image10)
            )
    }
}

data class Item( val name: String,  val image: Int)


