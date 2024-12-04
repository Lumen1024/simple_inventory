package com.lumen1024.simpleinventory.domain.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [InventoryItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): InventoryItemDao
}