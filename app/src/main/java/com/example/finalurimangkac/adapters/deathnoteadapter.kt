package com.example.finalurimangkac.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalurimangkac.R

class deathnoteadapter(private val hxh: ArrayList<deathnotedata>) : RecyclerView.Adapter<deathnoteadapter.iagami>(){
    class iagami(itemView: View): RecyclerView.ViewHolder(itemView){

        val  imageview: ImageView = itemView.findViewById(R.id.hxh)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): iagami {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.deathnoteitem,parent,false)
        return iagami(view)
    }


    override fun onBindViewHolder(holder: iagami, position: Int) {
        val a = hxh[position]
        Glide.with(holder.imageview.context)
            .load(a.url)

            .into(holder.imageview)



    }

    override fun getItemCount(): Int = hxh.size


}