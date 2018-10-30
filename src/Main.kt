import swap.FIFO
import swap.SecondChance
import java.util.*

object Main: Listeners.ReadFile, Listeners.Swap{


    private const val start = 3
    private const val end = 5
    private val results = ArrayList<Triple<*,Int,*>>()

    @JvmStatic
    fun main(args: Array<String>) {
        FileHelper(this)
    }

    override fun fileComplete(value: ArrayList<Char>, command: ArrayList<Char>) {
        for (i in start..end){
            FIFO(i, value, this)
            SecondChance(i, value, 10, this)
        }
    }

    override fun swapComplete(triple: Triple<*, Int, *>) {
        results.add(triple)

        if ((end- start+1)*2 == results.size){
            results.sortBy(Triple<*, Int, *>::second)
            println("$results")
        }
    }


}
