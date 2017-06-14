package com.canaanai.task.core.bindingAdapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.canaanai.task.core.viewAdapters.RecyclerViewAdapter

/**
 * @author chenp
 * @version 2017-06-14 16:25
 */
object RecyclerViewBindingAdapter {
    @BindingAdapter("itemLayout", "listData", "bindingHolder")
    @JvmStatic fun setAdapter(view: RecyclerView, layoutId: Int, data: List<Any>, bindingHolder: RecyclerViewAdapter.BindingHolder){
        val adapter = RecyclerViewAdapter(view.context)

        adapter.bindingHolder = bindingHolder
        adapter.data = data
        adapter.itemLayoutRes = layoutId

        view.adapter = adapter

    }
}