interface Listeners {

    interface ReadFile{
        fun fileComplete(result: Pair<ArrayList<String>, ArrayList<Char>>)
    }

    interface Swap{
        fun swapComplete(triple: Triple<String, Int, Int>)
    }
}