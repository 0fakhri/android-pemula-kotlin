package com.kulitekno.submit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kulitekno.submit.listAdapter.ListViewHolder
import java.util.*

class listAdapter(private val listJet: ArrayList<jet>) : RecyclerView.Adapter<ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback?) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val Jet = listJet[position]
        Glide.with(holder.itemView.context)
                .load(Jet.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)
        holder.tvName.text = Jet.name
        holder.tvDetail.text = Jet.detail
        holder.itemView.setOnClickListener {
            onItemClickCallback!!.onItemClicked(listJet[holder.adapterPosition])
            //                Intent move = new Intent(v.getContext(),detail.class);
//                move.putExtra(detail.TITLE,hero.getName());
//                move.putExtra(detail.ISI,hero.getDetail());
//                move.putExtra(detail.img_data,hero.getPhoto());
//                v.getContext().startActivity(move);
        }
    }

    override fun getItemCount(): Int {
        return listJet.size
    }

    inner class ListViewHolder(itemView: View) : ViewHolder(itemView) {
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