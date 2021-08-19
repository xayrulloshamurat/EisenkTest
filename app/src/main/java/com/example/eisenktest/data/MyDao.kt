package com.example.eisenktest

import androidx.room.Dao
import androidx.room.Query
import com.example.eisenktest.data.User

@Dao
interface MyDao {
    @Query("SELECT * FROM testEisenk")
    fun getAllQuestions() : List<User>

    @Query("SELECT * FROM Terms")
    fun getAllTerms(): List<TermsModel>
}