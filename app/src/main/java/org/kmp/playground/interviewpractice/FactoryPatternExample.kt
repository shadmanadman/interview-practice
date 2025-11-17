package org.kmp.playground.interviewpractice

interface Transport{
    fun delivery()
}

class ShipDeliver: Transport{
    override fun delivery() {
        println("Delivered with ship")
    }
}

class TruckDeliver: Transport{
    override fun delivery() {
        println("Delivered with Truck")
    }

}

abstract class LegisticsCreator{
    abstract fun createTransport(): Transport

    fun deliver(){
        val transport = createTransport()
        transport.delivery()
    }
}

class RoadLegistics: LegisticsCreator(){
    override fun createTransport(): Transport {
        return TruckDeliver()
    }

}

class SeaLegistics: LegisticsCreator(){
    override fun createTransport(): Transport {
        return ShipDeliver()
    }

}

fun main(){
    val roadLegistics : LegisticsCreator = RoadLegistics()
    roadLegistics.deliver()

    val seaLegistics: LegisticsCreator = SeaLegistics()
    seaLegistics.deliver()
}