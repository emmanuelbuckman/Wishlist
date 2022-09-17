package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import android.util.Log
import android.widget.TextView
import com.example.wishlist.Keyboard.hideKeyboard
import com.example.wishlist.WishlistAdapter

class MainActivity : AppCompatActivity() {
    lateinit var addButton:ExtendedFloatingActionButton
    lateinit var recyclerview:RecyclerView
    lateinit var itemList: ArrayList<wishlistData>
    lateinit var wishlistAdapter: WishlistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameout = findViewById<TextView>(R.id.nametextview)
        val priceout = findViewById<TextView>(R.id.pricetextview)
        val urlout = findViewById<TextView>(R.id.linktextview)

        val inputName = findViewById<EditText>(R.id.itemname)
        val inputPrice = findViewById<EditText>(R.id.price)
        val inputLink = findViewById<EditText>(R.id.link)

        addButton = findViewById<ExtendedFloatingActionButton>(R.id.addButton)

        recyclerview = findViewById<RecyclerView>(R.id.wishlistRV)
        recyclerview.layoutManager = LinearLayoutManager(this)
        itemList = ArrayList()
        wishlistAdapter = WishlistAdapter(this, itemList)
        recyclerview.adapter = wishlistAdapter

        addButton.setOnClickListener{
            hideKeyboard(this)
            val inf = LayoutInflater.from(this)
            val view = inf.inflate(R.layout.wishlist_item, null)
            val itemName = view.findViewById<TextView>(R.id.nametextview)
            val itemPrice = view.findViewById<TextView>(R.id.pricetextview)
            val itemLink = view.findViewById<TextView>(R.id.linktextview)
            val names = itemName.text.toString()
            val prices = itemPrice.text.toString()
            val links = itemLink.text.toString()
            nameout.text = inputName.text.toString()
            priceout.text = inputPrice.text.toString()
            urlout.text = inputLink.text.toString()
            itemList.add(wishlistData("Price: $prices", "Item: :$names", "Link: $links" ))

        }

    }
}