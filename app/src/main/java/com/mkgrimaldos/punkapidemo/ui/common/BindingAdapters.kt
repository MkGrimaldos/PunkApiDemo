package com.mkgrimaldos.punkapidemo.ui.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view)
            .load(imageUrl)
            .into(view)
    }
}

@BindingAdapter("app:formatText", "app:formatArguments")
fun setFormattedText(textView: TextView, baseText: String, formatValue: String) {
    textView.text = String.format(baseText, formatValue)
}