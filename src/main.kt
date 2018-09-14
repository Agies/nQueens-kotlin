fun main(args: Array<String>) {
    for (n in 1..17) {
        val solver = Solver(n)
        val result = solver.run()
        println(result)
    }
}