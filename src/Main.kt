import swap.FIFO
import swap.SecondChance
import java.io.FileInputStream
import java.util.*
import javax.swing.JFileChooser
import javax.swing.JWindow
import kotlin.collections.ArrayList

object Main: Listeners.ReadFile, Listeners.Swap{


    private const val start = 3
    private const val end = 5
    private val results = ArrayList<Triple<String, Int, Int>>()

    @JvmStatic
    fun main(args: Array<String>) {

//        val jWindow = JWindow()
//        val fileChooser = JFileChooser()
//        fileChooser.showOpenDialog(jWindow)
//        val file = fileChooser.selectedFile
//        val stream = FileInputStream(file)
//
//
//        println("name: ${file.path}")
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
            val fifo = results.filter { it.first==FIFO.TAG }
                    .sortedBy { it.second }
                    .map { it.third }

//            fifo = results.filter { it.first==FIFO.TAG }
//                    .withIndex()
//                    .sortedBy { (i, t) -> t.second }
//                    .map { (i, t) -> t.third }

//            results.sortBy(Triple<*, Int, *>::second)
//            fifo = results.fold(ArrayList<Triple<String, Int, Int>>()){
//                acc, c-> divide(SecondChance.TAG, acc, c)
//            }.map { it.third }

            println(fifo)

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
