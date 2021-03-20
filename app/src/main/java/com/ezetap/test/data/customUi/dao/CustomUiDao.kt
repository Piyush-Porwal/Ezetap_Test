package com.ezetap.test.data.customUi.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ezetap.test.data.customUi.entity.CustomUIEntity

@Dao
interface CustomUiDao {
    @Query("Select * From customUiEntity LIMIT 1")
    suspend fun getCustomUiData(): CustomUIEntity

    @Query("Select * From customUiEntity LIMIT 1")
    fun getCustomUiLiveData(): LiveData<CustomUIEntity>

    @Query("Select COUNT(id) From customUiEntity")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customUIEntity: CustomUIEntity)

    @Update
    suspend fun update(customUIEntity: CustomUIEntity)

    @Query("Delete From customUiEntity")
    suspend fun nuke()
}