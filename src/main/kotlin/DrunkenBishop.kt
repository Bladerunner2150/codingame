object DrunkenBishop {
    fun burp() {
        val fingerprint = "fc:94:b0:c1:e5:b0:98:7c:58:43:99:76:97:ee:9f:b7"

        val rows = listOf(
            "+---[CODINGAME]---+",
            "|                 |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|        S        |",
            "|                 |",
            "|                 |",
            "|                 |",
            "|                 |",
            "+-----------------+"
        )

        val coordinatesXYAndVisitCount = mutableListOf<Triple<Int, Int, Int>>()

        for (x in 0 until 17) {
            for (y in 0 until 9) {
                coordinatesXYAndVisitCount.add(Triple(x, y, 0))
            }
        }

        System.err.println("Coordinates size (should be 153): ${coordinatesXYAndVisitCount.size}")

        println(rows.joinToString("\n"))
    }
}