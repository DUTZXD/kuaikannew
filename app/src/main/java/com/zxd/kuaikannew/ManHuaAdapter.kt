package com.zxd.kuaikannew

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*


/**
 * @auther: zhangxiaodong91
 * @date: 2023/2/1
 */
class ManHuaAdapter(private val context1: Context) : RecyclerView.Adapter<ManHuaViewHolder>() {
    private var data = ArrayList<ManhuaEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManHuaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.manhua_item_layout, parent, false)
        return ManHuaViewHolder(itemView, context1)
    }

    override fun onBindViewHolder(holder: ManHuaViewHolder, position: Int) {
        val entity = data[position]
        holder.bindData(entity)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: ArrayList<ManhuaEntity>) {
        data = newData
        notifyDataSetChanged()
    }
}