import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt

object Defibrillators {
    fun defib() {
        val LON = "3,879483"
        val LAT = "43,608177"
        val N = 3

        val lines = listOf(
            "2;Hotel de Ville;1 place Georges Freche 34267 Montpellier;;3,89652239197876;43,5987299452849",
            "3;Zoo de Lunaret;50 avenue Agropolis 34090 Mtp;;3,87388031141133;43,6395872778854",
            "1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217",
        )

        val lon = degreesToRadians(LON.replace(",", ".").toFloat())
        val lat = degreesToRadians(LAT.replace(",", ".").toFloat())

        System.err.println("LON = $lon")
        System.err.println("LAT = $lat")

        val defibs = mutableListOf<Pair<String, Float>>()

        for (line in lines) {
            val DEFIB = line

            val data = DEFIB.split(";")

            val defibName = data[1]
            val defibLon = degreesToRadians(data[data.size - 2].replace(",", ".").toFloat())
            val defibLat = degreesToRadians(data.last().replace(",", ".").toFloat())

            System.err.println("Defib: $defibName -> $defibLon x $defibLat")

            val distance = calc(lon, lat, defibLon, defibLat)

            System.err.println("Distance = $distance")

            defibs.add(Pair(defibName, distance))
        }

        defibs.sortBy { x -> x.second }

        println(defibs.first().first)
    }

    fun calc(lonA: Float, latA: Float, lonB: Float, latB: Float): Float {
        val x = (lonB - lonA) * cos((latA + latB) / 2)
        val y = latB - latA

        return sqrt(x.pow(2) + y.pow(2)) * 6371
    }

    fun degreesToRadians(degrees: Float): Float {
        return degrees * (PI / 180).toFloat()
    }
}