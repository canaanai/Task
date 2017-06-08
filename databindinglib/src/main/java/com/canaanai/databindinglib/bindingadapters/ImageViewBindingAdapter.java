package com.canaanai.databindinglib.bindingadapters;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author chenp
 * @version 2017-05-05 12:00
 */

public class ImageViewBindingAdapter {
    @BindingAdapter(value = {"thumbUrl", "placeholder"}, requireAll = false)
    public static void setThumb(ImageView view, String path, Drawable placeholder){
        Glide.with(view.getContext())
                .load(path)
                .placeholder(placeholder)
                .into(view);
    }
}
