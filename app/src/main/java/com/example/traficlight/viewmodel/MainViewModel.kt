package com.example.traficlight.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.traficlight.rename.TrafficLightMode
import kotlinx.coroutines.Job

class MainViewModel: ViewModel() {
    // current state of traffic light
    var trafficLightMode = MutableLiveData(TrafficLightMode.OFF)
    // current job that's being done (traffic light operating in day mode, night mode)
    var currentJob: Job? = null

    fun setTrafficLightOff() { trafficLightMode.value = TrafficLightMode.OFF }
    fun setTrafficLightDay() { trafficLightMode.value = TrafficLightMode.DAY_MODE }
    fun setTrafficLightNight() { trafficLightMode.value = TrafficLightMode.NIGHT_MODE }

    // cancels job so there won't be 2+ traffic light operations (e.g. day mode and night mode simultaneously)
    fun cancelJob() = currentJob?.cancel()
}