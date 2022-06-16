package com.arif.hossain.weatherapp.prefs

import android.content.Context
import android.content.SharedPreferences

class WeatherPreference(context: Context) {
    private lateinit var preference: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val tempUnitStatus = "status"
    init {
        preference = context.getSharedPreferences("weather_prefs", Context.MODE_PRIVATE)
        editor = preference.edit()
    }

    fun setTempUnitStatus(status: Boolean) {
        editor.putBoolean(tempUnitStatus, status)
        editor.commit()
    }

    fun getTempUnitStatus() = preference.getBoolean(tempUnitStatus, false)
}