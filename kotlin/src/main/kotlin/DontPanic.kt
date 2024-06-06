object DontPanic {
    fun beDepressed() {
        val nbFloors = 1 // number of floors
        val width = 13 // width of the area
        val nbRounds = 100 // maximum number of rounds
        val exitFloor = 0 // floor on which the exit is found
        val exitPos = 2 // position of the exit on its floor
        val nbTotalClones = 10 // number of generated clones
        val nbAdditionalElevators = 0 // ignore (always zero)
        val nbElevators = 0 // number of elevators

        System.err.println("Number of floors: $nbFloors")
        System.err.println("Width: $width")
        System.err.println("Number of rounds: $nbRounds")
        System.err.println("Exit floor: $exitFloor")
        System.err.println("Exit position: $exitPos")
        System.err.println("Total number of clones: $nbTotalClones")
        System.err.println("Number of elevators: $nbElevators")

        val elevatorFloorPosition = mutableMapOf<Int, Int>()

        for (i in 0 until nbElevators) {
            val elevatorFloor = 0 // floor on which this elevator is found
            val elevatorPos = 0 // position of the elevator on its floor

            System.err.println("Elevator ($i) floor: $elevatorFloor")
            System.err.println("Elevator ($i) position: $elevatorPos")

            elevatorFloorPosition[elevatorFloor] = elevatorPos
        }

        var turn = 0

        // game loop
        for (i in 0 until nbRounds) {
            val cloneFloor = 0 // floor of the leading clone
            val clonePos = 9 + turn // position of the leading clone on its floor
            val direction = "RIGHT" // direction of the leading clone: LEFT or RIGHT

            turn++

            System.err.println("Turn number: $turn")
            System.err.println("Leading clone floor: $cloneFloor")
            System.err.println("Leading clone position: $clonePos")
            System.err.println("Leading clone direction: $direction")

            var action = "WAIT"

            if (cloneFloor == exitFloor) {
                if ((clonePos > exitPos && direction == "RIGHT") || (clonePos < exitPos && direction == "LEFT")) {
                    action = "BLOCK"
                }
            } else if (cloneFloor > -1) {
                val elevatorPosition = elevatorFloorPosition[cloneFloor]
                if ((clonePos > elevatorPosition!! && direction == "RIGHT") || (clonePos < elevatorPosition && direction == "LEFT")) {
                    action = "BLOCK"
                }
            }

            println(action) // action: WAIT or BLOCK
        }
    }

    fun beOptimized() {
        val nbFloors = 1 // number of floors
        val width = 13 // width of the area
        val nbRounds = 100 // maximum number of rounds
        val exitFloor = 0 // floor on which the exit is found
        val exitPos = 2 // position of the exit on its floor
        val nbTotalClones = 10 // number of generated clones
        val nbAdditionalElevators = 0 // ignore (always zero)
        val nbElevators = 0 // number of elevators

        System.err.println("Number of floors: $nbFloors")
        System.err.println("Width: $width")
        System.err.println("Number of rounds: $nbRounds")
        System.err.println("Exit floor: $exitFloor")
        System.err.println("Exit position: $exitPos")
        System.err.println("Total number of clones: $nbTotalClones")
        System.err.println("Number of elevators: $nbElevators")

        val elevatorFloorPosition = mutableMapOf<Int, Int>()

        for (i in 0 until nbElevators) {
            val elevatorFloor = 0 // floor on which this elevator is found
            val elevatorPos = 0 // position of the elevator on its floor

            System.err.println("Elevator ($i) floor: $elevatorFloor")
            System.err.println("Elevator ($i) position: $elevatorPos")

            elevatorFloorPosition[elevatorFloor] = elevatorPos
        }

        var turn = 0

        // game loop
        for (i in 0 until nbRounds) {
            val cloneFloor = 0 // floor of the leading clone
            val clonePos = 9 + turn // position of the leading clone on its floor
            val direction = "RIGHT" // direction of the leading clone: LEFT or RIGHT

            turn++

            System.err.println("Turn number: $turn")
            System.err.println("Leading clone floor: $cloneFloor")
            System.err.println("Leading clone position: $clonePos")
            System.err.println("Leading clone direction: $direction")

            var action = "WAIT"

            if (cloneFloor > -1) {
                val targetPos = if (cloneFloor == exitFloor) exitPos else elevatorFloorPosition[cloneFloor]

                if (shouldBlock(clonePos, targetPos!!, direction)) {
                    action = "BLOCK"
                }
            }

            println(action) // action: WAIT or BLOCK
        }
    }

    fun shouldBlock(clonePos: Int, targetPos: Int, direction: String): Boolean {
        return (clonePos > targetPos && direction == "RIGHT") || (clonePos < targetPos && direction == "LEFT")
    }
}