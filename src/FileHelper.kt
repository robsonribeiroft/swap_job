import extensions.concat
import extensions.toDec
import java.io.File

class FileHelper(private var listener: Listeners.ReadFile?=null) : Thread() {

    init {
        Thread(this).start()
    }

    override fun run() {
        super.run()
        File("/home/robson/IdeaProjects/SwapJob/src/REFERENCIAS_100k.TXT").forEachLine { line: String ->
             listener?.fileComplete(line.fold(Pair(ArrayList(), ArrayList())){ acc, c->
                 when{
                     acc.first.isEmpty() || c == '-' -> acc.first.add("")
                     c.toDec() in 48..57 -> acc.first.concat(c)
                     else-> acc.second.add(c)
                 }
                 return@fold acc
             })
        }

    }


}