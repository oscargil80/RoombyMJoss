package com.oscargil80.ejemploroommvvmjoss.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.oscargil80.ejemploroommvvmjoss.models.Personal

@Dao
interface PersonalDao {

   @Query("select * from personal")
    suspend fun getAll():List<Personal>

    @Query("select * from personal where idEmpleado = :id ")
    suspend fun getById(id:Long):Personal

    @Query("select * from personal where nombre like '%'  || :name ||  '%'  or apellido  like '%'  || :name ||  '%'  ")
    suspend fun getByName(name:String):List<Personal>

    @Insert
    suspend fun insert(personas: List<Personal>):List<Long>

    @Update
    suspend fun update (personal: Personal):Int

   @Delete
    suspend fun delete (personal: Personal):Int

}