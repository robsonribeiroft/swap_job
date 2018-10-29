import swap.FIFO
import swap.SecondChance

object Main: Listeners.ReadFile, Listeners.Swap{

    lateinit var fifo: FIFO
    lateinit var sc: SecondChance

    @JvmStatic
    fun main(args: Array<String>) {
        FileHelper(this)
    }

    override fun fileComplete(value: ArrayList<Char>, command: ArrayList<Char>) {
        fifo = FIFO(3, 4, value, this)
        sc = SecondChance(3, 4, 2, value, this)
    }


    override fun swapComplete() {
        println("fifo is ${fifo.isComplete()}")
        println("sc is ${sc.isComplete()}")
    }

}
