import kotlin.math.abs
import kotlin.math.sign

class Day2ReactorReportsSolutions {

    fun puzzle1() {
        val reports = InputParser.parseDay2ReactorReports("day-2-reactor-reports.txt")

        val numSafeReports = reports
            .fold(0)
            { numSafeReports, report -> run {
                var dir = sign(0.0 + report[1] - report[0])

                for ((i, level) in report.withIndex()) {
                    if (i == 0) {
                        continue
                    }

                    val lastLevel = report[i - 1]
                    val newDir = sign(0.0 + level - lastLevel)
                    val delta = abs(level - lastLevel)

                    if (newDir != dir || delta == 0 || delta > 3) {
                        return@fold numSafeReports
                    }
                    dir = newDir
                }
                return@fold numSafeReports + 1
            }}

        println(numSafeReports)
    }
}