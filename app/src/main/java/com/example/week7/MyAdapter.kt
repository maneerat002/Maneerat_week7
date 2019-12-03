package com.example.week7

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.model_layout.view.*
import java.lang.Exception

class MyAdapter(var dataList : List<DataModel> , var context: Context)
    : RecyclerView.Adapter<ViewHoleder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoleder {
        return ViewHoleder(LayoutInflater.from(context).inflate(R.layout.model_layout,parent,false))
    }

    override fun getItemCount(): Int {
    return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHoleder, position: Int) {
        try {
            holder?.TextView.text = dataList.get(position).title
            Glide.with(context).load(dataList.get(position).url).into(holder?.imageView)
        }catch (errorVar: Exception){
            Log.e("Error เด้ออ",errorVar.message)
        }
    }
}
class ViewHoleder(view:View): RecyclerView.ViewHolder(view){
    var imageView = view.image_photo
    var TextView = view.tv_title

}