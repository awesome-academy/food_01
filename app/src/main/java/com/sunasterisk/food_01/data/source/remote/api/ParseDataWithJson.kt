package com.sunasterisk.food_01.data.source.remote.api


import com.sunasterisk.food_01.data.model.CategoryEntry
import com.sunasterisk.food_01.data.model.RecipeEntry
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.jvm.Throws

class ParseDataWithJson {

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String? {
        val url = URL(urlString)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            doOutput = true
            connect()
        }

        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }

    fun parseJsonToData(jsonObject: JSONObject?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            val jsonArray = jsonObject?.getJSONArray(keyEntity)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val jsonObjects = jsonArray?.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(jsonObjects, keyEntity)
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String): Any? {
        return try {
            jsonObject?.let {
                when (keyEntity) {
                    CategoryEntry.OBJECT -> PasreJson().categoryParseJson(it)
                    RecipeEntry.OBJECT -> PasreJson().recipeParseJson(it)
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        }
    }

    companion object {
        private const val TIME_OUT = 15000
        private val METHOD_GET = "GET"
    }
}
