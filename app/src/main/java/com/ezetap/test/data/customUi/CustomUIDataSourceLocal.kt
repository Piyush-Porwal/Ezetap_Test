package com.ezetap.test.data.customUi

import androidx.lifecycle.LiveData
import com.ezetap.test.data.customUi.dao.CustomUiDao
import com.ezetap.test.data.customUi.entity.CustomUIEntity
import javax.inject.Inject

/**
 * Local data source to fetch customUI Data
 */
open class CustomUIDataSourceLocal @Inject constructor(
    private val customUIDao: CustomUiDao
) {

    /**
     * Get Custom UI Live Data
     *
     */
    open fun getCustomUILiveData(): LiveData<CustomUIEntity> {
        return customUIDao.getCustomUiLiveData()
    }

    /**
     * Insert Custom UI Data
     *
     */
    open suspend fun insertCustomUIData(customUIEntity: CustomUIEntity) {
        return customUIDao.insert(customUIEntity)
    }

    /**
     * Get custom UI Data
     *
     */
    open suspend fun getCustomUIData(): CustomUIEntity {
        return customUIDao.getCustomUiData()
    }

    /**
     * Delete all data from local db
     *
     */
    open suspend fun deleteAll() {
        customUIDao.nuke()
    }

}
