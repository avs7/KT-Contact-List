package com.example.contactlist.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact-data-table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact-id")
    var id:Int,
    @ColumnInfo(name = "contact-name")
    var name:String,
    @ColumnInfo(name = "contact-email")
    var email:String
)
