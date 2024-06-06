object DrunkenBishop {
    fun burp() {
        val fingerprint = "fc:94:b0:c1:e5:b0:98:7c:58:43:99:76:97:ee:9f:b7"

        val hexes = fingerprint.split(":")
        val bytes = hexes.flatMap { hexToBinary(it) }

        // Grid without borders
        val coordinates = mutableListOf<Coordinates>()

        for (x in 0 until 17) {
            for (y in 0 until 9) {
                coordinates.add(Coordinates(x, y, 0))
            }
        }

        // Starting position of bishop
        var currentCoordinates = coordinates.first { it.x == 8 && it.y == 4 }

        for ((index, byte) in bytes.withIndex()) {
            var moveX = if (byte.last() == '0') -1 else 1
            var moveY = if (byte.first() == '0') -1 else 1

            if (moveX == 1 && currentCoordinates.x == 16 || moveX == -1 && currentCoordinates.x == 0) {
                moveX = 0
            }

            if (moveY == 1 && currentCoordinates.y == 8 || moveY == -1 && currentCoordinates.y == 0) {
                moveY = 0
            }

            val newCoordinates =
                coordinates.first { it.x == currentCoordinates.x + moveX && it.y == currentCoordinates.y + moveY }

            newCoordinates.visitCount++

            if (index == bytes.size - 1) {
                newCoordinates.visitCount = -1
            }

            currentCoordinates = newCoordinates
        }

        // Replace space in rows with replaceAt index, based on the string below for the visit count (with wraparound)
        // 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14
        // .  o  +  =  *  B  O  X  @  %  &  #  /  ^
        val openSsh = " .o+=*BOX@%&#/^"

        val rows = mutableListOf<String>()

        for (y in 0 until 9) {
            val sb = StringBuilder()

            for (x in 0 until 17) {
                val co = coordinates.first { it.x == x && it.y == y }

                val stringToAppend = if (co.x == 8 && co.y == 4) {
                    "S"
                } else if (co.visitCount == -1) {
                    "E"
                } else {
                    openSsh[co.visitCount % openSsh.length]
                }

                sb.append(stringToAppend)
            }

            rows.add(sb.toString())
        }

        println("+---[CODINGAME]---+")
        println(rows.joinToString("\n") { "|$it|" })
        println("+-----------------+")
    }

    fun hexToBinary(hexes: String): List<String> {
        val bits = mutableListOf<String>()

        for (char in hexes.uppercase().reversed()) {
            when (char) {
                '0' -> bits.addAll(listOf("00", "00"))
                '1' -> bits.addAll(listOf("01", "00"))
                '2' -> bits.addAll(listOf("10", "00"))
                '3' -> bits.addAll(listOf("11", "00"))
                '4' -> bits.addAll(listOf("00", "01"))
                '5' -> bits.addAll(listOf("01", "01"))
                '6' -> bits.addAll(listOf("10", "01"))
                '7' -> bits.addAll(listOf("11", "01"))
                '8' -> bits.addAll(listOf("00", "10"))
                '9' -> bits.addAll(listOf("01", "10"))
                'A' -> bits.addAll(listOf("10", "10"))
                'B' -> bits.addAll(listOf("11", "10"))
                'C' -> bits.addAll(listOf("00", "11"))
                'D' -> bits.addAll(listOf("01", "11"))
                'E' -> bits.addAll(listOf("10", "11"))
                'F' -> bits.addAll(listOf("11", "11"))
            }
        }

        return bits
    }

    data class Coordinates(var x: Int, var y: Int, var visitCount: Int)
}