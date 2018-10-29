package swap

import removeFirst

class SecondChance(private val lowestFrame: Int,
                   private val biggerFrame: Int,
                   private val zero: Int,
                   private val values: ArrayList<Char>,
                   private val listeners: Listeners.Swap): Thread() {

    private var memory: ArrayList<Char> = ArrayList()
    private var R: ArrayList<Boolean> = ArrayList()
    private var hits = 0
    private val results = ArrayList<Int>()

    private fun clearBitR(){
        for (i in 0 until R.size){
            R[i] = false
        }
    }

    fun isComplete():Boolean = (biggerFrame-lowestFrame+1) == results.size

    override fun run() {
        super.run()
        for (i in lowestFrame..biggerFrame){
            memory = ArrayList()
            R = ArrayList()
            hits = 0
            values.forEachIndexed { index, char ->
                when{
                    (index%zero==0) && index!=0->{
                        clearBitR()
                    }
                    char in memory->{
                        memory.forEachIndexed { mi, c ->
                            if (c == char) R[mi] = true
                        }
                        hits++
                    }
                    memory.size < i->{
                        memory.add(char)
                        R.add(true)
                    }
                    else->{
                        var carry: Char = memory.first()

                        while(R.first()){
                            R.removeAt(0)
                            carry = memory.first()
                            memory.removeFirst()
                            memory.add(carry)
                            R.add(false)
                        }

                        memory.removeFirst()
                        R.removeFirst()
                        memory.add(carry)
                        R.add(true)
                    }

                }
            }
            results.add(hits)
        }
    }


}