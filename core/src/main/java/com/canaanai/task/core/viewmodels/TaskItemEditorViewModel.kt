package com.canaanai.task.core.viewmodels

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.canaanai.task.core.bean.MediaInfo
import com.canaanai.task.core.bean.TaskItem
import com.canaanai.task.core.utils.TimeConvert
import com.kelin.mvvmlight.base.ViewModel
import com.kelin.mvvmlight.command.ReplyCommand
import rx.functions.Action0

/**
 * @author chenp
 * @version 2017-05-05 11:31
 */
class TaskItemEditorViewModel : ViewModel {
    val hourValue = ObservableField<String>()
    val minuteValue = ObservableField<String>()
    val secondValue = ObservableField<String>()
    val descValue = ObservableField<String>()
    val mediaPath = ObservableField<String>()
    val isCompleted = ObservableBoolean()
    val isCanceled = ObservableBoolean()

    val cmdTimeFix = ReplyCommand<Any>(Action0 {
        val secondDur = TimeConvert.Companion.durationHMSToSecond(hourValue.get(), minuteValue.get(), secondValue.get())
        val hms = TimeConvert.Companion.durationSecondToHMS(secondDur)

        hourValue.set(hms[0])
        minuteValue.set(hms[1])
        secondValue.set(hms[2])
    })

    val cmdDeleteMedia = ReplyCommand<Any>(Action0 {
        mediaInfo = null
    })

    val cmdComplete = ReplyCommand<Any>(Action0 {
        item = TaskItem(TimeConvert.durationHMSToSecond(
                hourValue.get(),
                minuteValue.get(),
                secondValue.get()),
                descValue.get(), mediaInfo)

        isCompleted.set(true)
    })

    val cmdCancel = ReplyCommand<Any>(Action0 {
        isCanceled.set(true)
    })

    init {

    }

    var mediaInfo: MediaInfo? = null
    set(value) {
        field = value

        if (value != null)
            mediaPath.set(value.path)
        else
            mediaPath.set(null)
    }

    var item: TaskItem? = null
    set(value) {
        field = value

        if (value != null){
            descValue.set(value.desc)
            mediaInfo = value.mediaInfo

            val hms = TimeConvert.durationSecondToHMS(value.duration)
            hourValue.set(hms[0])
            minuteValue.set(hms[1])
            minuteValue.set(hms[2])
        }else{
            hourValue.set("0")
            minuteValue.set("0")
            secondValue.set("0")
            descValue.set("")

            mediaInfo = null
        }
    }
}


