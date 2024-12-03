import java.io.BufferedReader

object InputParser {

    private fun bufferedReaderForFile(filename: String): BufferedReader {
        val resourceAsStream = this::class.java.getResourceAsStream(filename)
            ?: throw RuntimeException("Bad input, couldn't find $filename")

        return resourceAsStream.bufferedReader(Charsets.UTF_8)
    }

    fun parseDay1LocationIdLists(filename: String): Pair<List<Int>, List<Int>> {
        val list1 = ArrayList<Int>()
        val list2 = ArrayList<Int>()

        // TODO - use forEachLine instead
        bufferedReaderForFile(filename).lines()
            .forEach({ line ->
                run {
                    val split = line.split("   ")
                    list1.add(split[0].toInt())
                    list2.add(split[1].toInt())
                }
            })

        return Pair(list1, list2)
    }

    fun parseDay2ReactorReports(filename: String): List<List<Int>> {
        val reports = ArrayList<List<Int>>()

        bufferedReaderForFile(filename)
            .forEachLine { line -> reports.add(line.split(" ").map(String::toInt)) }

        return reports
    }
}