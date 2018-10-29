import swap.FIFO

object Main: Listeners.ReadFile, Listeners.Swap{

    lateinit var fifo: FIFO

    @JvmStatic
    fun main(args: Array<String>) {
        FileHelper(this)
    }

    override fun fileComplete(value: ArrayList<Char>, command: ArrayList<Char>) {
        fifo = FIFO(3, 4, value, this)
    }


    override fun swapComplete() {
        println("fifo is ${fifo.isComplete()}")
    }

}
