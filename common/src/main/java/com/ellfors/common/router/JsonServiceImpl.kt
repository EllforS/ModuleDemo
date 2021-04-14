package com.ellfors.common.router

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.ellfors.common.util.JsonUtil
import java.lang.NullPointerException
import java.lang.reflect.Type

/**
 * ARouter传递Object解析类
 * 2021-04-02 10:43
 */
@Route(path = "/common/json")
class JsonServiceImpl : SerializationService {
    override fun init(context: Context?) {

    }

    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T {
        if (input.isNullOrEmpty() || clazz == null)
            throw NullPointerException("ARouter json or clazz is null!!")
        return JsonUtil.json2Obj(input, clazz)!!
    }

    override fun object2Json(instance: Any?): String {
        return JsonUtil.obj2Json(instance)
    }

    override fun <T : Any?> parseObject(input: String?, clazz: Type?): T {
        if (input.isNullOrEmpty() || clazz == null)
            throw NullPointerException("ARouter json or type is null!!")
        return JsonUtil.json2Obj(input, clazz)!!
    }
}