package com.srhdp.hisnulmuslim.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(
    tableName = "favorite"
)
data class Favorite(
    @PrimaryKey
    val id:Int? = null,
    val dua_id: Int?= null
)