package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class WishlistAdapter(val c:Context, val itemList:ArrayList<wishlistData>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.nametextview)
        val link = view.findViewById<TextView>(R.id.linktextview)
        val price = view.findViewById<TextView>(R.id.pricetextview)

//        init {
//            // Define click listener for the ViewHolder's View.
//            textView = view.findViewById(R.id.textView)
//        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(viewGroup.context)
            val view = inflater.inflate(R.layout.wishlist_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val newArray = itemList[position]
        viewHolder.name.text = newArray.item
        viewHolder.link.text = newArray.link
        viewHolder.price.text = newArray.price

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int{
        return itemList.size
    }

}