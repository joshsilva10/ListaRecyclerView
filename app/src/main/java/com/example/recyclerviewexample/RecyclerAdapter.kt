package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private var titles: List<String>, private var desc: List<String>, private var images: List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val  itemTitle : TextView = itemView.findViewById(R.id.tv_title)
        val  itemDesc : TextView = itemView.findViewById(R.id.tv_desc)
        val itemImage : ImageView = itemView.findViewById(R.id.iv_Iview)

        init {
            itemView.setOnClickListener { v : View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "you clicked on ${itemTitle.text} in prosition ${position+1}, naturality ${itemDesc.text}", Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDesc.text = desc[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size

    }

}