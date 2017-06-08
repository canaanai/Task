package com.canaanai.task.core

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.canaanai.task.core.bean.MediaInfo
import com.canaanai.task.core.databinding.ActivityTaskItemEditorBinding

import com.canaanai.task.core.viewmodels.TaskItemEditorViewModel
import com.yancy.imageselector.ImageConfig
import com.yancy.imageselector.ImageLoader
import com.yancy.imageselector.ImageSelector
import com.yancy.imageselector.ImageSelectorActivity
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.PermissionNo
import com.yanzhenjie.permission.PermissionYes


class TaskItemEditorActivity : AppCompatActivity() {

    object Result{
        @JvmStatic
        val DATA = "data"
    }

    object Extra{
        @JvmStatic
        val TASK_ITEM = "taskItem"
    }

    object RequestCode{
        @JvmStatic
        val IMAGE = 2001
        @JvmStatic
        val Video = 2002
    }

    var viewModel = TaskItemEditorViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityTaskItemEditorBinding>(this, R.layout.activity_task_item_editor)

        viewModel.isCompleted.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {
                val data = Intent()

                data.putExtra(Result.DATA, viewModel.item)
                setResult(Activity.RESULT_OK, data)

                finish()
            }
        })

        viewModel.isCanceled.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(p0: Observable?, p1: Int) {
                finish()
            }
        })

        binding.itemViewModel = viewModel
        binding.button.setOnClickListener {
            if (viewModel.mediaInfo == null){
                selectMedia()
            }else{
                showMedia(viewModel.mediaInfo as MediaInfo)
            }

        }
    }

    private fun showMedia(mediaInfo: MediaInfo){

    }

    private fun selectMedia(){
        AndPermission.with(this@TaskItemEditorActivity)
                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .requestCode(1000)
                .send()
    }

    @PermissionYes(1000)
    private fun storageRequestYes(permissions: ArrayList<String>){
        val imageConfig = ImageConfig.Builder(ImageLoader {
            context, path, imageView -> Glide.with(context).load(path).into(imageView) })
                // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                /*.steepToolBarColor(resources.getColor(R.color.blue))
                // 标题的背景颜色 （默认黑色）
                .titleBgColor(resources.getColor(R.color.blue))
                // 提交按钮字体的颜色  （默认白色）
                .titleSubmitTextColor(resources.getColor(R.color.white))
                // 标题颜色 （默认白色）
                .titleTextColor(resources.getColor(R.color.white))*/
                .build()

        ImageSelector.open(this@TaskItemEditorActivity, imageConfig)
    }

    @PermissionNo(1000)
    private fun storageRequestNo(permissions: ArrayList<String>){
        Toast.makeText(this@TaskItemEditorActivity, "取消操作", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        AndPermission.onRequestPermissionsResult(this@TaskItemEditorActivity, requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                ImageSelector.IMAGE_REQUEST_CODE -> {
                    data?.let {
                        val path = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT)
                        val mediaInfo = MediaInfo(path[0], MediaInfo.MediaType.IMAGE)

                        viewModel.mediaInfo = mediaInfo
                    }
                }
                else -> {}
            }
        }
    }
}
