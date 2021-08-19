package com.example.eisenktest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_Eisenk")
data class User(
    @PrimaryKey
    val id: Int,
    var questions: String,
    @ColumnInfo(name = "question_type")
    var questionType: Int
)