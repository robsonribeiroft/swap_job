import java.io.File

class FileHelper(private var listener: Listeners.ReadFile) : Thread() {

    private val value: ArrayList<Char> = ArrayList()
    private val command: ArrayList<Char> = ArrayList()

    init {
        Thread(this).start()
    }

    override fun run() {
        super.run()
        File("/home/robson/IdeaProjects/SwapJob/src/REFERENCIAS_100.TXT").forEachLine { line: String ->
            line.forEachIndexed { index, char ->
                if (char.toByte().toInt() in 48..57){
                    value.add(char)
                    command.add(line[index+1])
                }
            }
        }
        listener.fileComplete(value, command)
    }


}