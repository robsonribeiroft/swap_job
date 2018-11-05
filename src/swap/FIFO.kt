package swap

import extensions.moveToDown

class FIFO(frame: Int,
           values: ArrayList<String>,
           listener: Listeners.Swap): Swap(frame, values, listener) {

    init {
        Thread(this).start()
    }

    override fun run() {
        super.run()

        values.forEach {
            when{
                it in memory -> hits++
                frame == memory.size ->{
                    memory.moveToDown()
                }
                else -> memory.add(it)
            }
        }
        listener.swapComplete(Triple(TAG, frame, hits))
    }

    companion object {
        const val TAG = "FIFO"
    }


}