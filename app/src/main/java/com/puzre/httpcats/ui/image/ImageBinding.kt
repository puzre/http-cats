package com.puzre.httpcats.ui.image

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.puzre.httpcats.R
import com.puzre.httpcats.data.model.HttpCat

object ImageBinding {

    @BindingAdapter("image:setImage")
    @JvmStatic
    fun setImage(imageView: ImageView, randomHttpCat: HttpCat?) {
        randomHttpCat?.let {
            val imageUrl = "https://http.cat/${it.code}.jpg"
            Glide.with(imageView.context)
                .load(imageUrl)
                .thumbnail(
                    Glide.with(imageView.context)
                        .load(R.drawable.loading)
                )
                .into(imageView)
        }
    }

}