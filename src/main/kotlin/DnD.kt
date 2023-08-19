object DnD {
    fun calc() {
        val m: MutableList<Pair<String, Int>> = mutableListOf()

        for (i in 0 until 5) {
            val r = "a"
            val d = i + 1

            m.add(Pair(r, d))
        }

        m.sortByDescending { x -> x.second }

        val first = m[0].second / 2
        val fourth = m[3].second * 2

        val dam = first + m[1].second + m[2].second + fourth

        System.err.println(m[0].second)

        println(m[0].first)
        println(m[1].first)
        println(m[2].first)
        println(m[3].first)
        println("$dam")
    }
}