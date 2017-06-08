package com.canaanai.databindinglib.bindingadapters;

import android.databinding.BindingAdapter;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.canaanai.databindinglib.bindingadapters.bean.FlingData;
import com.kelin.mvvmlight.command.ReplyCommand;

/**
 * @author chenp
 * @version 2017-03-07 16:45
 */

public class ViewBindingAdapter {
    @BindingAdapter(value = {"longClickCommand", "doubleClickCommand", "flingCommand", "singleTapCommand"}, requireAll = false)
    public static void setTouchCommand(View view,
                                       final ReplyCommand longClickCommand,
                                       final ReplyCommand doubleClickCommand,
                                       final ReplyCommand<FlingData> flingCommand,
                                       final ReplyCommand singleTapCommand){

        final GestureDetectorCompat gestureDetector = new GestureDetectorCompat(view.getContext(),
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public void onLongPress(MotionEvent e) {
                        if (longClickCommand != null)
                            longClickCommand.execute();
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {

                        if (flingCommand != null){
                            flingCommand.execute(new FlingData(velocityX, velocityY));

                            return true;
                        }

                        return false;
                    }

                    @Override
                    public boolean onDoubleTap(MotionEvent e) {

                        if (doubleClickCommand != null){
                            doubleClickCommand.execute();

                            return true;
                        }

                        return false;
                    }

                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        if (singleTapCommand != null){
                            singleTapCommand.execute();

                            return true;
                        }

                        return false;
                    }

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }
                });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return gestureDetector.onTouchEvent(event);
            }
        });
    }

    @BindingAdapter({"focusChangedCommand"})
    public static void setOnFocusChangedCommand(View view, final ReplyCommand focusChangedCommand){
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (focusChangedCommand != null)
                    focusChangedCommand.execute();
            }
        });
    }
}
