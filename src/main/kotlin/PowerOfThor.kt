object PowerOfThor {
    fun regular() {
        val lightX = 3 // the X position of the light of power
        val lightY = 8 // the Y position of the light of power
        val initialTx = 3 // Thor's starting X position
        val initialTy = 6 // Thor's starting Y position

        var newTx = initialTx
        var newTy = initialTy

        // game loop
        while (true) {
            val remainingTurns = 40 // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using println()
            // To debug: System.err.println("Debug messages...");

            var direction = "bla"

            if (newTx == lightX && newTy < lightY) {
                newTy++
                direction = "S"
            } else if (newTx == lightX && newTy > lightY) {
                newTy--
                direction = "N"
            } else if (newTx > lightX && newTy == lightY) {
                newTx--
                direction = "W"
            } else if (newTx < lightX && newTy == lightY) {
                newTx++
                direction = "E"
            } else if (newTx > lightX && newTy < lightY) {
                newTy++
                newTx--
                direction = "SW"
            } else if (newTx > lightX && newTy > lightY) {
                newTy--
                newTx--
                direction = "NW"
            } else if (newTx < lightX && newTy < lightY) {
                newTy++
                newTx++
                direction = "SE"
            } else if (newTx < lightX && newTy > lightY) {
                newTy--
                newTx++
                direction = "NE"
            } else {
                direction = "bla"
            }

            // A single line providing the move to be made: N NE E SE S SW W or NW
            println(direction)
        }
    }

    fun optimal() {
        val a = 3
        val b = 8
        val c = 3
        val d = 6

        var e = c
        var f = d

        while (true) {
            var x = ""
            var y = ""

            if (e > a) {
                x = "W"
                e--
            } else if (e < a) {
                x = "E"
                e++
            }
            if (f > b) {
                y = "N"
                f--
            } else if (f < b) {
                y = "S"
                f++
            }

            println(x + y)
        }
    }

    fun optimalAlt() {
        val a = 3
        val b = 8
        val c = 3
        val d = 6

        var e = c
        var f = d
        while (true) {
            readLine()
            var g = ""
            var h = ""
            when {
                e > a -> {
                    g = "W"
                    e--
                }

                e < a -> {
                    g = "E"
                    e++
                }
            }
            when {
                f > b -> {
                    h = "N"
                    f--
                }

                f < b -> {
                    h = "S"
                    f++
                }
            }
            println(h + g)
        }
    }
}