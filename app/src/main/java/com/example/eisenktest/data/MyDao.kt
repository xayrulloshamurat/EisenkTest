package com.example.eisenktest.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyDao {
    @Query("SELECT * FROM test_Eisenk")
    fun getAllQuestions() : List<User>

    @Query("SELECT * FROM Terms")
    fun getAllTerms(): List<TermsModel>

    @Query("SELECT * FROM Terms WHERE word like  :s ")
    fun searchByWord(s: String) : List<TermsModel>

    @Update
    fun updateTerms(termsModel: TermsModel)
}