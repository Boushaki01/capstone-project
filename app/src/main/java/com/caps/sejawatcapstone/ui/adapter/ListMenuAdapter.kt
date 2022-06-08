package com.caps.sejawatcapstone.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.caps.sejawatcapstone.R
import com.caps.sejawatcapstone.model.itemMenu


class ListMenuAdapter(private val data:MutableList<itemMenu> = mutableListOf(),) : RecyclerView.Adapter<ListMenuAdapter.ListViewHolder>() {
    private lateinit var onUserClick: OnItemClickCallback
    var Listt = ArrayList<itemMenu>()

    fun setArrayList(value: ArrayList<itemMenu>) {
        Listt.clear()
        Listt.addAll(value)
        notifyDataSetChanged()
    }

    fun setData(data: MutableList<itemMenu>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: itemMenu)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onUserClick = onItemClickCallback
    }

    class ListViewHolder(verticalView: View) : RecyclerView.ViewHolder(verticalView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.imgView)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.vertical_view, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = Listt[position]
        Glide.with(holder.itemView.context).load(data.img).into(holder.imgPhoto)
        holder.tvName.text = data.nama
//        holder.itemView.setOnClickListener{
//            onUserClick.onItemClicked(Listt[holder.adapterPosition])
//        }
    }

    override fun getItemCount(): Int = Listt.size
}