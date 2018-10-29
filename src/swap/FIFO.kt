package swap

import Listeners

class FIFO(private val lowestFrame: Int,
           private val biggerFrame: Int,
           private val values: ArrayList<Char>,
           private val listeners: Listeners.Swap): Thread() {

    private var memory: ArrayList<Char> = ArrayList()
    private var hits = 0
    private val results = ArrayList<Int>()

    init {
        Thread(this).start()
    }

    fun isComplete():Boolean = (biggerFrame-lowestFrame+1) == results.size

    override fun run() {
        super.run()

        for (i in lowestFrame..biggerFrame){

            memory = ArrayList()

            values.forEach {
                when{
                    it in memory -> hits++
                    i == memory.size ->{
                        memory.removeAt(0)
                        memory.add(it)
                    }
                    else -> memory.add(it)
                }
            }
            results.add(hits)
            hits = 0
        }
        listeners.swapComplete()
    }
}