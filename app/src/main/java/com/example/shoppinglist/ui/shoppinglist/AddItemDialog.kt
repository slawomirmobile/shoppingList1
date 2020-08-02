package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_shopping_item_add.*
import kotlinx.android.synthetic.main.shopping_item.*

class AddItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog (context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_shopping_item_add)

        textView3.setOnClickListener {
            val name = editTextTextPersonName.text.toString()
            val amount = editTextTextPersonName2.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please Write All Informations", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }

        textView2.setOnClickListener {
            cancel()
        }

    }
}