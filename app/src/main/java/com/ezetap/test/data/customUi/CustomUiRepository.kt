package com.ezetap.test.data.customUi

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import com.ezetap.test.data.customUi.entity.CustomUIEntity
import com.ezetap.test.data.customUi.model.CustomUIModel
import com.ezetap.test.utils.async.ThreadManager
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomUiRepository @Inject constructor(private val customUiApi: CustomUiApi,
                                             private val threadManager: ThreadManager,
                                             private val customUIDataSourceLocal: CustomUIDataSourceLocal) {

    suspend fun saveCustomUIData(customUIModel: CustomUIModel) {
        customUIDataSourceLocal.insertCustomUIData(
            customUIEntity = CustomUIEntity(
                logoUrl = customUIModel.logoUrl,
                headingText = customUIModel.headingText,
                uidata = customUIModel.uidata
            )
        )
    }

    fun getCustomUILiveData(): LiveData<CustomUIEntity> = customUIDataSourceLocal.getCustomUILiveData()

    /**
     * Fetch Custom UI data from Db
     */
    @MainThread
    suspend fun getCustomUIDataFromDB(): CustomUIEntity {
        return withContext(threadManager.io) {
            customUIDataSourceLocal.getCustomUIData()
        }
    }


    /**
     * Fetch custom UI data from remote
     *
     */
    @MainThread
    suspend fun getCustomUis(): Pair<CustomUIModel?, Int> {
        return withContext(threadManager.io) {
            val response = customUiApi.getCustomUi()
            response.body() to response.code()
        }
    }
}