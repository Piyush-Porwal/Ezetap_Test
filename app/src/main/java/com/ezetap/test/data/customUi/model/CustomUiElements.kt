package com.ezetap.test.data.customUi.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CustomUiElements(

    @Json(name = "uitype")
    var uiType: String? = null,

    @Json(name = "key")
    var key: String? = null,

    @Json(name = "value")
    var value: String? = null,

    @Json(name = "hint")
    var hint: String? = null
): Parcelable{

}
