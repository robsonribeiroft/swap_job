package swap

open class Swap(protected val frame: Int,
                    protected val values: ArrayList<String>,
                    protected val listener: Listeners.Swap,
                    protected val zero: Int=1,
                    protected val commands: ArrayList<Char>?=null): Thread(){

    protected var memory: ArrayList<String> = ArrayList()
    protected var R: ArrayList<Boolean> = ArrayList()
    protected var M: ArrayList<Boolean> = ArrayList()
    protected var hits = 0

    protected fun clearBitR(){
        for (i in 0 until R.size) R[i] = false
    }
}