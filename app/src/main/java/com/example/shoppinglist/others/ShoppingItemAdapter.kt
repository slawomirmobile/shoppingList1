package com.example.shoppinglist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter (var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.Name
        holder.itemView.tvAmount.text = "${curShoppingItem.Amount}"

        holder.itemView.tvDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.tvAdd.setOnClickListener {
            curShoppingItem.Amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.tvMinus.setOnClickListener {
           if (curShoppingItem.Amount > 0) {
               curShoppingItem.Amount--
               viewModel.upsert(curShoppingItem)
           }
        }
    }
}