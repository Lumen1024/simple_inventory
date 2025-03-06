package com.lumen1024.simpleinventory.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
data class InventoryFolder(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
)
