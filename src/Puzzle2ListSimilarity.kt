class Puzzle2ListSimilarity {
    fun run() {
        val numberLists = InputParser.parseDay1LocationIdLists("location-id-lists.txt")

        val numsToOccurrences = mutableMapOf<Int, Int>()
        numberLists.first
            .forEach { num -> numsToOccurrences[num] = numsToOccurrences.getOrDefault(num, 0) + 1 }

        val similarityScore = numberLists.second
            .fold(0)
            { similarityScore, num2 -> similarityScore + numsToOccurrences.getOrDefault(num2, 0) * num2 }

        println(similarityScore)
    }
}