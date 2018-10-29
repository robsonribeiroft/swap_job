package swap

class SecondChance(private val lowestFrame: Int,
                   private val biggerFrame: Int,
                   private val zero: Int,
                   private val values: ArrayList<Char>,
                   private val listeners: Listeners.Swap): Thread() {

    private var memory: ArrayList<Char> = ArrayList()
    private var R: ArrayList<Boolean> = ArrayList()
    private var hits = 0
    private val results = ArrayList<Int>()

    fun clearBitR(){
        R.forEach { it ->
            it
        }
    }

    override fun run() {
        super.run()

    }


}