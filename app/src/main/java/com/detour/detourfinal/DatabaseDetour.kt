package com.detour.detourfinal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Item::class], version=1, exportSchema=false)
abstract class DatabaseDetour : RoomDatabase(){
    abstract fun detourDao():DaoDetour

    companion object{
        @Volatile
        private var INSTANCE : DatabaseDetour? = null;

        fun getDatabase(context: Context) : DatabaseDetour {
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseDetour::class.java,
                    "detour_db"
                ).build()

                INSTANCE = instance
                return instance
            }


        }
    }
}