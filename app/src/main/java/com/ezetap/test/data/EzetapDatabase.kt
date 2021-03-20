package com.ezetap.test.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ezetap.test.BuildConfig
import com.ezetap.test.data.customUi.entity.CustomUIEntity
import com.ezetap.test.data.customUi.dao.CustomUiDao


/**
 * Database helper for ezetap Database
 */
@Database(
    entities = [CustomUIEntity::class],
    version = BuildConfig.VERSION_CODE,
    exportSchema = true
)
@TypeConverters(TypeConverter::class)
abstract class EzetapDatabase : RoomDatabase() {

    /**
     * See [CustomUiDao]
     */
    abstract fun customUiDao(): CustomUiDao


    companion object {

        // For Singleton instantiation
        @Volatile
        internal var instance: EzetapDatabase? = null
            private set

        private const val DATABASE_NAME: String = "Ezetap_Database"

        /**
         * Build and return an instance of [EzetapDatabase]
         */
        fun getInstance(context: Context): EzetapDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): EzetapDatabase {
            return Room.databaseBuilder(context, EzetapDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
