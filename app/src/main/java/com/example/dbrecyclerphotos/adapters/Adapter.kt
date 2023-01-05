package com.example.dbrecyclerphotos.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dbrecyclerphotos.R
import com.example.dbrecyclerphotos.fragments.Views

class Adapter (
    var views : List<Views>
) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_2_1,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.invisibleTextView).text = views[position].photo
        holder.itemView.findViewById<TextView>(R.id.textView).text = views[position].title

//        holder.itemView.findViewById<TextView>(R.id.textView1).text = views[position].title
//        holder.itemView.findViewById<EditText>(R.id.editTextUrl).text = views[position].photo

        var imageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
        Glide.with(holder.itemView).load(views[position].photo).into(imageView)    }

    override fun getItemCount(): Int {
        return views.size
    }
}