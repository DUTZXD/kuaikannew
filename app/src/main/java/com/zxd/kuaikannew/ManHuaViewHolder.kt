package com.zxd.kuaikannew

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zxd.kuaikannew.ManhuaEntity

/**
 * @auther: zhangxiaodong91
 * @date: 2023/2/1
 */
class ManHuaViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {

    private var coverView: ImageView
    private var title: TextView
    private var des: TextView

    init {
        coverView = itemView.findViewById(R.id.cover_iv)
        title = itemView.findViewById(R.id.title_tv)
        des = itemView.findViewById(R.id.des_tv)
    }
    fun bindData(entity: ManhuaEntity?) {
        Glide.with(context).load(entity?.cover).into(coverView)
        title.text = entity?.title
        des.text = entity?.des
    }
}