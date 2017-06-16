package com.canaanai.task.core.viewmodels

import android.databinding.ObservableField
import android.databinding.ObservableLong
import com.canaanai.task.core.bean.MediaInfo
import com.canaanai.task.core.bean.TaskItem
import com.kelin.mvvmlight.command.ReplyCommand
import rx.functions.Action0

/**
 * @author chenp
 * @version 2017-06-08 14:34
 */
class TaskItemViewModel(val item: TaskItem, val isEditState: Boolean = true, val mediaClickedCall: (MediaInfo?) -> Unit = {}) {

    var index = -1

    val desc = ObservableField<String>()
    val mediaUrl = ObservableField<String>()
    val time = ObservableLong()

    val cmdOpenMedia = ReplyCommand<Any>(Action0 { mediaClickedCall(item.mediaInfo) })

    init {
        desc.set(item.desc)
        mediaUrl.set(item.mediaInfo?.path)
        time.set(item.duration)
    }
}