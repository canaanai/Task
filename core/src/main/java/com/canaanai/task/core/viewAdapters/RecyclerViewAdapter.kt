package com.canaanai.task.core.viewAdapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author chenp
 * @version 2017-06-14 13:53
 */
class RecyclerViewAdapter(val context: Context):
        RecyclerView.Adapter<RecyclerViewAdapter.TViewHolder>() {

    var itemLayoutRes: Int = 0
    var bindingHolder: BindingHolder? = null
    var data = listOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TViewHolder {
        return TViewHolder(LayoutInflater.from(context).inflate(itemLayoutRes, parent, false))
    }

    override fun onBindViewHolder(holder: TViewHolder?, position: Int) {
        bindingHolder?.onBinding(holder?.binding, position, data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding: ViewDataBinding = DataBindingUtil.bind<ViewDataBinding>(itemView)
    }

    interface BindingHolder{
        fun onBinding(viewDataBinding: ViewDataBinding?, position: Int, data: Any)
    }
}