package com.detour.detourfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = true) val ID:Int?,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "category") val category:String,
)
