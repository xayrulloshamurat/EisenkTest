package com.example.eisenktest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eisenktest.data.*

@Database(entities = [User::class, TermsModel::class, AforizmAuthorModel::class , AforizmModel::class], version = 1)
abstract  class MyDatabase:RoomDatabase() {
    companion object{
        lateinit var INSTANCE : MyDatabase
        fun getInstance(context: Context):MyDatabase{
            if(!::INSTANCE.isInitialized){
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java, "questions-database"
                )
                    .allowMainThreadQueries()
                    .createFromAsset("eisenk1.db")
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun questionsDao(): MyDao
}