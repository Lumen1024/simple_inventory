package com.lumen1024.simpleinventory.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lumen1024.simpleinventory.domain.dao.InventoryItemDao
import com.lumen1024.simpleinventory.domain.entity.InventoryItem

@Database(entities = [InventoryItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): InventoryItemDao
}