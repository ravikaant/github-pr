package com.example.prviewer.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("image")
fun loadImage(imageView : ImageView, imageUrl : String){
    Glide
        .with(imageView)
        .load(imageUrl)
        .circleCrop()
        .into(imageView)
}