package com.example.eisenktest.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface MyDao {
    @Query("SELECT * FROM test_Eisenk")
    fun getAllQuestions(): List<User>

    @Query("SELECT * FROM Terms")
    fun getAllTerms(): List<TermsModel>

    @Query("SELECT * FROM Terms WHERE word like  :s ")
    fun searchByWord(s: String): List<TermsModel>

    @Query("SELECT * FROM Terms WHERE id = :id")
    fun searchById(id: Int): TermsModel

    @Query("SELECT * FROM aforizmAuthor")
    fun getAllAforizmAuthor(): List<AforizmAuthorModel>

    @Transaction
    @Query("SELECT * FROM aforizm WHERE authorId =:id")
    fun getAllAforizm(id: Int): List<AforizmAuthorWithAforizm>

    @Query("SELECT * FROM Terms WHERE isFavourite = 1")
    fun getIsFavourite(): List<TermsModel>

    @Update
    fun updateTerms(termsModel: TermsModel)
}