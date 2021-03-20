package com.ezetap.test.data.customUi

import com.ezetap.test.data.customUi.model.CustomUIModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 * Service to make API calls for Customer
 */
interface CustomUiApi {

    /**
     * Get customer of user
     */
    @GET("/mobileapps/android_assignment")
    @Throws(Exception::class)
    suspend fun getCustomUi(): Response<CustomUIModel>

    companion object {
        /**
         * Factory function for [CustomUiApi]
         */
        fun create(retroFit: Retrofit): CustomUiApi = retroFit.create(
            CustomUiApi::class.java
        )
    }
}
