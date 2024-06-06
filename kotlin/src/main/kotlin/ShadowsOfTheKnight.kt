object ShadowsOfTheKnight {
    fun findBomb() {
        val W = 10 // width of the building.
        val H = 10 // height of the building.
        val N = 6 // maximum number of turns before game over.
        var X0 = 2
        var Y0 = 5

        val directions = listOf(
            "UR",
            "R"
        )

        var left = 0
        var right = W - 1
        var top = 0
        var bottom = H - 1

        for (i in 0 until directions.size) {
            val bombDir =
                directions[i] // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            when {
                bombDir.contains("U") -> bottom = Y0 - 1
                bombDir.contains("D") -> top = Y0 + 1
            }

            when {
                bombDir.contains("L") -> right = X0 - 1
                bombDir.contains("R") -> left = X0 + 1
            }

            X0 = (left + right) / 2
            Y0 = (top + bottom) / 2

            println("$X0 $Y0")
        }
    }
}