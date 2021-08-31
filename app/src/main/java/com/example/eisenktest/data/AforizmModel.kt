package com.example.eisenktest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aforizm")
data class AforizmModel(
    @PrimaryKey
    val id: Int,
    var aforizmText: String,
    var authorId: Int
)