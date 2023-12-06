package com.detour.detourfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val ID:Int?,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "password") val pass:String,
    @ColumnInfo(name = "role") val role:String
)
