package com.example.prviewer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.prviewer.R
import com.example.prviewer.databinding.PrItemBinding
import com.example.prviewer.model.PRModel
import com.example.prviewer.utils.PrItemClickListener


class PRAdapter (
    private val prList : List<PRModel>?,
    private val itemClickListener: PrItemClickListener
    )
    : RecyclerView.Adapter<PRAdapter.PRViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {
        return PRViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.pr_item,
                        parent, false)
        )
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        holder.prItemBinding.prModel = prList?.get(position)
        holder.prItemBinding.root.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return prList?.size ?: 0
    }

    class PRViewHolder(
         val prItemBinding: PrItemBinding
        )
        : RecyclerView.ViewHolder(prItemBinding.root){

        }
}