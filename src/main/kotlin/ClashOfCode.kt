object ClashOfCode {
    fun clash() {

    }
    
//    fun clash() {
//        var s = "ayak"
//
//        while (true) {
//            val t = s.chunked(s.length / 2)
//
//            if (t.first().dropLast(1) != t.last().reversed() && t.first() != t.last().reversed()) {
//                s = t.last().last() + s
//            } else {
//                break
//            }
//        }
//
//        println(s)
//    }

//    fun clash() {
//        val s = "AAAABBBCCDAA"
//
//        var t = mutableListOf<String>()
//
//        var currentIndex = -1
//
//        for ((i, l) in s.withIndex()) {
//            if (i == 0 || t[currentIndex].last() != l) {
//                t.add(l.toString())
//                currentIndex++
//            } else {
//                t[currentIndex] += l.toString()
//            }
//        }
//
//        println(t.joinToString(" "))
//    }

//    fun clash() {
//        var s = "easy peasy"
//        var t = ""
//
//        for (l in s) {
//            val p = l.code - 96
//            if (p < 0) t += " "
//            else if (p % 2 == 0) t += "N"
//            else if (p % 3 == 0) t += "O"
//            else if (p % 5 == 0) t += "S"
//            else t += "E"
//        }
//
//        println(t)
//    }

//    fun clash() {
//        val metals = "Ag 27 Pb 10 Au 5"
//
//        val chunked = metals.split(" ")
//
//        val ag = chunked[1].toInt()
//        var pb = chunked[3].toInt()
//        val au = chunked[5].toInt()
//
//        val fakeAu = minOf(pb, (au - 1) / 2)
//        val totalValue = ag * 10 + (au + fakeAu) * 100 + (pb - fakeAu)
//
//        println("Edward can make $totalValue coins today")
//    }

//    fun clash() {
//        val bla = "bla df"
//
//        val chunked = bla.split(" ")
//
//        println(chunked.reversed().joinToString(" "))
//    }
}