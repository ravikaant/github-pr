package com.example.prviewer.screens.prviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prviewer.model.PRModel

class PRAdapter (private val prList : List<PRModel>?) :
    RecyclerView.Adapter<PRAdapter.PRViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {

    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        if(prList!=null)return prList.size
        return 0;
    }


    class PRViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}