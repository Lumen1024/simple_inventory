package com.lumen1024.simpleinventory.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lumen1024.simpleinventory.data.dao.ItemDao
import com.lumen1024.simpleinventory.data.dao.FolderDao
import com.lumen1024.simpleinventory.domain.entity.InventoryItem
import com.lumen1024.simpleinventory.domain.entity.InventoryFolder

@Database(entities = [InventoryItem::class, InventoryFolder::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun folderDao(): FolderDao
}