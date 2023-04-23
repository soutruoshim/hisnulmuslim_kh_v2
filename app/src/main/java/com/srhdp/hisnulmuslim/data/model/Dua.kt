package com.srhdp.hisnulmuslim.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "dua"
)
data class Dua(
    @PrimaryKey
    val id:Int? = null,
    val content_id: Int?= null,
    val dua: String?= null,
    val dua_translate: String?= null,
    val ref: String?= null,
    val recollection: String?= null
)
