package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.interfaces.Dish
import com.example.trybevirtualmenu.interfaces.DishListener
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuAdapter(private val menuItems: List<Dish>): Adapter<MenuAdapter.MenuViewHolder>() {

    var menuListener: DishListener? = null

    fun setDishListener(listener: DishListener) {
        menuListener = listener
    }

    class MenuViewHolder(view: View, menuListener: DishListener?): ViewHolder(view) {
        var name: MaterialTextView = view.findViewById(R.id.item_menu_name)
        val image: ShapeableImageView = view.findViewById(R.id.item_menu_image)

        init {
            view.setOnClickListener() {
                menuListener?.onDishClick(view, bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MenuViewHolder(view, menuListener)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.name.text = menuItems[position].name
        holder.image.setImageResource(menuItems[position].image)
    }

}