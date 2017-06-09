package com.canaanai.task.core.bindingAdapters

import android.databinding.BindingAdapter
import android.widget.TextView
import com.canaanai.task.core.utils.TimeConvert

/**
 * @author chenp
 * @version 2017-06-09 11:53
 */
object TextViewBindingAdapter {


    @BindingAdapter("secondToHMS")
    @JvmStatic fun setTime(view: TextView, secondTime: Long){
        val times = TimeConvert.durationSecondToHMS(secondTime)
        view.text = "${times[0]}:${times[1]}:${times[2]}"
    }
}