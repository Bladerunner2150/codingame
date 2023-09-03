object DeathFirstSearch {
    fun ep1() {
        // Only for local development
        val links = arrayOf(arrayOf(1, 2), arrayOf(1, 0))
        val gatewayNodeIndexes = arrayOf(2)
        val turnsWithCurrentBobIndex = arrayOf(1)

        val N = 3 // the total number of nodes in the level, including the gateways
        val L = 2 // the number of links
        val E = 1 // the number of exit gateways

        val graph = Array(N) { mutableListOf<Int>() }
        val allGatewayNodes = mutableListOf<Int>()

        for (link in links) {
            val N1 = link[0] // N1 and N2 defines a link between these nodes
            val N2 = link[1]

            graph[N1].add(N2)
        }

        for (node in gatewayNodeIndexes) {
            val EI = node // the index of a gateway node

            allGatewayNodes.add(EI)
        }

        // Only for debugging purposes
        System.err.println("There are ${graph.size} nodes in the graph")
        var numberOfLinks = 0
        for (node in graph) {
            numberOfLinks += node.size
        }
        System.err.println("There are ${numberOfLinks} links in the graph")
        System.err.println("There are ${allGatewayNodes.size} gateways in the graph")

        // game loop
        for (turn in turnsWithCurrentBobIndex) {
            val SI = turn // The index of the node on which the Bobnet agent is positioned this turn
            System.err.println("This turn the Bobnet agent is at index $SI");

            // Write an action using println()
            // To debug: System.err.println("Debug messages...");

            // Note: only search in BFS from current position until next gateway

            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            println("1 2")
        }
    }
}