object AsciiArt {
    fun asciiMe() {
        val L = 4
        val H = 5

        val T = "A@n"

        val rows = listOf(
            " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### ",
            "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # ",
            "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## ",
            "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ",
            "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  "
        )

        val asciiLetters: MutableList<MutableList<String>> = mutableListOf()

        for (letterIndex in 0 until 27) {
            asciiLetters.add(mutableListOf())
        }

        for (i in 0 until H) {
            val ROW = rows[i]

            val chunks = ROW.chunked(L)

            for ((chunkIndex, chunk) in chunks.withIndex()) {
                asciiLetters[chunkIndex].add(chunk)
            }
        }

        val asciiIndexes = mutableListOf<Int>()

        for (letter in T) {
            val asciiIndex = when (letter.code) {
                in 65..90 -> {
                    letter.code - 65
                }

                in 97..122 -> {
                    letter.code - 97
                }

                else -> {
                    26
                }
            }

            asciiIndexes.add(asciiIndex)
        }

        val letterRows = mutableListOf<String>()

        for (i in 0 until H) {
            letterRows.add("")
        }

        for (asciiIndex in asciiIndexes) {
            val asciiLetter = asciiLetters[asciiIndex]

            for (height in 0 until H) {
                letterRows[height] += asciiLetter[height]
            }
        }

        for (letterRow in letterRows) {
            println(letterRow)
        }
    }
}