package com.codepath.mybitfitapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface FoodDAO {

        @Query("SELECT * FROM food_table")
        fun getAll(): Flow<List<FoodEntity>>

        @Insert
        fun insertAll(foodEntry: List<FoodEntity>)
        @Insert
        fun insertOne(foodItem: FoodEntity)

        @Query("DELETE FROM food_table")
        fun deleteAll()

}