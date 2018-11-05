package extensions

fun <T> ArrayList<T>?.removeFirst() {
    if (this == null || isEmpty()) throw NullPointerException("ArrayList is null or Empty")
    removeAt(0)

}

fun <T> ArrayList<T>?.moveToDown(){
    if (this == null) throw NullPointerException("ArrayList is null")
    add(first())
    removeFirst()
}
