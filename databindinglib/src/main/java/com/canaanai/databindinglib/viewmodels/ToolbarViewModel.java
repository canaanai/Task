package com.canaanai.databindinglib.viewmodels;

import android.databinding.ObservableField;

import com.kelin.mvvmlight.command.ReplyCommand;

import rx.functions.Action0;

/**
 * @author chenp
 * @version 2017-05-04 14:32
 */

public class ToolbarViewModel {
    private OnToolbarActionListener listener;

    public final ObservableField<String> title = new ObservableField<>();

    public final ReplyCommand cmdLeftButtonClicked = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            if (listener != null)
                listener.onLeftButtonClicked();
        }
    });

    public final ReplyCommand cmdRightButtonClicked = new ReplyCommand(new Action0() {
        @Override
        public void call() {
            if (listener != null)
                listener.onRightButtonClicked();
        }
    });

    public void setListener(OnToolbarActionListener listener) {
        this.listener = listener;
    }

    public interface OnToolbarActionListener{
        void onLeftButtonClicked();
        void onRightButtonClicked();
    }
}
