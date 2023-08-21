import kotlin.math.abs

object KotlinCertificate {
    fun solve() {
        val N = 5

        val inputs = listOf(
            1, -2, -8, 4, 5
        )

        var closest = Int.MAX_VALUE

        for (i in 0 until inputs.size) {
            val t = inputs[i]

            if (abs(t) < abs(closest)) closest = t

            if (abs(t) == abs(closest)) closest = abs(t)
        }

        if (closest == Int.MAX_VALUE) closest = 0

        println(closest)
    }

    fun exercise1() {
        val N = 7899

        var sum = 0

        for (i in 0 until N) {
            if ((i + 1) % 2 == 0) sum += i + 1
        }

        println(sum)
    }

    fun exercise2() {
        val N = 17

        var claps = 0

        for (i in 1 until N + 1) {
            if (i % 7 == 0) {
                claps++
            } else if (i.toString().contains("7")) {
                claps++
            } else {
                var sum = 0

                for (letter in i.toString()) {
                    sum += letter.code - 48
                }

                if (sum != 0 && sum % 7 == 0) {
                    claps++
                }
            }
        }

        println(claps)
    }

    fun exercise3() {
        val rows = listOf(
            "678912345",
            "234567891",
            "?????????",
            "345678912",
            "123456789",
            "456789123",
            "567891234",
            "789123456",
            "891234567"
        )

        val columns = mutableListOf("", "", "", "", "", "", "", "", "")
        var missingRow = ""

        for (i in 0 until 9) {
            val row = rows[i]

            for ((index, letter) in row.withIndex()) {
                columns[index] += letter.toString()
            }
        }

        for (column in columns) {
            var missingNumber = ""

            for (j in 1 until 10) {
                if (!column.contains(j.toString())) missingNumber = j.toString()
            }

            missingRow += missingNumber
        }

        println(missingRow)
    }

    fun exercise4() {
        // Find the distance of all points in a grid compared to two given points
        val width = 10 // width of the grid
        val height = 10 // height of the grid
        val x1 = 4 // X position of point 1
        val y1 = 5 // Y position of point 1
        val x2 = 8 // X position of point 2
        val y2 = 7 // Y position of point 2

        val rows = mutableListOf<String>()

        for (i in 0 until height) {
            var row = ""

            for (j in 0 until width) {
                if ((j == x1 && i == y1) || (j == x2 && i == y2)) {
                    row += "X" // X indicates one of the two given points is here
                } else {
                    // Calculation of the Manhattan distance
                    val d1 = abs(j - x1) + abs(i - y1)
                    val d2 = abs(j - x2) + abs(i - y2)

                    val value = if (d1 == d2) {
                        "0" // 0 = current point is equidistant to the two given points
                    } else if (d1 > d2) {
                        "2" // 2 = current point is closest to given point 2
                    } else {
                        "1" // 1 = current point is closest to given point 1
                    }

                    row += value
                }
            }

            rows.add(row)
        }

        println(rows.joinToString("\n"))
    }
}