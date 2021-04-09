package com.ellfors.common.util

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.io.*
import java.lang.reflect.Type


/**
 * JsonUtil
 * 2021-04-02 10:59
 */
object JsonUtil {
    /**
     * 将字符串转换为对象
     *
     * @param json Json字符串
     * @param type 类
     */
    fun <T> json2Obj(json: String?, type: Class<T>?): T? {
        if (json.isNullOrEmpty() || type == null)
            return null
        return Gson().fromJson(json, type)
    }

    fun <T> json2Obj(json: String?, type: Type?): T? {
        if (json.isNullOrEmpty() || type == null)
            return null
        return Gson().fromJson(json, type)
    }

    /**
     * 将字符串转换为数组
     *
     * @param json  Json字符串
     * @param clazz 类
     */
    fun <T> json2List(json: String?, clazz: Class<T>?): ArrayList<T> {
        val type: Type = object : TypeToken<ArrayList<JsonObject?>?>() {}.type
        val jsonObjects: ArrayList<JsonObject> = Gson().fromJson(json, type)
        val arrayList: ArrayList<T> = ArrayList()
        for (jsonObject in jsonObjects) {
            arrayList.add(Gson().fromJson(jsonObject, clazz))
        }
        return arrayList
    }

    /**
     * 将对象转换为Json字符串
     *
     * @param src 对象
     */
    fun obj2Json(src: Any?): String {
        if (src == null)
            return ""
        return Gson().toJson(src)
    }

    /**
     * 获取SD卡中的Json文件内容
     *
     * @param filePath 文件路径
     */
    fun getSDCardJson(filePath: String?): String {
        if (filePath.isNullOrEmpty())
            return ""
        val stringBuilder = StringBuilder()
        try {
            val reader = BufferedReader(InputStreamReader(FileInputStream(File(filePath)), "UTF-8"))
            var str: String?
            while (reader.readLine().also { str = it } != null) {
                stringBuilder.append(str)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }

    /**
     * 得到Assets文件下的json文件中的内容
     *
     * @param fileName 文件名
     * @return Json字符串
     */
    fun getAssetsJson(context: Context, fileName: String?): String {
        if (fileName.isNullOrEmpty())
            return ""
        val stringBuilder = StringBuilder()
        //获得assets资源管理器
        val assetManager: AssetManager = context.assets
        //使用IO流读取json文件内容
        try {
            val bufferedReader = BufferedReader(InputStreamReader(assetManager.open(fileName), "utf-8"))
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }
}