package org.kmp.playground.interviewpractice

/**
 * This is wrong. the is anti-pattern.
 * 1. should not use a god object (Sorting Factory)
 * 2. should not use type parameter (sortType)
 */

// This could be an enum.
// we are not using polymorphism on it manyphorm
sealed class SortingType {
    object BubbleSort : SortingType()
    object QuickSort : SortingType()
    object MergeSort : SortingType()
}

interface SortingStrategy<T : Comparable<T>> {
    // Forced sortType
    fun sort(sortType: SortingType, data: List<T>): List<T>
}

class SortingFactory<T : Comparable<T>> : SortingStrategy<T> {
    override fun sort(sortType: SortingType, data: List<T>): List<T> {
        // this violated the open-close principle, if we add a new sorting algorithm, we need to modify this big when
        // we should not touch existing class we need to add new sorting
        return when (sortType) {
            SortingType.BubbleSort -> bubbleSort(data = data)
            SortingType.MergeSort -> quickSort(data = data)
            SortingType.QuickSort -> mergeSort(data = data)
        }

    }

    private fun bubbleSort(data: List<T>): List<T> {
        return data
    }

    private fun quickSort(data: List<T>): List<T> {
        return data
    }

    private fun mergeSort(data: List<T>): List<T> {
        return data
    }
}


////// Correct way
interface SortingStrategyCorrect<T : Comparable<T>> {
    fun sort(data: List<T>): List<T>
    fun speedInML(): Double
}

class BubbleSorting<T: Comparable<T>> : SortingStrategyCorrect<T> {
    override fun sort(data: List<T>): List<T> {
        return data
    }

    override fun speedInML() = 1.0
}


class MergeSorting<T: Comparable<T>>: SortingStrategyCorrect<T>{
    override fun sort(data: List<T>): List<T> {
        return data
    }

    override fun speedInML() = 2.0
}

// We can also do not have this, we can use enum also in perform sort
class Sorter<T: Comparable<T>>(private var sortingStrategy: SortingStrategyCorrect<T>) {
    fun performSort(data: List<T>): List<T> {
        return sortingStrategy.sort(data)
    }
    fun speedInML() = sortingStrategy.speedInML()
}

fun main(){

    val bubbleSort = Sorter<Int>(BubbleSorting())
    bubbleSort.performSort(listOf(1,2,3))
    println(bubbleSort.speedInML())

}
