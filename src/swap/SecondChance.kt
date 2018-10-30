package swap

import extensions.moveToDown
import extensions.removeFirst

class SecondChance(frame: Int,
                   values: ArrayList<Char>,
                   zero: Int,
                   listener: Listeners.Swap): Swap(frame, values, listener, zero) {

    init {
        Thread(this).start()
    }

    override fun run() {
        super.run()
        values.forEachIndexed { index, char ->
            when{
                (index%zero==0) && index!=0 -> clearBitR()
                char in memory->{
                    memory.forEachIndexed { mi, c ->
                        if (c == char) R[mi] = true
                    }
                    hits++
                }
                memory.size < frame->{
                    memory.add(char)
                    R.add(true)
                }
                else->{

                    while(R.first()){
                        memory.moveToDown()
                        R.removeFirst()
                        R.add(false)
                    }

                    memory.moveToDown()
                    R.removeFirst()
                    R.add(true)

                }

            }
        }
        listener.swapComplete(Triple("SC", frame, hits))
    }


}