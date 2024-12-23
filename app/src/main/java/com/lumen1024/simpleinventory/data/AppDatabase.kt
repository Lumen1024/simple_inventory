package com.lumen1024.simpleinventory.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lumen1024.simpleinventory.data.dao.ItemDao
import com.lumen1024.simpleinventory.data.dao.PlaceDao
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.entity.InventoryPlace

@Database(entities = [InventoryItem::class, InventoryPlace::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ItemDao(): ItemDao
    abstract fun PlaceDao(): PlaceDao
}