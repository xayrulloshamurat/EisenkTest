package com.example.eisenktest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aforizmAuthor")
data class AforizmAuthorModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int ,
    var authorName: String
)