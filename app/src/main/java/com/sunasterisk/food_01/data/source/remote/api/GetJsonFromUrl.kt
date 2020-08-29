package com.sunasterisk.food_01.data.source.remote.api

import android.os.AsyncTask
import com.sunasterisk.food_01.data.source.remote.OnFetchDataJsonListener
import org.json.JSONObject

class GetJsonFromUrl<T> constructor(
    private val listener: OnFetchDataJsonListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg strings: String?): String? {
        return try {
            val parseDataWithJson = ParseDataWithJson()
            parseDataWithJson.getJsonFromUrl(strings[0]).toString()
        } catch (e: Exception) {
            exception = e
            ""
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        if (data != null && !data.isBlank()) {
            val jsonObject = JSONObject(data)
            listener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject, keyEntity) as T)
        } else listener.onError(exception)
    }
}
