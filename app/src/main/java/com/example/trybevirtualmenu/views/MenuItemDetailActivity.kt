package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.models.MenuDatabase
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuItemDetailActivity : AppCompatActivity() {

    private val name: MaterialTextView by lazy { findViewById(R.id.detail_name) }
    private val description: MaterialTextView by lazy { findViewById(R.id.detail_description) }
    private val price: MaterialTextView by lazy { findViewById(R.id.detail_price) }
    private val image: ShapeableImageView by lazy { findViewById(R.id.detail_image) }
    private val buttonBack: Button by lazy { findViewById(R.id.filledButton) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        val dishId = intent.getIntExtra("dishId", 1)
        val dish = MenuDatabase.getItemById(dishId)!!

        name.text = dish.name
        description.text = dish.description
        price.text = "R$ ${dish.price}"
        image.setImageResource(dish.image)

        buttonBack.setOnClickListener() {
            finish()
        }
    }
}
