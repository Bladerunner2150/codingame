object ClashOfCode {
    fun clash() {
        val metals = "Ag 27 Pb 10 Au 5"

        val chunked = metals.split(" ")

        val ag = chunked[1].toInt()
        var pb = chunked[3].toInt()
        val au = chunked[5].toInt()

        val fakeAu = minOf(pb, (au - 1) / 2)
        val totalValue = ag * 10 + (au + fakeAu) * 100 + (pb - fakeAu)

        println("Edward can make $totalValue coins today")
    }

//    fun clash() {
//        val bla = "bla df"
//
//        val chunked = bla.split(" ")
//
//        println(chunked.reversed().joinToString(" "))
//    }
}