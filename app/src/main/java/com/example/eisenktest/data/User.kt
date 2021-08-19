package com.example.eisenktest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testEisenk")
data class User(
    @PrimaryKey
    val id: Int,
    var questions: String,
    @ColumnInfo(name = "questionType")
    var questionType: Int
)