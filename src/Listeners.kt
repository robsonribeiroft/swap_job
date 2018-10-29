interface Listeners {

    interface ReadFile{

        fun fileComplete(value: ArrayList<Char>, command: ArrayList<Char>)
    }

    interface Swap{

        fun swapComplete()
    }
}