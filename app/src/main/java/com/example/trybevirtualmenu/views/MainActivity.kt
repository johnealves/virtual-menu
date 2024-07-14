package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.MenuAdapter
import com.example.trybevirtualmenu.interfaces.DishListener
import com.example.trybevirtualmenu.models.MenuDatabase

class MainActivity : AppCompatActivity(), DishListener {

    val menuList: RecyclerView by lazy { findViewById(R.id.main_menu) }
    val menu = MenuDatabase.getMenuItems()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuAdapter = MenuAdapter(menu)
        menuAdapter.setDishListener(this)

        menuList.layoutManager = LinearLayoutManager(baseContext)
        menuList.adapter = menuAdapter

    }

    override fun onDishClick(view: View, position: Int) {
        val intent = Intent(baseContext, MenuItemDetailActivity::class.java)
        intent.putExtra("dishId", position + 1)
        startActivity(intent)
    }

}
