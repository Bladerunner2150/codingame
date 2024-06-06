object ThereIsNoSpoon {
    // https://www.codingame.com/ide/puzzle/there-is-no-spoon-episode-1
    fun spoonMe() {
        val array2d: MutableList<MutableList<String>> = mutableListOf()

        val lines = listOf(
            "0.0.0",
//            "00",
//            "0."
        )

        for (line in lines) {
            val charArray = mutableListOf<String>()

            for (char in line) {
                charArray.add(char.toString())
            }

            array2d.add(charArray)
        }

        for ((rowIndex, row) in array2d.withIndex()) {
            System.err.println(row)

            for ((nodeIndex, node) in row.withIndex()) {
                val nodeExists = node == "0"

                System.err.println("Node exists at current position $nodeIndex: $nodeExists")

                var rightNodeX = -1
                var rightNodeY = -1
                var bottomNodeX = -1
                var bottomNodeY = -1

                if (nodeExists) {
                    for (adj in nodeIndex + 1..<row.size) {
                        val adjacentNodeExists = row[adj] == "0"

                        if (adjacentNodeExists) {
                            rightNodeX = adj
                            rightNodeY = rowIndex
                            break
                        }
                    }

                    for (bot in rowIndex + 1..<array2d.size) {
                        val bottomNodeExists = array2d[bot][nodeIndex] == "0"

                        if (bottomNodeExists) {
                            bottomNodeX = nodeIndex
                            bottomNodeY = bot
                            break
                        }
                    }

                    println("$nodeIndex $rowIndex $rightNodeX $rightNodeY $bottomNodeX $bottomNodeY")
                }
            }
        }
    }
}