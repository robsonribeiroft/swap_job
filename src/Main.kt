import swap.FIFO
import swap.SecondChance
import java.util.*

object Main: Listeners.ReadFile, Listeners.Swap{


    private const val start = 3
    private const val end = 5
    private val results = ArrayList<Triple<String, Int, Int>>()

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

    override fun swapComplete(triple: Triple<String, Int, Int>) {
        results.add(triple)

        if ((end - start+1)*2 == results.size){
            results.sortBy(Triple<*, Int, *>::second)
            val fifos = results.fold(ArrayList<Triple<String, Int, Int>>()){acc, c-> divide("FIFO", acc, c)}
            println("$fifos")

        }
    }

    private fun divide(section: String, acc: ArrayList<Triple<String, Int, Int>>, c: Triple<String, Int, Int>): ArrayList<Triple<String, Int, Int>> {
        return if (c.first == section) {
            acc.add(c)
            return acc
        } else{
            acc
        }
    }


}
