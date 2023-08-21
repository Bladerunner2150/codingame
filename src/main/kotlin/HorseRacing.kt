object HorseRacing {
    fun findStrength() {
        val strengthInputs = listOf(
            5,
            15,
            17,
            3,
            8,
            11,
            28,
            6,
            55,
            7
        )

        var strengths = mutableListOf<Int>()
        var closest = Int.MAX_VALUE

        for (i in 0 until strengthInputs.size) {
            val pi = strengthInputs[i]

            strengths.add(pi)
        }

        val strengthList = strengths.sorted()

        for (i in 0 until strengthList.size - 1) {
            val comparison = strengthList[i + 1] - strengthList[i]
            if (comparison < closest) closest = comparison
        }

        println(closest)
    }
}