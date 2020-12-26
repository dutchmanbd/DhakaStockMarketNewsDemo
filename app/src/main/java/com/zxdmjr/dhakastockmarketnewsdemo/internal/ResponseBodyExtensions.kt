package com.zxdmjr.dhakastockmarketnewsdemo.internal

import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject

fun ResponseBody?.toErrorMessage(message: String = Constant.ERROR_UNKNOWN): String {
    return try {
        if (this != null) {
            JSONObject(this.string()).getString("message")
        } else {
            message
        }
    } catch (e: JSONException) {
        e.message ?: message
    }
}