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
//        println("name: ${file.path}")
        FileHelper(this)
    }

    override fun fileComplete(result: Pair<ArrayList<String>, ArrayList<Char>>) {
        for (i in start..end){
            FIFO(i, result.first, this)
            SecondChance(i, result.first, 10, this)
        }
    }

    override fun swapComplete(triple: Triple<String, Int, Int>) {
        results.add(triple)

        if (isFinished()){
            val fifo = results.filter { it.first==FIFO.TAG }
                    .sortedBy { it.second }
                    .map { it.third }

            println(fifo)
        }
    }

    @Synchronized
    private fun isFinished():Boolean = (end - start+1)*2 == results.size

}
