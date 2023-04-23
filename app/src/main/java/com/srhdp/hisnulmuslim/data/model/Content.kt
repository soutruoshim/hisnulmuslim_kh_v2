package com.srhdp.hisnulmuslim.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "content"
)
data class Content(
    @PrimaryKey
    val id:Int? = null,
    val name: String?= null
)
