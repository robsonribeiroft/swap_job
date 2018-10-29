package swap

abstract class Swap(private val lowestFrame: Int,
                    private val biggerFrame: Int,
                    private val values: ArrayList<Char>,
                    private val listeners: Listeners.Swap): Thread(){

    private var memory: ArrayList<Char> = ArrayList()
    private var hits = 0
    private val results = ArrayList<Int>()

    fun isComplete():Boolean = (biggerFrame-lowestFrame+1) == results.size
}