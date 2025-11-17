package org.kmp.playground.interviewpractice

interface SpeedInKM{
    fun getSpeedInKM()
}

interface SpeedInMiles{
    fun getSpeedInMiles()
}

class SpeedAdapter(val speedInMiles: SpeedInMiles): SpeedInKM{
    override fun getSpeedInKM() {
        val speedInMiles = speedInMiles.getSpeedInMiles()
        // do work to convert the speed form miles to km
    }
}