package com.example.eisenktest.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM test_Eisenk")
    fun getAllQuestions() : List<User>

    @Query("SELECT * FROM Terms")
    fun getAllTerms(): List<TermsModel>
}