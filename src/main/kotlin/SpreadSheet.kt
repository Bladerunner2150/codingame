object SpreadSheet {
    fun calc() {
        val N = 100

        val inputs = listOf(
            Triple("SUB", "$47", "$9"),
            Triple("SUB", "44", "$59"),
            Triple("ADD", "$97", "$67"),
            Triple("ADD", "$1", "$1"),
            Triple("SUB", "$57", "$67"),
            Triple("ADD", "$47", "$97"),
            Triple("ADD", "$59", "$59"),
            Triple("SUB", "$50", "$83"),
            Triple("SUB", "$3", "$93"),
            Triple("SUB", "$4", "$74"),
            Triple("SUB", "$38", "$0"),
            Triple("ADD", "$29", "$96"),
            Triple("SUB", "$46", "$97"),
            Triple("SUB", "$5", "$98"),
            Triple("SUB", "$87", "$66"),
            Triple("SUB", "$86", "$25"),
            Triple("SUB", "$1", "$98"),
            Triple("SUB", "$84", "$56"),
            Triple("ADD", "$38", "$78"),
            Triple("ADD", "$46", "$34"),
            Triple("ADD", "$5", "$76"),
            Triple("SUB", "$3", "$93"),
            Triple("ADD", "$19", "$31"),
            Triple("ADD", "$97", "$77"),
            Triple("VALUE", "$54", "_"),
            Triple("SUB", "$6", "$6"),
            Triple("ADD", "$98", "$2"),
            Triple("ADD", "$59", "$67"),
            Triple("SUB", "$36", "$86"),
            Triple("SUB", "$98", "$26"),
            Triple("SUB", "$16", "$7"),
            Triple("VALUE", "$67", "_"),
            Triple("ADD", "$11", "$84"),
            Triple("VALUE", "$63", "_"),
            Triple("ADD", "$3", "$6"),
            Triple("VALUE", "$44", "_"),
            Triple("SUB", "$68", "$5"),
            Triple("ADD", "$7", "$58"),
            Triple("ADD", "$50", "$82"),
            Triple("ADD", "$88", "-936"),
            Triple("ADD", "$43", "$47"),
            Triple("ADD", "$58", "842"),
            Triple("SUB", "$80", "$46"),
            Triple("SUB", "$33", "$96"),
            Triple("SUB", "$43", "$46"),
            Triple("ADD", "$2", "$8"),
            Triple("ADD", "$59", "$9"),
            Triple("VALUE", "$2", "_"),
            Triple("SUB", "$65", "$30"),
            Triple("ADD", "135", "$65"),
            Triple("ADD", "$71", "$93"),
            Triple("ADD", "$96", "$67"),
            Triple("ADD", "$6", "$38"),
            Triple("SUB", "$5", "$8"),
            Triple("SUB", "$67", "$1"),
            Triple("ADD", "$4", "$71"),
            Triple("VALUE", "$67", "_"),
            Triple("SUB", "$93", "$54"),
            Triple("SUB", "$51", "$3"),
            Triple("ADD", "993", "-871"),
            Triple("ADD", "$6", "$6"),
            Triple("SUB", "$71", "$65"),
            Triple("ADD", "$25", "$60"),
            Triple("VALUE", "$59", "_"),
            Triple("ADD", "$6", "$51"),
            Triple("SUB", "$63", "$97"),
            Triple("VALUE", "$67", "_"),
            Triple("SUB", "3", "$59"),
            Triple("ADD", "$88", "$3"),
            Triple("SUB", "$83", "$53"),
            Triple("SUB", "$50", "$49"),
            Triple("ADD", "$60", "865"),
            Triple("VALUE", "$53", "_"),
            Triple("SUB", "$29", "$44"),
            Triple("SUB", "$96", "$25"),
            Triple("ADD", "$21", "$77"),
            Triple("SUB", "$14", "$30"),
            Triple("SUB", "$27", "$50"),
            Triple("ADD", "$51", "$5"),
            Triple("SUB", "$40", "$72"),
            Triple("VALUE", "$90", "_"),
            Triple("ADD", "$87", "$42"),
            Triple("ADD", "$9", "$47"),
            Triple("SUB", "$97", "$1"),
            Triple("ADD", "$21", "$44"),
            Triple("ADD", "$78", "$94"),
            Triple("ADD", "$21", "$71"),
            Triple("ADD", "-730", "$67"),
            Triple("SUB", "$21", "$89"),
            Triple("SUB", "$83", "$25"),
            Triple("ADD", "$47", "$84"),
            Triple("ADD", "$6", "$65"),
            Triple("ADD", "$32", "$22"),
            Triple("ADD", "$27", "$59"),
            Triple("ADD", "$63", "$11"),
            Triple("ADD", "$65", "$60"),
            Triple("ADD", "$59", "$6"),
            Triple("SUB", "$1", "$27"),
            Triple("ADD", "$27", "$83"),
            Triple("SUB", "$19", "$61"),
        )

        val cells = mutableListOf<Cell>()

        for (i in 0 until N) {
            val operation = inputs[i].first
            val arg1 = inputs[i].second
            val arg2 = inputs[i].third

            System.err.println("Triple(\"$operation\", \"$arg1\", \"$arg2\"),")

            if (arg1.startsWith("$") || arg2.startsWith("$")) {
                cells.add(
                    Cell(
                        index = i,
                        isSolved = false,
                        operation = operation,
                        arg1 = arg1,
                        arg2 = arg2
                    )
                )
            } else {
                var solution = when (operation) {
                    "ADD" -> arg1.toInt() + arg2.toInt()
                    "SUB" -> arg1.toInt() - arg2.toInt()
                    "MULT" -> arg1.toInt() * arg2.toInt()
                    else -> arg1.toInt()
                }

                cells.add(
                    Cell(
                        index = i,
                        isSolved = true,
                        solution = solution
                    )
                )
            }
        }

        while (cells.any { !it.isSolved }) {
            for (cell in cells.filter { !it.isSolved }) {
                solveCell(cells, cell)
            }
        }

        cells.forEach { println(it.solution) }
    }
}

data class Cell(
    val index: Int,
    var isSolved: Boolean,
    var solution: Int? = null,
    val operation: String? = null,
    val arg1: String? = null,
    val arg2: String? = null
)

fun solveCell(cells: List<Cell>, cell: Cell) {
    val cellIndex1ToFind = if (cell.arg1!!.startsWith("$")) cell.arg1.removePrefix("$").toInt() else null
    val cellIndex2ToFind =
        if (cell.operation != "VALUE" && cell.arg2!!.startsWith("$")) cell.arg2.removePrefix("$").toInt() else null

    val cell1 = cells.firstOrNull { it.index == cellIndex1ToFind && it.isSolved }
    val cell2 = cells.firstOrNull { it.index == cellIndex2ToFind && it.isSolved }

    // Check if the referenced cells are solved, else return
    if ((cellIndex1ToFind != null && cell1 == null) || (cellIndex2ToFind != null && cell2 == null)) return

    val number1 = cell1?.solution ?: cell.arg1.toInt()
    val number2 = if (cell.operation != "VALUE")
        cell2?.solution ?: cell.arg2?.toInt() else 0

    cell.solution = when (cell.operation) {
        "ADD" -> number1 + number2!!
        "SUB" -> number1 - number2!!
        "MULT" -> number1 * number2!!
        else -> number1
    }

    cell.isSolved = true
}