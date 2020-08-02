package com.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "shopping_name")
    var Name: String,
    @ColumnInfo(name ="item_amount")
    var Amount: Int)

{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}