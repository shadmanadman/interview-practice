package org.kmp.playground.interviewpractice

interface Coffee{
    fun getCosts(): Double
    fun getIngredient(): String
}

class BlackCoffee: Coffee{
    override fun getCosts(): Double = 4.0

    override fun getIngredient(): String = "Black Coffee"
}

abstract class CoffeeDecorator(private val coffeeWrapper: Coffee): Coffee{
    override fun getCosts(): Double {
        return coffeeWrapper.getCosts()
    }

    override fun getIngredient(): String {
        return coffeeWrapper.getIngredient()
    }
}

class MilkDecorator(coffeeWrapper: Coffee): CoffeeDecorator(coffeeWrapper) {
    override fun getCosts(): Double {
        return super.getCosts() + 0.5
    }

    override fun getIngredient(): String {
        return super.getIngredient() + "Milk"
    }
}

class SugerDecorator(coffeeWrapper: Coffee): CoffeeDecorator(coffeeWrapper = coffeeWrapper){
    override fun getCosts(): Double {
        return super.getCosts() + 1.0
    }

    override fun getIngredient(): String {
        return super.getIngredient() + "Suger"
    }
}