package com.arif.hossain.weatherapp

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.arif.hossain.weatherapp.viewmodels.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()

    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                detectUserLocation()
                //Toast.makeText(this, "precise granted", Toast.LENGTH_SHORT).show()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                detectUserLocation()
            //Toast.makeText(this, "approximate granted", Toast.LENGTH_SHORT).show()
            } else -> {
            //Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
        }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION))
    }

    private fun detectUserLocation() {
        getLocation(this) {
            weatherViewModel.setNewLocation(it)
        }
    }
}