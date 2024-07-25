package com.oscargil80.ejemploroommvvmjoss.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oscargil80.ejemploroommvvmjoss.dao.PersonalDao
import com.oscargil80.ejemploroommvvmjoss.models.Personal


@Database(
    entities = [Personal::class],
    version = 1
)
abstract class PersonalDb :RoomDatabase(){
    abstract fun personalDao():PersonalDao

}