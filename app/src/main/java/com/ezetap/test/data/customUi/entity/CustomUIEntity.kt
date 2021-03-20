package com.ezetap.test.data.customUi.entity

import androidx.room.*
import com.ezetap.test.data.customUi.model.CustomUIModel
import com.ezetap.test.data.customUi.model.CustomUiElements

@Entity(
    tableName = CustomUIEntity.TABLE_NAME,
    indices = [Index("id", unique = true)]
)
data class CustomUIEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 1,

    @ColumnInfo(name = "logo-url")
    var logoUrl: String? = null,

    @ColumnInfo(name = "heading-text")
    var headingText: String? = null,

    @ColumnInfo(name = "uidata")
    var uidata: List<CustomUiElements>? = null
) {

    fun toModel(): CustomUIModel {
        return CustomUIModel(
            logoUrl = this.logoUrl,
            headingText = this.headingText,
            uidata = this.uidata
        )
    }

    companion object {

        /**
         * Table name to store Custom UI data
         */
        const val TABLE_NAME: String = "customUiEntity"
    }

}

