package com.ezetap.test.data.customUi.model

import android.os.Parcelable
import com.ezetap.test.data.customUi.model.CustomUiElements
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CustomUIModel(

    @Json(name = "logo-url")
    var logoUrl: String? = null,

    @Json(name = "heading-text")
    var headingText: String? = null,

    @Json(name = "uidata")
    var uidata: List<CustomUiElements>? = null
): Parcelable
