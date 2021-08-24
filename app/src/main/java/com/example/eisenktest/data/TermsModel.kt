package com.example.eisenktest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Terms" )
data class TermsModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    var word : String,
    var meaning : String,
    var isFavourite: Int
)