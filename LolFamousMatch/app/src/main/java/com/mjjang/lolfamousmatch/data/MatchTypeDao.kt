package com.mjjang.lolfamousmatch.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MatchTypeDao {
    @Query("SELECT * FROM matchtype WHERE name = :name ORDER BY select_count desc")
    fun getMatchTypeList(name : String): LiveData<List<MatchType>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(matchType: List<MatchType>)

    @Query("DELETE FROM matchtype")
    suspend fun deleteALL()
}