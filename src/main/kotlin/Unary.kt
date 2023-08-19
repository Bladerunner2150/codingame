object Unary {
    fun encode() {
        val MESSAGE = "CC"

        System.err.println("Message is: $MESSAGE")

        var binaryString = ""
        val binaryChunks = mutableListOf<String>()
        var currentChunkIndex = -1
        var outputChunks = mutableListOf<String>()

        for (letter in MESSAGE) {
            val binary = letter.code.toString(2)
            binaryString += binary.padStart(7, '0')
        }

        System.err.println("Binary string is: $binaryString")

        for ((index, digit) in binaryString.withIndex()) {
            if (index == 0 || digit.toString() != binaryChunks[currentChunkIndex].last().toString()) {
                binaryChunks.add(digit.toString())
                currentChunkIndex++
            } else {
                binaryChunks[currentChunkIndex] += digit.toString()
            }
        }

        System.err.println("Binary chunks: $binaryChunks")

        for (chunk in binaryChunks) {
            var output = if (chunk.first().toString() == "1") {
                "0 "
            } else {
                "00 "
            }

            for (char in chunk) {
                output += "0"
            }

            outputChunks.add(output)
        }

        println(outputChunks.joinToString(" "))
    }
}