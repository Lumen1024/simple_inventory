package com.lumen1024.simpleinventory.domain.entity

import androidx.room.PrimaryKey

data class InventoryPlace(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
)
