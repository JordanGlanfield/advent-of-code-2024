import kotlin.math.abs

class Puzzle1ListDistance {
    fun run() {
        val numberLists = InputParser.parseDay1LocationIdLists("location-id-lists.txt")

        // Sort in ascending order
        val numberList1 = numberLists.first.sorted()
        val numberList2 = numberLists.second.sorted()

        val totalDistance1 = numberList1
            .foldIndexed(0)
            { index, totalDistance, num1 -> totalDistance + abs(num1 - numberList2.get(index)) }

        val totalDistance2 = numberList1
            .zip(numberList2, { num1, num2 -> abs(num2 - num1) })
            .reduce { totalDistance, distance -> totalDistance + distance }

        println(totalDistance1)
        println(totalDistance2)
    }
}