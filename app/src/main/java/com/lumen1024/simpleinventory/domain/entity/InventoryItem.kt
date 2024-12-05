package com.lumen1024.simpleinventory.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class InventoryItem(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val count: Int,
)
