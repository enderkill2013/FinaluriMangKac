package com.example.finalurimangkac.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalurimangkac.R

class itemsadapter (private val hxh: List<itemsdata>) : RecyclerView.Adapter<itemsadapter.hxh1>(){
    class hxh1(itemView: View): RecyclerView.ViewHolder(itemView){

        val  imageview: ImageView = itemView.findViewById(R.id.hxh)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hxh1 {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.itemsview,parent,false)
        return hxh1(view)
    }


    override fun onBindViewHolder(holder: hxh1, position: Int) {
        val a = hxh[position]
        Glide.with(holder.imageview.context)
            .load(a.url)

            .into(holder.imageview)



    }

    override fun getItemCount(): Int = hxh.size


}
