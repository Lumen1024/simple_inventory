package com.lumen1024.simpleinventory.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class InventoryItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val placeId: Long,
    val name: String,
    val count: Int,
)
