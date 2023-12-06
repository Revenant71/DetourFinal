package com.detour.detourfinal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoDetour {
    /* USERS */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user")
    suspend fun findAllUser(): List<User>

    @Query("SELECT * FROM user WHERE ID=:id")
    suspend fun findByAutoIncrement(id: Int): User

    @Query("SELECT * FROM user WHERE role=:role")
    suspend fun findByRole(role: String): User

    @Query("SELECT * FROM user WHERE name=:name AND password=:pass")
    suspend fun findUser(name: String, pass: String): User

    @Query("SELECT role FROM user WHERE name=:name AND password=:pass")
    suspend fun findUserRole(name: String, pass: String): String

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user")
    suspend fun clearAllUser()

    /* PRODUCTS */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Query("SELECT * FROM item")
    suspend fun findAllItem(): List<Item>

    @Query("SELECT * FROM item WHERE category=:catg")
    suspend fun findByCategory(catg: String): List<Item>

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)
}
