import kotlin.math.abs
import kotlin.math.sign

class Day2ReactorReportsSolutions {

    private class LevelInfo(
        val isBadLevel: Boolean,
        val dir: Double,
        val delta: Int
    )

    fun puzzle1() {
        val reports = InputParser.parseDay2ReactorReports("day-2-reactor-reports.txt")

        val numSafeReports = reports
            .fold(0)
            { numSafeReports, report -> if (isSafeReport(report)) numSafeReports + 1 else numSafeReports }

        println(numSafeReports)
    }

    private fun isSafeReport(report: List<Int>, skipIndex: Int? = null): Boolean {
        val startIndex = if (skipIndex == 0) 1 else 0
        var dir = getDir(report[startIndex], report[startIndex + 1])

        for ((i, level) in report.withIndex()) {
            if (i == skipIndex || i == startIndex) {
                continue
            }

            val lastLevelIndex = if (i - 1 == skipIndex) i - 2 else i - 1
            val levelInfo = isBadLevel(level, report[lastLevelIndex], dir)

            if (levelInfo.isBadLevel) {
                return false
            }
            dir = levelInfo.dir
        }
        return true
    }

    private fun getDir(num1: Int, num2: Int): Double {
        return sign(0.0 + num2 - num1)
    }

    private fun isBadLevel(level: Int, lastLevel: Int, oldDir: Double?): LevelInfo {
        val newDir = getDir(lastLevel, level)
        val delta = abs(level - lastLevel)
        return LevelInfo((oldDir != null && newDir != oldDir) || delta == 0 || delta > 3, newDir, delta)
    }


    fun puzzle2() {
        val reports = InputParser.parseDay2ReactorReports("day-2-reactor-reports.txt")
//        val reports = listOf(listOf(1, 5, 3, 2, 1))
//        val reports = listOf(listOf(5, 3, 2, 1, 5))

        val numSafeReports = reports
            .fold(0)
            { numSafeReports, report -> run {
                var canBeSafe = isSafeReport(report)
                for ((i, _) in report.withIndex()) {
                    if (canBeSafe) {
                        break
                    }

                    canBeSafe = isSafeReport(report, i)
                }

                return@fold if (canBeSafe) numSafeReports + 1 else numSafeReports
            }}

        println(numSafeReports)
    }
}