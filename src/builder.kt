import java.lang.StringBuilder
import java.util.*

class Solver(private val n: Int) {
    private lateinit var board: IntArray
    private var count: Int = 0
//    private val solutions = mutableListOf<String>()
    fun run(): Result {
        board = IntArray(n + 1)
//        solutions.clear()
        count = 0
        val startTime = Date().time
        solve()
        return Result(n, Date().time - startTime, count)
    }

    private fun solve(row: Int = 1) {
        loop@ for (x in 1..n) {
            for (y in 1 until row) {
                if (board[y] == x) continue@loop
                if (row - y == Math.abs(x - board[y])) continue@loop
            }
            board[row] = x
            if (row < n) {
                solve(row + 1)
            } else {
                count++
//                solutions.add(board.drop(1).map { it - 1 }.toString())
            }
        }
    }
}

data class Result(val n: Int, val time: Long, val solutions: Int) {
    override fun toString(): String {
        val builder = StringBuilder()
        builder.appendln("For a $n x $n board:")
        builder.appendln("\tSolutions = $solutions")
        builder.appendln("\tSolve Time = ${time}ms")
        return builder.toString()
    }
}