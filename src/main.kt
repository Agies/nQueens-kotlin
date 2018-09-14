fun main(args: Array<String>) {
    for (n in 1..15) {
        val solver = Solver(n)
        val result = solver.run()
        println(result)
    }
}