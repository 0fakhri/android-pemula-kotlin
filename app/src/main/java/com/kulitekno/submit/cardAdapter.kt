package com.kulitekno.submit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.kulitekno.submit.cardAdapter.CardViewViewHolder
import java.util.*

class cardAdapter(private val listJet: ArrayList<jet>) : RecyclerView.Adapter<CardViewViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback?) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val Jet = listJet[position]
        Glide.with(holder.itemView.context)
                .load(Jet.photo)
                .into(holder.imgPhoto)
        holder.tvName.text = Jet.name
        holder.tvDetail.text = Jet.detail
        holder.itemView.setOnClickListener { onItemClickCallback!!.onItemClicked(listJet[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listJet.size
    }

    inner class CardViewViewHolder(itemView: View) : ViewHolder(itemView) {
        var imgPhoto: ImageView
        var tvName: TextView
        var tvDetail: TextView

        init {
            imgPhoto = itemView.findViewById(R.id.img_item_photo)
            tvName = itemView.findViewById(R.id.tv_item_name)
            tvDetail = itemView.findViewById(R.id.tv_item_detail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: jet?)
    }
}