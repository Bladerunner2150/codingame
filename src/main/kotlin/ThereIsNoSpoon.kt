object ThereIsNoSpoon {
    // https://www.codingame.com/ide/puzzle/there-is-no-spoon-episode-1
    fun spoonMe() {
        //    val input = Scanner(System.`in`)
//    val width = input.nextInt() // the number of cells on the X axis
//    val height = input.nextInt() // the number of cells on the Y axis

        val height = 2
        val width = 2

        val array2d: MutableList<MutableList<String>> = mutableListOf()

//    if (input.hasNextLine()) {
//        input.nextLine()
//    }

        val lines = listOf(
            "00",
            "0."
        ) // TEMP

        for (i in 0 until height) {
//        val line = input.nextLine() // width characters, each either 0 or .
            val line = lines[i] // TEMP

            val charArray = mutableListOf<String>()

            for (char in line) {
                charArray.add(char.toString())
            }

            array2d.add(charArray)
        }

        for (row in array2d) {
            println(row)

            for ((index, node) in row.withIndex()) {  // Using withIndex() to get both index and the element
                val nodeExists = node == "0"

                println("Node exists at current position $index: $nodeExists")

                if (nodeExists) {
                    // GET right and bottom
                    // print coordinates

                    // Check for valid right index
                    val rightIndex = index + 1
                    val rightNodeExists = rightIndex < row.size && row[rightIndex] == "0"

                    // Check for valid bottom index
                    val rowIndex = array2d.indexOf(row)
                    val bottomIndex = rowIndex + 1
                    val bottomNodeExists = bottomIndex < array2d.size && array2d[bottomIndex][index] == "0"

                    println("Node exists to the right of current position: $rightNodeExists")
                    println("Node exists to the bottom of current position: $bottomNodeExists")

                    val rightNodeX = if (rightIndex < row.size && rightNodeExists) {
                        rightIndex
                    } else {
                        -1
                    }
                    val rightNodeY = if (rightIndex < row.size && rightNodeExists) {
                        rowIndex
                    } else {
                        -1
                    }
                    val bottomNodeX = if (bottomIndex < array2d.size && bottomNodeExists) {
                        index
                    } else {
                        -1
                    }
                    val bottomNodeY = if (bottomIndex < array2d.size && bottomNodeExists) {
                        bottomIndex
                    } else {
                        -1
                    }

                    println("$index $rowIndex $rightNodeX $rightNodeY $bottomNodeX $bottomNodeY")
                }
            }
        }

//        val currentNodeX = 0
//        val currentNodeY = 0
//        val rightNodeX = 1
//        val rightNodeY = 0
//        val bottomNodeX = 0
//        val bottomNodeY = 1
//
//
//        // Three coordinates: a node, its right neighbor, its bottom neighbor
//        println("$currentNodeX $currentNodeY $rightNodeX $rightNodeY $bottomNodeX $bottomNodeY")
    }
}