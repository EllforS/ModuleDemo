package com.ellfors.moduleb.utils

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.ellfors.common.base.BaseApplication
import java.io.File
import java.util.*

/**
 * OpenFileUtil
 * 2021-03-30 17:21
 */
object OpenFileUtil {

    private const val AUTHORITY = "com.ellfors.moduledemo.fileProvider"
//    private const val AUTHORITY = "com.dosmono.common.provider"

    fun openFile(filePath: String?): Intent? {
        if (filePath.isNullOrEmpty())
            return null
        val file = File(filePath)
        if (!file.exists())
            return null
        /* 取得扩展名 */
        val end = file.name.substring(file.name.lastIndexOf(".") + 1, file.name.length)
            .toLowerCase(Locale.getDefault())
        return when (end) {
            "m4a", "mp3", "mid", "xmf", "ogg", "wav", "3gp", "mp4" -> getAudioFileIntent(filePath)
            "jpg", "gif", "png", "jpeg", "bmp" -> getImageFileIntent(filePath)
            "apk" -> getApkFileIntent(filePath)
            "ppt", "pptx" -> getPptFileIntent(filePath)
            "xls", "xlsx" -> getExcelFileIntent(filePath)
            "doc", "docx" -> getWordFileIntent(filePath)
            "pdf" -> getPdfFileIntent(filePath)
            "chm" -> getChmFileIntent(filePath)
            "txt" -> getTextFileIntent(filePath)
            else -> getAllIntent(filePath)
        }
    }

    private fun getAllIntent(param: String): Intent {
        val intent = Intent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.action = Intent.ACTION_VIEW //动作
        val uri = buildUri(param)
        intent.setDataAndType(uri, "*/*")
        return intent
    }

    private fun getApkFileIntent(param: String): Intent {
        val intent = Intent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.action = Intent.ACTION_VIEW
        val uri = buildUri(param)
        intent.setDataAndType(uri, "application/vnd.android.package-archive")
        return intent
    }

    private fun getVideoFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("oneshot", 0)
        intent.putExtra("configchange", 0)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "video/*")
        return intent
    }

    private fun getAudioFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("oneshot", 0)
        intent.putExtra("configchange", 0)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "audio/*")
        return intent
    }

    private fun getHtmlFileIntent(param: String): Intent {
        val uri = buildUri(param)
        val intent = Intent("android.intent.action.VIEW")
        intent.setDataAndType(uri, "text/html")
        return intent
    }

    private fun getImageFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "image/*")
        return intent
    }

    private fun getPptFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint")
        return intent
    }

    private fun getExcelFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "application/vnd.ms-excel")
        return intent
    }

    private fun getWordFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "application/msword")
        return intent
    }

    private fun getChmFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "application/x-chm")
        return intent
    }

    private fun getTextFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri2 = buildUri(param)
        intent.setDataAndType(uri2, "text/plain")
        return intent
    }

    private fun getPdfFileIntent(param: String): Intent {
        val intent = Intent("android.intent.action.VIEW")
        intent.addCategory("android.intent.category.DEFAULT")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val uri = buildUri(param)
        intent.setDataAndType(uri, "application/pdf")
        return intent
    }

    private fun buildUri(path: String?): Uri? {
        if (path == null) return null
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(BaseApplication.context,
                AUTHORITY, File(path))
        } else {
            Uri.fromFile(File(path))
        }
    }
}