package com.canaanai.task.core.bindingAdapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.canaanai.task.core.viewAdapters.RecyclerViewAdapter

/**
 * @author chenp
 * @version 2017-06-14 16:25
 */
object RecyclerViewBindingAdapter {
    @BindingAdapter("itemLayout", "listData", "bindingHolder", "footViewLayout", requireAll = false)
    @JvmStatic fun setAdapter(view: RecyclerView, layoutId: Int, data: List<Any>?, bindingHolder: RecyclerViewAdapter.BindingHolder?, footLayId: Int){
        val adapter = RecyclerViewAdapter(view.context)

        if (bindingHolder == null)
            Log.e("RecyclerBindingAdapter", "未设置BindingHolder")
        else
            adapter.bindingHolder = bindingHolder

        if (data != null)
            adapter.data = data

        adapter.itemLayoutRes = layoutId
        adapter.footLayId = footLayId

        view.adapter = adapter
    }
}