package org.kmp.playground.interviewpractice

data class Box(val animalName:String, val animalType:String, val animalAge:Int,val animalColor: String)

class BoxBuilder(){
    private var animalName: String = ""
    private var animalType: String = ""
    private var animalAge: Int = 0
    private var animalColor: String = ""

    private fun setAnimalName(animalName: String) = apply { this.animalName = animalName }
    private fun setAnimalType(animalType: String) = apply{ this.animalType = animalType }
    private fun setAnimalAge(animalAge: Int) = apply { this.animalAge = animalAge }
    private fun setAnimalColor(animalColor: String) = apply { this.animalColor = animalColor }


    fun build() = Box(animalName, animalType, animalAge, animalColor)
}